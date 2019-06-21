package com.bae.business;

public interface UnitService {
	
	String addUnit(String unit);
	String getAllUnit();
	String getAUnit(int id);
	String updateUnit(int id, String unit);
	String deleteUnit(int id);
}
