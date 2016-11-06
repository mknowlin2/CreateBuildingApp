package com.webapp.knowlin.model;

public class Address {
	private int buildingId;
	private String street1;
	private String street2;
	private String city;
	private String state;
	private int zipCode;

	public int getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!Address.class.isAssignableFrom(obj.getClass())) {
			return false;
		}

		final Address other = (Address) obj;

		if (this.street1 != null) {
			if (!this.street1.equals(other.street1)) {
				return false;
			}
		} else if ((this.street1 == null) && (other.street1 != null)) {
			return false;
		}

		if (this.street2 != null) {
			if (!this.street2.equals(other.street2)) {
				return false;
			}
		} else if ((this.street2 == null) && (other.street2 != null)) {
			return false;
		}

		if (this.city != null) {
			if (!this.city.equals(other.city)) {
				return false;
			}
		} else if ((this.city == null) && (other.city != null)) {
			return false;
		}

		if (this.state != null) {
			if (!this.state.equals(other.state)) {
				return false;
			}
		} else if ((this.state == null) && (other.state != null)) {
			return false;
		}

		if (this.zipCode != other.zipCode) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 53 * hash + (this.street1 != null ? this.street1.hashCode() : 0);
		hash = 53 * hash + (this.street2 != null ? this.street2.hashCode() : 0);
		hash = 53 * hash + (this.city != null ? this.city.hashCode() : 0);
		hash = 53 * hash + (this.state != null ? this.state.hashCode() : 0);
		hash = 53 * hash + this.zipCode;
		return hash;
	}
}
