package com.webapp.knowlin.persistence;

import java.util.List;

import com.webapp.knowlin.model.Building;

public interface BuildingMapper {

	void createBuilding(Building building);

	Building getBuildingById(int id);

	List<Building> getAllBuildings();

	void editBuildingName(Building building);

	void removeBuilding(Building building);

	void updateBuildingStatus(Building building);

}
