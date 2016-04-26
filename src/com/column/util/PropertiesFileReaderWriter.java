package com.column.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFileReaderWriter 
{
	
	public static String getLastRunDateString(String filePath) 
	{
		Properties prop = new Properties();
        InputStream in = null;
        File f = null;
        String lastRun = null;
        try {
        	
        	f = new File(filePath);
			in = new FileInputStream(f);
			prop.load(in);			
			lastRun = prop.getProperty(UserContants.LAST_RUN_DATE_TIME);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
        finally 
		{
			try{
				if(in!=null)
				{
					in.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
        return lastRun ;
	}
	
	
	public static void setLastRunDateString(String filePath, String currentDate) 
	{
		Properties prop = new Properties();
		File f = null;
		OutputStream out = null;
		try {
			f = new File(filePath);
			out = new FileOutputStream(f);
			prop.setProperty(UserContants.LAST_RUN_DATE_TIME, currentDate);			
			prop.store(out, "Date Saved Sucessfully ");
			
		} catch (FileNotFoundException e ) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(out!=null ) 
				{
					out.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}

	}

}
