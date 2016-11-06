package com.webapp.knowlin.services;

import java.util.List;

import com.webapp.knowlin.model.Building;

public interface BuildingService {

	public boolean create(Building building) throws Exception;
	
	public Building getBuildingById(int id) throws Exception;
	
	public List<Building> getAllBuildings() throws Exception;
	
	public boolean editBuilding(Building building) throws Exception;
	
	public boolean updateBuildingStatus(Building building) throws Exception;
	
	public boolean removeBuilding(Building building) throws Exception;
	
}
