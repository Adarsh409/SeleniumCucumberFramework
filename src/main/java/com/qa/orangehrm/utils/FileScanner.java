package com.qa.orangehrm.utils;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sun.tools.sjavac.Log;

public class FileScanner {
	
	public static Logger log = LogManager.getLogger(FileScanner.class);
	public static Properties readPropertiesFile(String filePath) {
		Properties prop = new Properties();
		try {
			FileInputStream finp = new FileInputStream(filePath);
			prop.load(finp);
			log.info("Loaded properties file in "+filePath);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
		
		
	}
	
	public static List<Object> readJSONFile(String filePath, String baseKey) {
		log.info("Reading JSON Test data in "+filePath+"with base key"+baseKey);
		JSONParser jsonParser = new JSONParser();
		Object obj = null;
		 
		try {
			FileReader file = new FileReader(filePath);
			obj = jsonParser.parse(file);
		}  catch (Exception e) {

		}
		JSONArray jsonArray = (JSONArray) obj;
		List<Object> employeesDetailsList = new ArrayList<Object>();
		for (int i = 0; i < jsonArray.size(); i++) {
			employeesDetailsList.add(jsonArray.get(i));
		}
		log.info("JSON data stored in list");
		return employeesDetailsList;

	}
	
	
}
