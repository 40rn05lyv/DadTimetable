package org.lovecorp.timetable.domain;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private static int idCounter = 0;

    private int id;
    private String name;
    // private String shortName;
    // private List<Lector> possibleLectors;
    private boolean hasTraditionalRooms;
    private List<Room> traditionalRooms;
    private List<Room> impossibleRooms;

    public Subject() {
        this.id = idCounter++;
    }

    public boolean hasTraditionalRooms() {
        return hasTraditionalRooms;
    }

    public void setHasTraditionalRooms(boolean hasTraditionalRooms) {
        this.hasTraditionalRooms = hasTraditionalRooms;
    }

    public List<Room> getTraditionalRooms() {
        return traditionalRooms;
    }

    public void setTraditionalRooms(List<Room> traditionalRooms) {
        this.traditionalRooms = traditionalRooms;
    }

    public List<Room> getImpossibleRooms() {
        return impossibleRooms;
    }

    public void setImpossibleRooms(List<Room> impossibleRooms) {
        this.impossibleRooms = impossibleRooms;
    }

    /*
     * public List<Lector> getPossibleLectors() { return possibleLectors; }
     * 
     * public void setPossibleLectors(List<Lector> possibleLectors) {
     * this.possibleLectors = possibleLectors; }
     */
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addTraditionalRoom(Room room) {
        if (this.traditionalRooms == null) {
            this.traditionalRooms = new ArrayList<Room>();
        }
        this.traditionalRooms.add(room);
    }

    public void addImpossibleRoom(Room room) {
        if (this.impossibleRooms == null) {
            this.impossibleRooms = new ArrayList<Room>();
        }
        this.impossibleRooms.add(room);        
    }

    /*
     * public String getShortName() { return shortName; }
     * 
     * public void setShortName(String shortName) { this.shortName = shortName;
     * }
     */

}
