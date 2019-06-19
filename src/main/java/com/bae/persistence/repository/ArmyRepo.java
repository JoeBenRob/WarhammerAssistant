package com.bae.persistence.repository;

public interface ArmyRepo {
	
	String getAllArmy();
	String createArmy(String army);
	String deleteArmy(int id);
	String updateArmy(int id, String army);
	String getAnArmy(int id);

}
