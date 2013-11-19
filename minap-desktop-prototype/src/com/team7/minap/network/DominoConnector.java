package com.team7.minap.network;

public class DominoConnector implements Network {
	private static boolean dominoUp = false;

	
	
	public void openConnection() {
		// Domino connection set up
	}
	public void closeConnection() {
		
	}
	public boolean isConnected(){
		return dominoUp;
	}

}
