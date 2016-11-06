package com.webapp.knowlin.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.webapp.knowlin.model.Address;
import com.webapp.knowlin.persistence.AddressMapper;

public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressMapper addressMapper;

	@Override
	public boolean addAddress(Address address) throws Exception {
		boolean returnVal = false;
		try {
			addressMapper.addAddress(address);
			returnVal = true;
		} catch (Exception e) {
			throw new Exception(e);
		}

		return returnVal;
	}

	@Override
	public boolean editAddress(int buildingId, Address address) throws Exception {
		boolean returnVal = false;
		try {
			address.setBuildingId(buildingId);
			addressMapper.editAddress(address);
			returnVal = true;
		} catch (Exception e) {
			throw new Exception(e);
		}

		return returnVal;
	}

	@Override
	public Address getAddressByBuildingId(int id) throws Exception {
		return addressMapper.getAddressByBuildingId(id);
	}

	public AddressMapper getAddressMapper() {
		return addressMapper;
	}

	public void setAddressMapper(AddressMapper addressMapper) {
		this.addressMapper = addressMapper;
	}

}
