/**
 * 
 */
package com.oracle.db;

import java.util.List;

/**
 * @author gaurav's
 *
 */
public class NoSQLDatabase extends Connection {
	
	private static NoSQLDatabase db = null;
	
	private NoSQLDatabase() {
		// here all the properties can be loaded, and can make
		// the proper connection with the database.
	}

	
	/***
	 * a static method exposed to initiate the database.
	 * @return
	 */
	public static NoSQLDatabase getConnection() {
		if(null== db) {
			db = new NoSQLDatabase();
			System.out.println("A new NO-SQL Database Connection is opened");
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

		System.out.println("No SQL database connection is closed.");
		db = null;
	}

}
