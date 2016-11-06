package com.webapp.knowlin.services;

import java.util.List;

import com.webapp.knowlin.model.Floor;

public interface FloorService {
	
	public boolean addFloors(List<Floor> floors) throws Exception;
	
	public List<Floor> getFloorsByBuildingById(int testId);

}
