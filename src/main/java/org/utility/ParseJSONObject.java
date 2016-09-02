package org.utility;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bean.VehicleMakeMaster;
import org.bean.VehicleModelMaster;
import org.service.VehicleMakeMasterService;
import org.service.VehicleModelMasterService;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ParseJSONObject {

	private static final Log log = LogFactory.getLog(ParseJSONObject.class);
	public static void parseJSON(){
		
		try {
			JsonFactory factory = new JsonFactory();
			URL url = new URL("https://api.edmunds.com/api/vehicle/v2/makes?view=basic&fmt=json&api_key=t69g4tnwptzxhvzfvs7s4fcv");
		    ObjectMapper mapper = new ObjectMapper(factory);
		    JsonNode rootNode = mapper.readTree(url).get("makes");  
		    VehicleMakeMaster vehicle = new VehicleMakeMaster();
		    VehicleModelMaster vehicleModelMaster = new VehicleModelMaster();
		    VehicleMakeMasterService vehicleService = new VehicleMakeMasterService();
		    VehicleModelMasterService vehicleModelService = new VehicleModelMasterService();
		    
		    if (rootNode.isArray()) {
    		    for (JsonNode objNode : rootNode) {

    		    	System.out.println("Make Id = " + objNode.get("id").asLong());
     		        System.out.println("Make  Name - name = " + objNode.get("name").textValue());
     		        System.out.println("Make Nick Name = " + objNode.get("niceName").textValue());
    		    	
    		    	Long receivedVehicleId = objNode.get("id").asLong();
    		    	String makeName = objNode.get("name").textValue();
    		    	String makeNickName = objNode.get("niceName").textValue();
    		        Date curerntDate = new Date(System.currentTimeMillis());
    		       
    		        vehicle.setReceivedVehicleId(receivedVehicleId.toString());
    		        vehicle.setName(makeName);
    		        vehicle.setNiceName(makeNickName);
    		        vehicle.setCreated(curerntDate);
    		        vehicle.setCreatedBy("Heer");
    		        vehicle.setModified(curerntDate);
    		        vehicle.setModifiedBy("Heer");
    		        
    		        vehicleService.save(vehicle);
    		        
    		        JsonNode modelList = objNode.get("models");
    		        if(modelList.isArray()){
    		        	for (JsonNode modelNode : modelList) {
    		        		
    		        		System.out.println("\tModel id = " + modelNode.get("id").textValue());
    	    		        System.out.println("\tModel Name = " + modelNode.get("name").textValue());
    	    		        System.out.println("\tModel Nick Name = " + modelNode.get("niceName").textValue());
    	    		        
    	    		        String receivedModelId = modelNode.get("id").textValue();
    	    		        String modelName = modelNode.get("name").textValue();
    	    		        String modelNickname = modelNode.get("niceName").textValue();
    	    		        
    	    		        vehicleModelMaster.setVehicleMakeMasterByVehicleId(vehicle.getVehicleId().longValue());
    	    		        vehicleModelMaster.setReceivedModelId(receivedModelId);
    	    		        vehicleModelMaster.setModelName(modelName);
    	    		        vehicleModelMaster.setModelCode(modelNickname);
    	    		        vehicleModelMaster.setCreated(curerntDate);
    	    		        vehicleModelMaster.setCreatedBy("Heer");
    	    		        vehicleModelMaster.setModified(curerntDate);
    	    		        vehicleModelMaster.setModifiedBy("Heer");
    	    		        
    	    		        vehicleModelService.save(vehicleModelMaster);
    	    		        
    		        	}
    		        }
    		    }
    		}
		    
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
		
}
