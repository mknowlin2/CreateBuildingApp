package com.webapp.knowlin.persistence;

import java.util.List;

import com.webapp.knowlin.model.Floor;

public interface FloorMapper {

	void addFloor(Floor floor);

	List<Floor> getFloorsByBuildingById(int buildingId);

}
