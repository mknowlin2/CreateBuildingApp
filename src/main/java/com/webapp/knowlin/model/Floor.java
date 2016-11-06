package com.webapp.knowlin.model;

public class Floor {
	private int buildingId;
	private int floorNumber;
	private int roomCount;

	public Floor() {
		this.floorNumber = 1;
		this.roomCount = 1;
	}

	public int getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public int getRoomCount() {
		return roomCount;
	}

	public void setRoomCount(int roomCount) {
		this.roomCount = roomCount;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!Floor.class.isAssignableFrom(obj.getClass())) {
			return false;
		}

		final Floor other = (Floor) obj;

		if (this.buildingId != other.buildingId) {
			return false;
		}

		if (this.floorNumber != other.floorNumber) {
			return false;
		}

		if (this.roomCount != other.roomCount) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 53 * hash + this.buildingId;
		hash = 53 * hash + this.floorNumber;
		hash = 53 * hash + this.roomCount;
		return hash;
	}

}
