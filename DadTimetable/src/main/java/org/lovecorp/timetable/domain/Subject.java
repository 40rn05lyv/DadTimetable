package org.lovecorp.timetable.domain;

import java.util.List;

public class Subject {

    private Long id;
    private String name;
    private String shortName;
    private List<Lector> possibleLectors;
    private boolean specializedRoomOnly;
    private List<Room> specializedRooms;
    private List<Room> impossibleRooms;

    public boolean isSpecializedRoomOnly() {
        return specializedRoomOnly;
    }

    public void setSpecializedRoomOnly(boolean specializedRoomOnly) {
        this.specializedRoomOnly = specializedRoomOnly;
    }

    public List<Room> getSpecializedRooms() {
        return specializedRooms;
    }

    public void setSpecializedRooms(List<Room> specializedRooms) {
        this.specializedRooms = specializedRooms;
    }

    public List<Room> getImpossibleRooms() {
        return impossibleRooms;
    }

    public void setImpossibleRooms(List<Room> impossibleRooms) {
        this.impossibleRooms = impossibleRooms;
    }

    public List<Lector> getPossibleLectors() {
        return possibleLectors;
    }

    public void setPossibleLectors(List<Lector> possibleLectors) {
        this.possibleLectors = possibleLectors;
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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

}
