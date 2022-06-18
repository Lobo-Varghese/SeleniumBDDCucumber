package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {	
	/**
	 * This method load the properties from config.properties file and return the 
	 * properties prop object.
	 * **/
	
	private Properties prop;
	public Properties init_prop() {
		prop = new Properties();
		
		try {
		String filepath = "C:\\Users\\LOBO\\Selenium\\SeleniumBDDCucumber\\src\\test\\resources\\config\\config.properties";
		FileInputStream ip = new FileInputStream(filepath);
		prop.load(ip);
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
	return prop;
	}
}
