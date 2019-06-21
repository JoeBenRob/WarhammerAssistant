package com.bae.persistence.repository;

public interface UnitRepo {
	
	String getAllUnit();
	String createUnit(String unit);
	String deleteUnit(int id);
	String updateUnit(int id, String unit);
	String getAUnit(int id);

}
