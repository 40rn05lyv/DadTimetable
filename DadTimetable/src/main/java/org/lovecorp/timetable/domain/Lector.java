package org.lovecorp.timetable.domain;

public class Lector {

    private Long id;
    private String name;
    private boolean coworker;

    public boolean isCoworker() {
        return coworker;
    }

    public void setCoworker(boolean coworker) {
        this.coworker = coworker;
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

}
