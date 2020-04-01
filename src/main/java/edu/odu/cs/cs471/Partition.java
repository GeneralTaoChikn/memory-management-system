package edu.odu.cs.cs471;

import java.util.ArrayList;
import java.util.List;

public class Partition {
	
	private int id;
	private String assignedTo;
	private double occupiedSpace;
	private double freeSpace;
	private boolean occupied;
//======================================================================
///Constructors
	/**
	 * Default Constructor
	 */
	public Partition(){
		this.id = 0;
		this.assignedTo = "";
		this.occupiedSpace = 0;
		this.freeSpace = 0;
		this.occupied = false;
	}
	
	/**
	 * Constructor
	 * @param num
	 * @param free
	 */
	public Partition (int num, double free) {
		id = num;
		assignedTo = "";
		occupiedSpace = 0;
		freeSpace = free;
		occupied = false;
		
	}
//======================================================================
///Setters
	/**
	 * Assign FreeSpace
	 * @param fs
	 */
	public void setfreeSpace(double fs) {
		this.freeSpace = this.freeSpace - fs;
		this.occupiedSpace = fs;
	}
	
	/**
	 * Designate if partition is being used
	 * @param a
	 */
	public void setOccupied(boolean a) {
		this.occupied = a;
	}
	
	/**
	 * Set wich process it is assigned to
	 * @param proc
	 */
	public void setassignedTo (String proc) {
		this.assignedTo = proc;
	}

//======================================================================
///Getters
	
	public int getId() {
		return this.id;
	}
	
	public boolean getOccupied() {
		return this.occupied;
	}
	
	public double getfreeSpace() {
		return this.freeSpace;
	}
	
//======================================================================
	
	
	public void resetPartition () {
		this.assignedTo = "";
		this.freeSpace = freeSpace + occupiedSpace;
		this.occupiedSpace = 0;
		this.occupied = false;	
	}
	
	public Partition splitPartition (Partition toSplit) {
		Partition newPart = new Partition();
		//TODO Split an existing partion
		
		
		return newPart;
	}
	
	public void collectGarbage () {
		//TODO Implement an Algorithm to best compact garbage.
		//Take free space from occupied memory and put it back into main
		
	}
	
	public String toString() {
		//print List
//		String use = "";
//		if (this.occupied)
//			use = "inUse";
//		else
//			use = "UnUsed";
		
		return "Partition ID: " + this.id + "  " +
				"UsedSpace: " + this.occupiedSpace + "  " +
				"FreeSpace: " + this.freeSpace + "  " + 
				"allocated toproce Num: " + assignedTo + '\n' + '\n';
				
	}
	
	
	public static String toListString(List<Partition> print, String utl) {
		String toPrint = "";
//		int a = print.size();
//		String toPrint = Integer.toString(a);

		for (int i = 0; i != print.size(); i++) {
			
			//build Used Text
			if(utl.contentEquals("used"))
				if(print.get(i).getOccupied() == true)
					toPrint += print.get(i).toString();
			//build free info
			if(utl.contentEquals("free"))
				if(print.get(i).getOccupied() == false)
					toPrint += print.get(i).toString();
			
		}
		
		return toPrint;
	}
	
	public static List<Partition> prepopulate() {
		List <Partition> partitions = new ArrayList<Partition>();
		
		partitions.add(new Partition (0, 200));
		partitions.add(new Partition (1, 150));
		partitions.add(new Partition (2, 350));
		partitions.add(new Partition (3, 625));
		partitions.add(new Partition (4, 225));
		
		return partitions;
		
	}
}
