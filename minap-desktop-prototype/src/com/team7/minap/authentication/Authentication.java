package com.team7.minap.authentication;

import com.team7.minap.network.Network;

public class Authentication {
	private static String userName;
	private static String passWord;
	private static Network net;
	
	private Authentication(String user, String pass, Network n) {
		userName = user;
		passWord = pass;
		net = n;
	}
	private static void setCredentials(String user, String pass) {
		userName = user;
		passWord = pass;
	}
	
	private static void authenticate(Network net, String user, String pass){
		
	}
	
	private static void signOut() {
		// Close network connection, return to sign on page
	}
}