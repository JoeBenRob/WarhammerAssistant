package com.bae.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Unit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String army;
	private String allegiance;
	private int min;
	private int max;
	private int points;
	
	public Unit(int id, String name, String army, String allegiance, int min, int max, int points) {
		super();
		this.id = id;
		this.name = name;
		this.army = army;
		this.allegiance = allegiance;
		this.min = min;
		this.max = max;
		this.points = points;
	}

	public Unit() {
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

	public String getArmy() {
		return army;
	}

	public void setArmy(String army) {
		this.army = army;
	}

	public String getAllegiance() {
		return allegiance;
	}

	public void setAllegiance(String allegiance) {
		this.allegiance = allegiance;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
}
