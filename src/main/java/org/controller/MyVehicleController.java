/**
 * 
 */
package org.controller;

import java.util.List;

import org.bean.MyVehicle;
import org.service.MyVehicleService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;;

/**
 * @author Heer Hirpara
 *
 */
@RestController
public class MyVehicleController {
	
	MyVehicleService service = new MyVehicleService();
	
	@RequestMapping(value = "/getMyVehicle/{userID}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<MyVehicle> getMyVehicleList(@PathVariable long userID){
		List<MyVehicle> mylist = service.findByUserID(userID);
		return mylist;
	}
			
	@RequestMapping(value = "/addMyVehicle/", method = RequestMethod.POST, headers = "Accept=application/json")
	public List<MyVehicle> addMyVehicle(MyVehicle myVehicle){
		//List<MyVehicle> mylist = service.findByUserID();
		return null;
	}
	
	@RequestMapping(value = "/updateMyVehicle/{userID}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public List<MyVehicle> updateMyVehicle(MyVehicle myVehicle){
		//List<MyVehicle> mylist = service.findByUserID();
		return null;
	}
}
