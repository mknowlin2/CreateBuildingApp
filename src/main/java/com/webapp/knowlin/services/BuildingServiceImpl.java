package com.webapp.knowlin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.webapp.knowlin.model.Building;
import com.webapp.knowlin.model.Floor;
import com.webapp.knowlin.persistence.BuildingMapper;

public class BuildingServiceImpl implements BuildingService {

	@Autowired
	private AddressService addressServices;
	
	@Autowired
	private FloorService floorServices;
	
	@Autowired
	private BuildingMapper buildingMapper;

	public boolean create(Building building) throws Exception {
		boolean retValue = false;
		try {
			buildingMapper.createBuilding(building);
			
			building.getAddress().setBuildingId(building.getBuildingId());
			addressServices.addAddress(building.getAddress());
			
			for(Floor floor: building.getFloors()){
				floor.setBuildingId(building.getBuildingId());
			}
			
			floorServices.addFloors(building.getFloors());
			retValue = true;
		} catch (Exception e) {
			throw new Exception(e);
		}
		return retValue;
	}

	public Building getBuildingById(int id) throws Exception {
		Building retValue = null;
		
		try {
			retValue = buildingMapper.getBuildingById(id);
			retValue.setAddress(addressServices.getAddressByBuildingId(id));
			retValue.setFloors(floorServices.getFloorsByBuildingById(id));
		} catch(Exception e) {
			throw new Exception(e);
		}
		
		return retValue;
	}
	
	public List<Building> getAllBuildings() throws Exception{
		List<Building> retValue = null;
		
		try {
			retValue = buildingMapper.getAllBuildings();
			for(Building building : retValue) {
				int id = building.getBuildingId();
				building.setAddress(addressServices.getAddressByBuildingId(id));
				building.setFloors(floorServices.getFloorsByBuildingById(id));
			}
		} catch(Exception e) {
			throw new Exception(e);
		}
		
		return retValue;
	}

	public boolean editBuilding(Building building) throws Exception{
		boolean retValue = false;
		try {
			buildingMapper.editBuildingName(building);
			addressServices.editAddress(building.getBuildingId(), building.getAddress());
			retValue = true;
		} catch (Exception e) {
			throw new Exception(e);
		}
		return retValue;
	}
	
	public boolean updateBuildingStatus(Building building) throws Exception{
		boolean retValue = false;
		try {
			buildingMapper.updateBuildingStatus(building);
			retValue = true;
		} catch (Exception e) {
			throw new Exception(e);
		}
		return retValue;
	}

	public boolean removeBuilding(Building building) throws Exception {
		boolean retValue = false;
		try {
			buildingMapper.removeBuilding(building);
			retValue = true;
		} catch (Exception e) {
			throw new Exception(e);
		}
		return retValue;
	}
	
	public AddressService getAddressServices() {
		return addressServices;
	}

	public void setAddressServices(AddressService addressServices) {
		this.addressServices = addressServices;
	}

	public FloorService getFloorServices() {
		return floorServices;
	}

	public void setFloorServices(FloorService floorServices) {
		this.floorServices = floorServices;
	}

	public BuildingMapper getBuildingMapper() {
		return buildingMapper;
	}

	public void setBuildingMapper(BuildingMapper buildingMapper) {
		this.buildingMapper = buildingMapper;
	}
}
