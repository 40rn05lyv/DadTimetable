package org.lovecorp.timetable.domain;

import java.util.ArrayList;
import java.util.List;

public class Room {

	private static int idCounter = 0;

	private int id;
	private String name;
	private Integer capacity;
	private List<Lector> responsibleLectors;

	public Room() {
		this.id = idCounter++;
	}

	public List<Lector> getResponsibleLectors() {
		return responsibleLectors;
	}
	
	public void addResponsibleLector(Lector responsibleLector) {
		if (this.responsibleLectors == null) {
			this.responsibleLectors = new ArrayList<Lector>();
		}
		this.responsibleLectors.add(responsibleLector);
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

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

}
