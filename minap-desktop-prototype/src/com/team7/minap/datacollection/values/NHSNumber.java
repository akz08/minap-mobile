package com.team7.minap.datacollection.values;

public class NHSNumber extends Value{
	public NHSNumber() {	
		super("1.03", "Unique national identifier that will be used for event and mortality tracking. This will be encrypted before data transfer.  Any other event or procedure recorded by NICOR will be linked using the NHS number.");
	}

}
