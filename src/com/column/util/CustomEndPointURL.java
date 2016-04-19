package com.column.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CustomEndPointURL {
	

	public static String getEndPoint() {
	       	    	   
		Properties prop = new Properties();
		String url = "";
	    try {
				InputStream in =  new FileInputStream("C:\\metricStream\\Property_file\\url.properties");
				prop.load(in);
				url = prop.getProperty(UserContants.ENDPOINTURL);
				
		} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
   	   return url;
	       
	}


	
	

}
