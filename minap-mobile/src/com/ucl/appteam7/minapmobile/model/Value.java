package com.ucl.appteam7.minapmobile.model;
//All values extents this, every page will check these methods. 
public class Value {
	
	private String id;			// MINAP value id
	private String notes;		// contents of help notes  (this is not stored on the local database)
	private String notesTitle;	// the title of help notes (this is not stored on the local database)
	
	private boolean isValid;
	private boolean isComplete;
	
	public Value (String id, String notes) {
		this(id, notes, "Title to be Added"); // use an obviously wrong default title - all help dialogs must have titles.
	}
	
	public Value (String id, String notes, String notesTitle) {
		this.id = id;
		this.notes = notes;
		this.notesTitle = notesTitle;
	}
	
	public boolean isValidated() {
		return isValid;
	}
	
	public boolean isCompleted() {
		return isComplete;
	}
	
	public String getId (){
		return id;
	}	
	
	public String getNotes (){
		return notes;
	}
	
	public String getNotesTitle (){
		return notesTitle;
	}

}
