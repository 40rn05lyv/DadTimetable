package org.lovecorp.timetable.domain;

public class Room {

    private Long id;
    private String name;
    private Integer capacity;
    private Lector responsibleLector;

    public Lector getResponsibleLector() {
        return responsibleLector;
    }

    public void setResponsibleLector(Lector responsibleLector) {
        this.responsibleLector = responsibleLector;
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
