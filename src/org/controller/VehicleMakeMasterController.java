package org.controller;

import java.util.List;

import org.bean.VehicleMakeMaster;
import org.service.VehicleMakeMasterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VehicleMakeMasterController {

	VehicleMakeMasterService vehicleMakeMasterService  = new VehicleMakeMasterService();
	
	@RequestMapping(value = "/vehiclemasterlist", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<VehicleMakeMaster> getVehicleMasterList() {
		List<VehicleMakeMaster> listOfVehicle = vehicleMakeMasterService.findAll(getClass());
		return listOfVehicle;
	}	
}
