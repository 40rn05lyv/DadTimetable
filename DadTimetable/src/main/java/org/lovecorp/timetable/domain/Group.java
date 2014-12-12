package org.lovecorp.timetable.domain;

import java.util.List;

public class Group {

    private Long id;
    private String name;
    private List<GroupSubject> subjects;
    private Integer numberOfStudents;
    private GroupType groupType;

    public class GroupSubject {
        private Subject subject;
        private Lector lector;
        private Integer hours;

        public GroupSubject(Subject subject, Lector lector, Integer hours) {
            super();
            this.subject = subject;
            this.lector = lector;
            this.hours = hours;
        }

        public Subject getSubject() {
            return subject;
        }

        public void setSubject(Subject subject) {
            this.subject = subject;
        }

        public Lector getLector() {
            return lector;
        }

        public void setLector(Lector lector) {
            this.lector = lector;
        }

        public Integer getHours() {
            return hours;
        }

        public void setHours(Integer hours) {
            this.hours = hours;
        }

    }

    public GroupType getGroupType() {
        return groupType;
    }

    public void setGroupType(GroupType groupType) {
        this.groupType = groupType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GroupSubject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<GroupSubject> subjects) {
        this.subjects = subjects;
    }

}
