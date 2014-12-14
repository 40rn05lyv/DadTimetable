package org.lovecorp.timetable.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.Solution;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

@PlanningSolution
public class Timetable implements Solution<HardSoftScore> {

    private HardSoftScore score;

    private EducationalProcessSchedule educationalProcessSchedule;
    private List<Group> groups;
    private List<Lector> lectors;
    private List<Room> rooms;
    private List<Subject> subjects;
    private List<Period> periods;
    private List<Date> dates;

    private List<Lesson> lessons;

    public Timetable() {
        this.educationalProcessSchedule = new EducationalProcessSchedule();
        this.groups = new ArrayList<Group>();
        this.lectors = new ArrayList<Lector>();
        this.rooms = new ArrayList<Room>();
        this.subjects = new ArrayList<Subject>();
        this.dates = new ArrayList<Date>();
        this.lessons = new ArrayList<Lesson>();
        this.periods = new ArrayList<Period>();
        this.periods.add(Period.FIRST);
        this.periods.add(Period.SECOND);
        this.periods.add(Period.THIRD);
        this.periods.add(Period.FOURTH);
        this.periods.add(Period.FIFTH);
        this.periods.add(Period.SIXTH);
        this.periods.add(Period.SEVENTH);
    }
    
    @ValueRangeProvider(id = "periodList")
    public List<Period> getPeriods() {
        return periods;
    }

    @ValueRangeProvider(id = "groupList")
    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @ValueRangeProvider(id = "dateList")
    public List<Date> getDates() {
        return dates;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }

    @ValueRangeProvider(id = "lectorList")
    public List<Lector> getLectors() {
        return lectors;
    }

    public void setLectors(List<Lector> lectors) {
        this.lectors = lectors;
    }

    @ValueRangeProvider(id = "roomList")
    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @ValueRangeProvider(id = "subjectList")
    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
    
    

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public EducationalProcessSchedule getEducationalProcessSchedule() {
        return educationalProcessSchedule;
    }

    public void setEducationalProcessSchedule(EducationalProcessSchedule educationalProcessSchedule) {
        this.educationalProcessSchedule = educationalProcessSchedule;
    }
    
    @PlanningEntityCollectionProperty
    public List<Lesson> getLessons() {
        return lessons;
    }

    public HardSoftScore getScore() {
        return this.score;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }

    public Collection<? extends Object> getProblemFacts() {
        // TODO Auto-generated method stub
        return null;
    }

    public Group getGroup(String groupName) {
        for (Group group : groups) {
            if (group.getName().equals(groupName.trim())) {
                return group;
            }
        }
        return null;
    }

    public Subject getSubject(String subjectName) {
        for (Subject subject : subjects) {
            if (subject.getName().equals(subjectName.trim())) {
                return subject;
            }
        }
        return null;
    }

    public Lector getLector(String lectorName) {
        for (Lector lector : lectors) {
            if (lector.getName().equals(lectorName.trim())) {
                return lector;
            }
            if (lector.getName().substring(0, lector.getName().length()-1).equals(lectorName.trim())) {
                return lector;
            }
            if (lector.getName().equals(lectorName.trim().substring(0, lectorName.length()-1))) {
                return lector;
            }
        }
        return null;
    }

    public Room getRoom(String roomName) {
        for (Room room : rooms) {
            if (room.getName().equals(roomName.trim())) {
                return room;
            }
        }
        return null;
    }

}
