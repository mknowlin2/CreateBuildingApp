package com.webapp.knowlin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.knowlin.model.Building;
import com.webapp.knowlin.model.StatusCd;
import com.webapp.knowlin.services.BuildingService;

@Controller
public class BuildingController {
	@Autowired
	private BuildingService buildingServices;

	@GetMapping("/welcome")
	public String hello(Model model) throws Exception {

		List<Building> buildingList = buildingServices.getAllBuildings();

		model.addAttribute("buildingList", buildingList);

		return "welcome";
	}

	@RequestMapping(value = "/building", method = RequestMethod.GET)
	public String building(ModelMap model) {
		model.addAttribute("command", new Building());
		return "createBuilding";
	}

	@RequestMapping(value = "/createBuilding", params = "create", method = RequestMethod.POST)
	public String createBuilding(@ModelAttribute("SpringWeb") Building building, ModelMap model) throws Exception {
		building.setStatCd(StatusCd.ACTIVE);
		buildingServices.create(building);
		return "redirect:/welcome";
	}

	@RequestMapping(value = "/createBuilding", params = "cancel", method = RequestMethod.POST)
	public String cancelCreateBuilding() {
		return "redirect:/welcome";
	}

	@RequestMapping(value = "/updateBuilding", params = "update", method = RequestMethod.POST)
	public String updateBuildingView(@ModelAttribute("SpringWeb") Building building, ModelMap model) throws Exception {
		buildingServices.editBuilding(building);
		return "redirect:/welcome";
	}

	@RequestMapping(value = "/updateBuilding", params = "home", method = RequestMethod.POST)
	public String cancelBuildingView() {
		return "redirect:/welcome";
	}

	@RequestMapping(value = "/viewBuilding", method = RequestMethod.GET)
	public String viewBuilding(@RequestParam int buildingId, ModelMap model) throws Exception {
		Building building = buildingServices.getBuildingById(buildingId);
		model.addAttribute("command", building);

		return "viewBuilding";
	}

	public BuildingService getBuildingServices() {
		return buildingServices;
	}

	public void setBuildingServices(BuildingService buildingServices) {
		this.buildingServices = buildingServices;
	}
}
