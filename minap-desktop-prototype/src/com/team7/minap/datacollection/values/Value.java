package com.team7.minap.datacollection.values;
//All values extents this, every page will check these methods. 
public class Value {
	public Value (String id, String notes) {
		this.id = id; 
		this.notes = notes;
	}
	private boolean isValid;
	private boolean isComplete;
	public boolean isValidated() {
		return isValid;
	}
	public boolean isCompleted() {
		return isComplete;
	}
	private String id;
	public String getId (){
		return id;
	}
	private String notes;
	
	public String getNotes (){
		return notes;
	}
	

}
