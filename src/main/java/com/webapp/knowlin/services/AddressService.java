package com.webapp.knowlin.services;

import com.webapp.knowlin.model.Address;

public interface AddressService {
	
	public boolean addAddress(Address address) throws Exception;

	public boolean editAddress(int i, Address address) throws Exception;

	public Address getAddressByBuildingId(int id) throws Exception;
}
