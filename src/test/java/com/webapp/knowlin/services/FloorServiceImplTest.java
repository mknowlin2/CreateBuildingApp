package com.webapp.knowlin.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webapp.knowlin.model.Floor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:**/applicationContext-test.xml" })
public class FloorServiceImplTest {
	@Autowired
	private FloorServiceImpl testService;
	private Floor testObj;
	List<Floor> testFloors;
	private int testId = 3;
	
	@Before
	public void setUp() throws Exception {
		testObj = new Floor();
		testObj.setBuildingId(testId);
		testFloors = new ArrayList<Floor>();
		testFloors.add(testObj);
	}

	@After
	public void tearDown() throws Exception {
		testService = null;
		testObj = null;
	}

	@Ignore("Test need to be refactored to leverage mock objects instead of the database.")
	@Test
	public void addFloorsTest() throws Exception {
		boolean testResult = testService.addFloors(testFloors);
		assertEquals(true, testResult);
	}
	
	@Ignore("Test need to be refactored to leverage mock objects instead of the database.")
	@Test
	public void addFloorsMultipleTest() throws Exception {
		
		List<Floor> newFloors = new ArrayList<Floor>();
		
		Floor floor2 = new Floor();
		floor2.setBuildingId(testId);
		floor2.setFloorNumber(2);
		floor2.setRoomCount(4);
		newFloors.add(floor2);
		
		Floor floor3 = new Floor();
		floor3.setBuildingId(testId);
		floor3.setFloorNumber(3);
		floor3.setRoomCount(3);
		newFloors.add(floor3);
		
		Floor floor4 = new Floor();
		floor4.setBuildingId(3);
		floor4.setFloorNumber(4);
		floor4.setRoomCount(2);
		newFloors.add(floor4);
		
		boolean testResult = testService.addFloors(newFloors);
		assertEquals(true, testResult);
	}

	@Test(expected = Exception.class)
	public void addFloorExceptionTest() throws Exception {
		testService.addFloors(null);
	}

	@Ignore("Test need to be refactored to leverage mock objects instead of the database.")
	@Test
	public void getFloorsTest() throws Exception {
		List<Floor> testResultList = testService.getFloorsByBuildingById(testId);
		assertNotNull(testResultList);
		assertTrue(testResultList.size() > 0);
	}

}
