package com.webapp.knowlin.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webapp.knowlin.model.Address;
import com.webapp.knowlin.model.Building;
import com.webapp.knowlin.model.Floor;
import com.webapp.knowlin.model.StatusCd;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:**/applicationContext-test.xml" })
public class BuildingServiceImplTest {
	@Autowired
	private BuildingServiceImpl testService;
	private Building testObj;
	private int testId = 3;
	
	@Before
	public void setUp() throws Exception {

		Address address = new Address();
		address.setStreet1("street 1");
		address.setStreet2("street 2");
		address.setCity("city");
		address.setState("State");
		address.setZipCode(21302);

		Floor floor1 = new Floor();
		floor1.setRoomCount(4);

		Floor floor2 = new Floor();
		floor2.setFloorNumber(2);
		floor2.setRoomCount(4);
		
		List<Floor> testFloors = new ArrayList<Floor>();
		testFloors.add(floor1);
		testFloors.add(floor2);

		testObj = new Building();
		testObj.setBuildingId(testId);
		testObj.setName("test name");
		testObj.setStatCd(StatusCd.ACTIVE);
		
		Date buildDt = new Date(Calendar.getInstance().getTimeInMillis());
		testObj.setBuildDt(buildDt);
		testObj.setAddress(address);
		testObj.setFloors(testFloors);
	}

	@After
	public void tearDown() throws Exception {
		testService = null;
		testObj = null;
	}

	@Ignore("Test need to be refactored to leverage mock objects instead of the database.")
	@Test
	public void createBuildingTest() throws Exception {
		boolean testResult = testService.create(testObj);
		assertEquals(true, testResult);
	}

	@Test(expected = Exception.class)
	public void createBuildingFailTest() throws Exception {
		testService.create(null);
	}

	@Ignore("Test need to be refactored to leverage mock objects instead of the database.")
	@Test
	public void getBuildingTest() throws Exception {
		Building testResult = testService.getBuildingById(testId);
		assertEquals(testObj, testResult);
	}
	
	@Ignore("Test need to be refactored to leverage mock objects instead of the database.")
	@Test
	public void getAllBuildingTest() throws Exception {
		List<Building> testResult = testService.getAllBuildings();
		assertNotNull(testResult);
		assertTrue(testResult.size() > 0);
	}

	@Ignore("Test need to be refactored to leverage mock objects instead of the database.")
	@Test
	public void editBuildingTest() throws Exception {
		String testName = "new name";
		Building initialResult = testService.getBuildingById(testId);
		assertEquals(testObj, initialResult);

		initialResult.setName(testName);
		initialResult.getAddress().setStreet1("new street 1");

		testService.editBuilding(initialResult);

		Building finalResult = testService.getBuildingById(testId);
		assertEquals(testId, finalResult.getBuildingId());
		assertNotEquals(testObj, finalResult);
	}
	
	@Ignore("Test need to be refactored to leverage mock objects instead of the database.")
	@Test
	public void updateBuildingStatusTest() throws Exception {
		Building initialResult = testService.getBuildingById(3);
		assertEquals(StatusCd.ACTIVE, initialResult.getStatCd());

		initialResult.setStatCd(StatusCd.SUSPENDED);

		testService.updateBuildingStatus(initialResult);

		Building finalResult = testService.getBuildingById(3);
		assertEquals(StatusCd.SUSPENDED, finalResult.getStatCd());
	}


	@Ignore("Test need to be refactored to leverage mock objects instead of the database.")
	@Test
	public void removeBuildingTest() throws Exception {
		Building initialResult = testService.getBuildingById(testId);
		assertNotNull(initialResult);
		assertEquals(StatusCd.ACTIVE, initialResult.getStatCd());

		testService.removeBuilding(initialResult);
		
		Building finalResult = testService.getBuildingById(testId);
		assertNotEquals(initialResult, finalResult);
		assertEquals(StatusCd.INACTIVE, finalResult.getStatCd());
		assertNotNull(finalResult.getDemolishDt());
	}
}
