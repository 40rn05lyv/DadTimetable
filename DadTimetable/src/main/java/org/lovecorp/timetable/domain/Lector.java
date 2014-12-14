package org.lovecorp.timetable.domain;

public class Lector {

	private static int idCounter = 0;
	
    private int id;
    private String name;
    private boolean coworker;
    
    public Lector() {
		this.id = idCounter++;
	}

    public boolean isCoworker() {
        return coworker;
    }

    public void setCoworker(boolean coworker) {
        this.coworker = coworker;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
