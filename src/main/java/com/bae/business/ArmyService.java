package com.bae.business;

public interface ArmyService {
	
	String createArmy(String army);
	String getAllArmy();
	String getAnArmy(int id);
	String updateArmy(int id, String unit);
	String deleteArmy(int id);

}
