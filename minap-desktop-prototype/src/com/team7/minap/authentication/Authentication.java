/**
 * Main authentication class. Only called when initially logging in,
 * or when network connection lost. For security reasons, we do not store user
 * authentication details. 
 */

package com.team7.minap.authentication;

import com.team7.minap.network.Network;

public class Authentication {
	private static String userName;
	private static String passWord;
	private static Network net;
	private static boolean isAuthenticated = false;
	
	private Authentication(Network n) {
		net = n;
	}
	
	private Authentication(String user, String pass, Network n) {
		userName = user;
		passWord = pass;
		net = n;
	}
	private static void setCredentials(String user, String pass) {
		userName = user;
		passWord = pass;
	}
	
	/**
	 * Method to call server to perform authentication.
	 * 
	 * @param net Network object to call
	 * @param user Username of user
	 * @param pass Password of user
	 */
	private static void authenticate(Network net, String user, String pass){
		
	}
	
	private static boolean isAuthenticated() {
		return isAuthenticated;
	}
	
	private static void signOut() {
		// Close network connection, return to sign on page
	}
}