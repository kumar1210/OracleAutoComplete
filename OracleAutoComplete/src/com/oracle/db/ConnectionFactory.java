/**
 * 
 */
package com.oracle.db;

/**
 * @author gaurav's
 * 
 * * <p>
 * A factory class which will return the instance
 * of the object based on the condition defined
 * Here company is the condition based on which the 
 * concrete obj will be returned.
 * 
 * <p><b> Benefits : </b>
 * <p>1. Factory pattern removes the instantiation of actual 
 *    implementation classes from client code
 * <p>2. provides abstraction between implementation and client
 *  classes through inheritance.
 *
 */
public class ConnectionFactory {

	
	public static Connection getConnection(String type) {
		
		if("File".equalsIgnoreCase(type)) {
			return FileDatabase.getConnection();
		} else if("Oracle".equalsIgnoreCase(type)) {
			return OracleDatabase.getConnection();
		} else if("NOSQL".equalsIgnoreCase(type)) {
			return NoSQLDatabase.getConnection();
		}
		System.out.println("There is no such Connection type " + type);
		return null;
	}
}
