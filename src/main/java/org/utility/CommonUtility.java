package org.utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.Properties;

public class CommonUtility {
	

	public Date getcurrentDate(){
		Properties formatProperties = new Properties();
		
		InputStream io = getClass().getClassLoader().getResourceAsStream("FormatProperties.properties");
		if(io != null){
			try {
				formatProperties.load(io);
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	
		return null;
		
	}

}
