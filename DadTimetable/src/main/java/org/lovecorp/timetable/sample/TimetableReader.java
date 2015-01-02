package org.lovecorp.timetable.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.lovecorp.timetable.domain.EducationalProcessSchedule;
import org.lovecorp.timetable.domain.EducationalProcessSchedule.ActivityType;
import org.lovecorp.timetable.domain.Group;
import org.lovecorp.timetable.domain.Group.GroupSubject;
import org.lovecorp.timetable.domain.GroupType;
import org.lovecorp.timetable.domain.Lector;
import org.lovecorp.timetable.domain.Room;
import org.lovecorp.timetable.domain.Subject;
import org.lovecorp.timetable.domain.Timetable;

public class TimetableReader {

    public Timetable read(File file) throws FileNotFoundException, IOException {
        Timetable t = new Timetable();
        Workbook wb = new HSSFWorkbook(new FileInputStream(file));

        readEducationalProcessSchedule(wb.getSheetAt(0), t);
        readLectors(wb.getSheetAt(1), t);
        readSubjects(wb.getSheetAt(2), t);
        readSubjectsToRooms(wb.getSheetAt(3), t);
        readGroupTypes(wb.getSheetAt(4), t);

        return t;
    }

    /***
     * Adds groups and educational process schedule for them
     */
    private void readEducationalProcessSchedule(Sheet sheet, Timetable t) {
        EducationalProcessSchedule educationalProcessSchedule = t.getEducationalProcessSchedule();
        List<Group> groups = t.getGroups();

        for (Row row : sheet) {
            // Skip first 3 rows
            if (row.getRowNum() <= 2) {
                continue;
            }
            // Stop when first cell of row is empty
            if (row.getCell(0) == null || StringUtils.isEmpty(row.getCell(0).getStringCellValue())) {
                break;
            }

            Group group = new Group();
            for (Cell cell : row) {
                if (cell.getColumnIndex() == 0) {
                    group.setName(cell.getStringCellValue().trim());
                    groups.add(group);
                }

                // TODO
                educationalProcessSchedule.put(group, new Date(), ActivityType.THEORY);
            }
        }
    }

    /***
     * Reads lectors from the sheet to timetable
     */
    private void readLectors(Sheet sheet, Timetable t) {
        List<Lector> lectors = t.getLectors();
        List<Room> rooms = t.getRooms();
        Map<String, Room> roomMap = new HashMap<String, Room>();
        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue;
            }
            String lectorName = row.getCell(0).getStringCellValue().trim();
            String roomName = getCellValue(row.getCell(1)).trim();
            String lectorCoworker = row.getCell(2).getStringCellValue().trim();

            Lector lector = new Lector();
            lector.setName(lectorName);
            lector.setCoworker(StringUtils.isEmpty(lectorCoworker));
            lectors.add(lector);

            Room room = null;
            if (roomMap.containsKey(roomName)) {
                room = roomMap.get(roomName);
            } else {
                room = new Room();
                room.setName(roomName);
            }
            room.addResponsibleLector(lector);
            rooms.add(room);
        }
    }

    /***
     * NOTE: <b>groups and lectors</b> are assumed to be already in Timetable instance
     */
    private void readSubjects(Sheet sheet, Timetable t) {
        List<Subject> subjects = t.getSubjects();

        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue;
            }

            String groupName = row.getCell(0).getStringCellValue().trim();
            String subjectName = row.getCell(1).getStringCellValue().trim();
            String lectorName = row.getCell(2).getStringCellValue().trim();
            String hoursString = getCellValue(row.getCell(3)).trim();
            int hours = Integer.valueOf(hoursString);

            Group group = t.getGroup(groupName);
            Subject subject = t.getSubject(subjectName);
            if (subject == null) {
                subject = new Subject();
                subject.setName(subjectName);
                subjects.add(subject);
            }
            Lector lector = t.getLector(lectorName);

            List<GroupSubject> groupSubjects = group.getSubjects();
            groupSubjects.add(group.new GroupSubject(subject, lector, hours));
        }
    }

    /***
     * Read additional information about subjects and rooms
     * 
     * NOTE: <b>subjects and rooms</b> are assumed to be already in Timetable
     * instance
     */
    private void readSubjectsToRooms(Sheet sheet, Timetable t) {
        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue;
            }

            String subjectName = row.getCell(0).getStringCellValue().trim();
            String hasTraditionalRoomsStr = row.getCell(1).getStringCellValue().trim();
            String traditionalRooms = getCellValue(row.getCell(2)).trim();
            String impossibleRooms = row.getCell(3).getStringCellValue().trim();

            Subject subject = t.getSubject(subjectName);
            boolean hasTraditionalRooms = false;
            if (hasTraditionalRoomsStr.equals("Yes")) {
                hasTraditionalRooms = true;
            } else if (hasTraditionalRoomsStr.equals("No")) {
                hasTraditionalRooms = false;
            } else {
                throw new IllegalArgumentException();
            }
            subject.setHasTraditionalRooms(hasTraditionalRooms);
            if (StringUtils.isNotEmpty(traditionalRooms)) {
                for (String roomName : traditionalRooms.split(",")) {
                    Room room = t.getRoom(roomName);
                    subject.addTraditionalRoom(room);
                }
            }
            if (StringUtils.isNotEmpty(impossibleRooms)) {
                for (String roomName : impossibleRooms.split(",")) {
                    Room room = t.getRoom(roomName);
                    subject.addImpossibleRoom(room);
                }
            }
        }
    }

    /***
     * Read group types
     * 
     * NOTE: <b>groups</b> are assumed to be already in Timetable instance
     */
    private void readGroupTypes(Sheet sheet, Timetable t) {
        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue;
            }
            String groupName = row.getCell(0).getStringCellValue().trim();
            String groupTypeName = row.getCell(1).getStringCellValue().trim();

            Group group = t.getGroup(groupName);
            GroupType groupType = null;
            switch (groupTypeName) {
            case "MC":
                groupType = GroupType.YOUNGERS;
                break;
            case "P":
                groupType = GroupType.WORKERS;
                break;
            default:
                break;
            }
            group.setGroupType(groupType);
        }
    }
    
    private String getCellValue(Cell cell) {
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }
        return cell.getStringCellValue();
    }

}
