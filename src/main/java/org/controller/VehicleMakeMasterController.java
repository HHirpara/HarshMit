package org.controller;

import java.util.List;

import org.bean.VehicleMakeMaster;
import org.service.VehicleMakeMasterService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.utility.ParseJSONObject;


@RestController
public class VehicleMakeMasterController {

	VehicleMakeMasterService vehicleMakeMasterService  = new VehicleMakeMasterService();
	
	
	//This request is used to download all data from vehicle API
	@RequestMapping(value = "/getAllVehicleListFromAPI", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<VehicleMakeMaster> getAllVehicleMasterList() {
		ParseJSONObject.parseJSON();
		List<VehicleMakeMaster> listOfVehicle = vehicleMakeMasterService.findAll(getClass());
		return listOfVehicle;
	}	
	
	@RequestMapping(value = "/getVehicleList", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<VehicleMakeMaster> getVehicleMasterList() {
		List<VehicleMakeMaster> listOfVehicle = vehicleMakeMasterService.findAll(getClass());
		return listOfVehicle;
	}	

	@RequestMapping(value = "/addVehicleMake", method = RequestMethod.POST, headers = "Accept=application/json")
	public VehicleMakeMaster addVehicleMake(@RequestBody VehicleMakeMaster vehicleMakeMaster) {
		return vehicleMakeMasterService.save(vehicleMakeMaster);
	}
	
	@RequestMapping(value = "/addVehicleMakewithModel", method = RequestMethod.POST, headers = "Accept=application/json")
	public VehicleMakeMaster addVehicleMakeWithModel(@RequestBody VehicleMakeMaster vehicleMakeMaster) {
		return vehicleMakeMasterService.save(vehicleMakeMaster);
	}
	
	@RequestMapping(value = "/updateVehicleMake/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public VehicleMakeMaster updateVehicleMake(@RequestBody VehicleMakeMaster vehicleMakeMaster) {
		return vehicleMakeMasterService.update(vehicleMakeMaster);

	}
}
