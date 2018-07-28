/**
 * 
 */
package com.oracle.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.oracle.db.Database;

/**
 * @author gaurav's
 * 
 * <p> An util class, where we can write all the util methods.
 *
 */
public class ServiceUtil {

	
	/****
	 * 
	 * an util method which will read the file which have all the
	 * data and will return as a list of data.
	 * @return
	 * @throws IOException
	 */
	public static List<String> readFile() throws IOException {
		
		File file = new File("src/database.txt");
		FileReader reader = new FileReader(file);
		BufferedReader br = new BufferedReader(reader);
		String records = null;
		List<String> data = new ArrayList<String>();
		while((records = br.readLine()) != null) {
			data.add(records);
		}
		br.close();
		br = null;
		reader.close();
		reader = null;
		file = null;
		return data;
	}
	
	
	/*****
	 * 
	 * <p> method which will get the data from database,
	 * 	   search the keyword in data loaded. 
	 * <p><b> Note : </b>This is case insensitive search.
	 * @param enteredKey
	 * @return
	 */
	public static List<String> searchAllwords(Database connection, String enteredKey) {
		
		List<String> storedData = connection.getData();
		List<String> matchedData = new ArrayList<String>();
		if(null != storedData) {
			for (String string : storedData) {
				//condition to check for finding the matching words.
				boolean flag = string.toLowerCase().startsWith(enteredKey.toLowerCase()) || string.toLowerCase().contains(enteredKey.toLowerCase());
				if(flag) {
					matchedData.add(string);
				}
			}
		}
		storedData = null;
		return matchedData;
	}

}
