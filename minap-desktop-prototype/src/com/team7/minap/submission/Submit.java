/** 
 * Network connection needs to be checked before submission can occur.
 * We assume all validation has been completed.
 * If the network is all cool, we try to submit via a transaction. If it fails, we retry automatically.
 * 
 */

package com.team7.minap.submission;

import com.team7.minap.network.Network;
import com.team7.minap.validation.Validation;

public class Submit {
	private static Validation valid;
	private static Network net;
	
	public boolean submitSuccessful() {
		return false;
	}
	
	public boolean isSubmitting() {
		return false;
	}
	
	private static boolean sqlSubmit(Validation valid, Network net){
		//check if it is valid and it is complete and we have the network
		return false;
	}
	private static boolean dominoSubmit(Validation valid, Network net){
		//check if it is valid and it is complete and we have the network and Internet
		return false;
	}
	
	
}
