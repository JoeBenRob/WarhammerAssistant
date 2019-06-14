package com.bae.persistence.repository;

public interface AllegianceRepo {
	
	String getAllAllegiance();
	String createAllegiance(String allegiance);
	String deleteAllegiance(int id);
	String updateAllegiance(int id, String user);
	String getAnAllegiance(int id);

}
