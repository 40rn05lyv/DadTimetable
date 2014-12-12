package org.lovecorp.timetable.domain;

import java.util.Date;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class Lesson {

    private Long id;
    private Group group;
    private Room room;
    private Date date;
    private Period period;
    private Subject subject;
    private Lector lector;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @PlanningVariable(nullable=false, valueRangeProviderRefs="groupList")
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @PlanningVariable(nullable=false, valueRangeProviderRefs="roomList")
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @PlanningVariable(nullable=false, valueRangeProviderRefs="dateList")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @PlanningVariable(nullable=false, valueRangeProviderRefs="periodList")
    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    @PlanningVariable(nullable=false, valueRangeProviderRefs="subjectList")
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @PlanningVariable(nullable=false, valueRangeProviderRefs="lectorList")
    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

}
