package com.webapp.knowlin.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webapp.knowlin.model.Address;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:**/applicationContext-test.xml" })
public class AddressServiceImplTest {
	@Autowired
	private AddressServiceImpl testService;
	private Address testObj;

	@Before
	public void setUp() throws Exception {

		testObj = new Address();
		testObj.setBuildingId(3);
		testObj.setStreet1("street 1");
		testObj.setStreet2("street 2");
		testObj.setCity("city");
		testObj.setState("State");
		testObj.setZipCode(21302);

	}

	@After
	public void tearDown() throws Exception {
		testService = null;
		testObj = null;
	}

	@Ignore("Test need to be refactored to leverage mock objects instead of the database.")
	@Test
	public void addAddressTest() throws Exception {
		boolean testResult = testService.addAddress(testObj);
		assertEquals(true, testResult);
	}

	@Ignore("Test need to be refactored to leverage mock objects instead of the database.")
	@Test(expected = Exception.class)
	public void addAddressExceptionTest() throws Exception {
		testService.addAddress(null);
	}

	@Ignore("Test need to be refactored to leverage mock objects instead of the database.")
	@Test(expected = DuplicateKeyException.class)
	public void addAddressDuplicateKeyExceptionTest() throws Exception {
		testService.addAddress(testObj);
	}

	@Ignore("Test need to be refactored to leverage mock objects instead of the database.")
	@Test
	public void editBuildingTest() throws Exception {
		String testName = "new test street 1";
		Address initialResult = testService.getAddressByBuildingId(testObj.getBuildingId());
		assertEquals(testObj, initialResult);

		testObj.setStreet1(testName);

		testService.editAddress(testObj.getBuildingId(), testObj);

		Address finalResult = testService.getAddressByBuildingId(testObj.getBuildingId());
		assertNotEquals(initialResult, finalResult);
		assertEquals(testObj.getStreet1(), finalResult.getStreet1());
	}

	@Test(expected = Exception.class)
	public void editAddressExceptionTest() throws Exception {
		testService.editAddress(0, null);
	}

	@Ignore("Test need to be refactored to leverage mock objects instead of the database.")
	@Test
	public void getAddressByBuildingIdTest() throws Exception {
		Address result = testService.getAddressByBuildingId(testObj.getBuildingId());
		assertEquals(testObj, result);
	}
}
