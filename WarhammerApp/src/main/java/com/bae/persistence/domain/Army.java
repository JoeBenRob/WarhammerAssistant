package com.bae.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Army {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String allegiance;
	public Army(int id, String name, String allegiance) {
		super();
		this.id = id;
		this.name = name;
		this.allegiance = allegiance;
	}
	
	public Army() {
		super();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAllegiance() {
		return allegiance;
	}
	
	public void setAllegiance(String allegiance) {
		this.allegiance = allegiance;
	}
	
}
