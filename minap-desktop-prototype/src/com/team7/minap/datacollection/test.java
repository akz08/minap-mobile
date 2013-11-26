package com.team7.minap.datacollection;
import java.util.Scanner;
public class test {
	public static boolean rangeCheck(double minimum, double maximum, double value) {
		// checks value is within minimum and maximum range, if not returns false
		if (value >= minimum && value <= maximum)
			return true;
		else {
			System.out.println("Entry is not within range.");
			//set the field to blank.
			return false;
		}
	}
	
	public static void main (String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Minimum");
		String min = sc.nextLine();
		double dmin = Double.parseDouble(min);
		System.out.println("Maximum");
		String max = sc.nextLine();
		double dmax = Double.parseDouble(max);
		System.out.println("Value");
		String val = sc.nextLine();
		double dval = Double.parseDouble(val);
		if (rangeCheck(dmin,dmax,dval)){
			System.out.println(val + " is within range");
		}
	}
}
