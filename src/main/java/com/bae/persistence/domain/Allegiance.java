package com.bae.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Allegiance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int allegianceId;
	private String allegiance;
	public Allegiance(int allegianceId, String allegiance) {
		super();
		this.allegianceId = allegianceId;
		this.allegiance = allegiance;
	}
	
	public Allegiance() {
		super();
	}
	
	public int getAllegianceId() {
		return allegianceId;
	}
	
	public void setAllegianceId(int allegianceId) {
		this.allegianceId = allegianceId;
	}
	
	public String getAllegiance() {
		return allegiance;
	}
	
	public void setAllegiance(String allegiance) {
		this.allegiance = allegiance;
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
	
}
