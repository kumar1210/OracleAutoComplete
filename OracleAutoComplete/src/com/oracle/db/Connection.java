/**
 * 
 */
package com.oracle.db;

import java.util.List;

/**
 * @author gaurav's
 * 
 * A abstract class of connection, which will be extended by all the 
 * different databases.
 *
 */
public abstract class Connection {

	public abstract List<String> getData() ;
	
	public abstract void closeConnection();
		
}
