package org.lovecorp.timetable.domain;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.Solution;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

@PlanningSolution
public class Timetable implements Solution<HardSoftScore> {

    private HardSoftScore score;

    private List<Group> groups;
    private List<Lector> lectors;
    private List<Room> rooms;
    private List<Subject> subjects;
    private List<Date> dates;
    private List<Period> periods;

    private List<Lesson> lessons;

    @ValueRangeProvider(id = "groupList")
    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @ValueRangeProvider(id = "periodList")
    public List<Period> getPeriods() {
        return periods;
    }

    public void setPeriods(List<Period> periods) {
        this.periods = periods;
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

    public void setRooms(List<Room> room) {
        this.rooms = room;
    }

    @ValueRangeProvider(id = "subjectList")
    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
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

}
