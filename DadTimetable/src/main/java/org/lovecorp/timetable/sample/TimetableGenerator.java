package org.lovecorp.timetable.sample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.lovecorp.timetable.domain.Group;
import org.lovecorp.timetable.domain.Group.GroupSubject;
import org.lovecorp.timetable.domain.GroupType;
import org.lovecorp.timetable.domain.Lector;
import org.lovecorp.timetable.domain.Room;
import org.lovecorp.timetable.domain.Subject;
import org.lovecorp.timetable.domain.Timetable;

public class TimetableGenerator {

    public Timetable createTimetable() {
        Timetable t = new Timetable();
        
        List<Date> dates = new ArrayList<Date>();
        dates.add(new Date());
        t.setDates(dates);
        
        GroupType groupType1 = new GroupType();
        groupType1.setId(1L);
        groupType1.setLessonsPerWeek(30);

        GroupType groupType2 = new GroupType();
        groupType2.setId(2L);
        groupType2.setLessonsPerWeek(36);
        
        List<Group> groups = new ArrayList<Group>();
        Group group1 = new Group();
        group1.setId(1L);
        group1.setName("group1");
        group1.setGroupType(groupType1);
        List<GroupSubject> groupSubjects1 = new ArrayList<GroupSubject>();
        groups.add(new Group());
        t.setGroups(groups);

        List<Lector> lectors = new ArrayList<Lector>();
        lectors.add(new Lector());
        t.setLectors(lectors);

        List<Room> rooms = new ArrayList<Room>();
        rooms.add(new Room());
        t.setRooms(rooms);

        List<Subject> subjects = new ArrayList<Subject>();
        t.setSubjects(subjects);

        return t;
    }

}
