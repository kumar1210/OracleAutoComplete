/**
 * 
 */
package com.oracle.db;

import java.io.IOException;
import java.util.List;

import com.oracle.util.ServiceUtil;

/**
 * 
 * <p> <b>Define : </b> This is a singleton class which will initiate only one
 * 		  instance throughout the application life.
 * @author gaurav's
 *
 */
public class Database {

	private static Database db =null;
	
	private Database () {
		
	}
	
	/***
	 * a static method exposed to initiate the database.
	 * @return
	 */
	public static Database getConnection() {
		if(null== db) {
			db = new Database();
		}
		return db;
	}
	
	/***
	 *  <p> this is a method to load the data from the backend,
	 *  	here we are loading the data from a static file.
	 * @return
	 */
	public List<String> getData() {
		try {
			List<String> data = ServiceUtil.readFile();
			return data;
		} catch (IOException ex) {
			System.out.println("Error while loading the data "+ ex);
		}
		return null;
	}
	
	/***
	 *  <p>method to close the db connection
	 */
	public void closeConnection() {
		db = null;
	}
}
