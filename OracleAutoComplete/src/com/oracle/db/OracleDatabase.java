/**
 * 
 */
package com.oracle.db;

import java.util.List;

/**
 * @author gaurav's
 *
 */
public class OracleDatabase extends Connection {
	
	private static OracleDatabase db = null;
	
	private OracleDatabase() {
		// here all the properties can be loaded, and can make
		// the proper connection with the database.
	}

	
	/***
	 * a static method exposed to initiate the database.
	 * @return
	 */
	public static OracleDatabase getConnection() {
		if(null== db) {
			db = new OracleDatabase();
			System.out.println("A new Oracle Database Connection is opened");
		}
		return db;
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.oracle.db.Connection#getData()
	 */
	@Override
	public List<String> getData() {
		// own implementation to fetch the data from the kind of database
		// parse it and return that as list of string.
		return null;
	}
	
	@Override
	public void closeConnection() {

		System.out.println("Oracle database connection is closed.");
		db = null;
	}

}
