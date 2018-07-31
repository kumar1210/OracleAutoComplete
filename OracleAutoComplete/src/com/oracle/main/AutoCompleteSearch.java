/**
 * 
 */
package com.oracle.main;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.oracle.db.Connection;
import com.oracle.db.ConnectionFactory;
import com.oracle.util.ServiceUtil;

/**
 * @author gaurav's
 * 
 *  <p><b> Define : </b> this is the main class which is exposed as a client.
 *  	Client will be asked to choose one of the option at console. 
 *  	Here while initiating the application, this will get a db connection.
 *  	If the User entered the wrong option, they will be asked to re-enter out of
 *  	the suggested options.
 *  
 *  <p> <b>option 1 </b> : 
 *  	It will asked the user to enter the keyword for which
 *  	all the matching words or the word that contain the entered
 *  	keyword will be returned.
 *  <p>	<b> option 0 </b> : It will exit the application.
 *  						
 *
 */
public class AutoCompleteSearch {
	

	private Connection connection = null;
	
	public AutoCompleteSearch() {
		
		// once the application is up, instantiate the db connection.
		setConnection(ConnectionFactory.getConnection("FILE"));
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Application has been started.....");
		// taken a regular expression just to check that user has entered numeric character only.
		String regex = "^[0-9]$";
		boolean running = true;
		Scanner scn = null;
		AutoCompleteSearch autoSearch = new AutoCompleteSearch();
		while(running) {
			
			System.out.println("1. Press 1 to enter the keyword : \n2. Press 0 to Exit : ");
			scn = new Scanner(System.in);
			String optionEntered = scn.nextLine();
			if(optionEntered.matches(regex)) {
				int option = Integer.parseInt(optionEntered);
				switch(option) {
					case 0 : {
						running = false;
						break;
					}
					case 1 :  {
						System.out.println("Please enter the key : ");
						String enteredKey = scn.nextLine();
						List<String> matchingWords = ServiceUtil.searchAllwords(autoSearch.getConnection(), enteredKey);
						if (null != matchingWords && matchingWords.size()!=0) {
							//Displaying the words in sorted order, alphabetically.
							Collections.sort(matchingWords);
							System.out.println("All Matching words are : "+matchingWords);
						} else {
							System.out.println("There are no matching words with the entered input.");
						}
						break;
					} default : {
						System.out.println("Please enter the suggested options only, Thanks !!");
					}
					
				}
			} else {
				System.out.println("Please enter the suggested options only, Thanks !!");
			}
		}
		scn.close();
		autoSearch.getConnection().closeConnection();
		System.out.println("Application is closed !!");
	}
	
	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		
		return connection;
	}
	
	/**
	 * @param connection the connection to set
	 */
	public void setConnection(Connection connection) {
		
		this.connection = connection;
	}
	
}
