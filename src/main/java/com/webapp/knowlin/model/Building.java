package com.webapp.knowlin.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Building {
	private int buildingId;
	private String name;
	private StatusCd statCd;
	private Date buildDt;
	private Date demolishDt;
	private Address address;
	private List<Floor> floors;

	public Building() {
		this.address = new Address();
		this.floors = new ArrayList<Floor>();
		this.floors.add(new Floor());
	}

	public int getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StatusCd getStatCd() {
		return statCd;
	}

	public void setStatCd(StatusCd statCd) {
		this.statCd = statCd;
	}

	public Date getBuildDt() {
		return buildDt;
	}

	public void setBuildDt(Date buildDt) {
		this.buildDt = buildDt;
	}

	public Date getDemolishDt() {
		return demolishDt;
	}

	public void setDemolishDt(Date demolishDt) {
		this.demolishDt = demolishDt;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Floor> getFloors() {
		return floors;
	}

	public void setFloors(List<Floor> floors) {
		this.floors = floors;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!Building.class.isAssignableFrom(obj.getClass())) {
			return false;
		}

		final Building other = (Building) obj;

		if (this.name != null) {
			if (!this.name.equals(other.name)) {
				return false;
			}
		} else if ((this.name == null) && (other.name != null)) {
			return false;
		}

		if (!this.address.equals(address)) {
			return false;
		}

		if (this.buildDt != null) {
			if (!this.buildDt.equals(other.buildDt)) {
				return false;
			}
		} else if ((this.buildDt == null) && (other.buildDt != null)) {
			return false;
		}

		if (this.demolishDt != null) {
			if (!this.demolishDt.equals(other.demolishDt)) {
				return false;
			}
		} else if ((this.demolishDt == null) && (other.demolishDt != null)) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 53 * hash + (this.name != null ? this.name.hashCode() : 0);
		hash = 53 * hash + (this.buildDt != null ? this.buildDt.hashCode() : 0);
		hash = 53 * hash + (this.demolishDt != null ? this.demolishDt.hashCode() : 0);
		return hash;
	}
}
