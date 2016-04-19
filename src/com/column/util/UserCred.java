package com.column.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserCred {
	private String userName;
	private String pwd;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public static UserCred getUserCred(){
		Properties prop = new Properties();		
		UserCred uc = null;
		InputStream in = null;
	    try {
	    		uc = new UserCred();
				in =  new FileInputStream("C:\\metricStream\\Property_file\\url.properties");
				prop.load(in);
				uc.setUserName(prop.getProperty(UserContants.USERNAME));
				uc.setPwd(prop.getProperty(UserContants.PASSWORD));
				
		} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return uc;
	}
}
