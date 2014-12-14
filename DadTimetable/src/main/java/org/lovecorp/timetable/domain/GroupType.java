package org.lovecorp.timetable.domain;

public enum GroupType {

    WORKERS(30), YOUNGERS(36);

    private int lessonsPerWeek;

    private GroupType(int lessonsPerWeek) {
        this.lessonsPerWeek = lessonsPerWeek;
    }

    public int getLessonsPerWeek() {
        return lessonsPerWeek;
    }

}