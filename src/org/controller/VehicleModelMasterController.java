package org.controller;

import java.util.List;

import org.bean.VehicleModelMaster;
import org.service.VehicleModelMasterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VehicleModelMasterController {
	
	VehicleModelMasterService vehicleModelMasterService  = new VehicleModelMasterService();
	
	@RequestMapping(value = "/vmodellist", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<VehicleModelMaster> getVehicleMasterList() {
		List<VehicleModelMaster> listOfVehicle = vehicleModelMasterService.findAll(getClass());
		return listOfVehicle;
	}

}
