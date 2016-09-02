
package org.controller;

import java.util.List;

import org.bean.OfferedRide;
import org.service.OfferedRideService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfferedRideController {

	OfferedRideService offeredRideService = new OfferedRideService();
	
	@RequestMapping(value = "/getOfferedRide/{offeredRideID}", method = RequestMethod.GET, headers = "Accept=application/json")
	public OfferedRide getOfferedRide(@PathVariable long offeredRideID){
		OfferedRide offeredRide = offeredRideService.findById(offeredRideID);
		return offeredRide;
	}
	
	@RequestMapping(value = "/getMyOfferedRides/{userID}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<OfferedRide> getMyOfferedRides(@PathVariable long userID){
		List<OfferedRide> mylist = offeredRideService.findByUserID(userID);
		return mylist;
	}
			
	@RequestMapping(value = "/addOfferedRide/", method = RequestMethod.POST, headers = "Accept=application/json")
	public List<OfferedRide> addOfferedRide(OfferedRide offeredRide){
		//List<OfferedRide> mylist = offeredRideService.findByUserID();
		return null;
	}
	
	@RequestMapping(value = "/updateOfferedRide/{userID}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public List<OfferedRide> updateOfferedRide(OfferedRide offeredRide){
		//List<OfferedRide> mylist = offeredRideService.findByUserID();
		return null;
	}
	
/*	@RequestMapping(value = "/deleteOfferedRide/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteOfferedRide(@PathVariable("id") Long id) {
		offeredRideService.deleteOfferedRideById(id);

	}
*/	
}
