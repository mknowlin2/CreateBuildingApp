package com.webapp.knowlin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.webapp.knowlin.model.Floor;
import com.webapp.knowlin.persistence.FloorMapper;

public class FloorServiceImpl implements FloorService {

	@Autowired
	private FloorMapper floorMapper;
	
	@Override
	public boolean addFloors(List<Floor> floors) throws Exception {
		boolean returnVal = false;
		try {
			
			for(Floor floor : floors){
				floorMapper.addFloor(floor);
			}
			
			returnVal = true;
		} catch (Exception e) {
			throw new Exception(e);
		}

		return returnVal;
	}
	
	@Override
	public List<Floor> getFloorsByBuildingById(int buildingId) {
		return floorMapper.getFloorsByBuildingById(buildingId);
	}

	public FloorMapper getFloorMapper() {
		return floorMapper;
	}

	public void setFloorMapper(FloorMapper floorMapper) {
		this.floorMapper = floorMapper;
	}
}
