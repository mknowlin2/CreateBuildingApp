package com.webapp.knowlin.persistence;

import com.webapp.knowlin.model.Address;

public interface AddressMapper {

	void addAddress(Address address);

	void editAddress(Address address);

	Address getAddressByBuildingId(int id);

}
