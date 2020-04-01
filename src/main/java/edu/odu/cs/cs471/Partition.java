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
	public void setOcSpace(double os) {
		this.occupiedSpace = os;
		this.freeSpace = this.freeSpace - os;
	}
	
	public void setFreeSpace (double fs) {
		freeSpace = fs;
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
	
	public double getUsedSpace() {
		return this.occupiedSpace;
	}
	
//======================================================================
	
	
	public void resetPartition () {
		this.assignedTo = "";
		this.freeSpace = occupiedSpace;
		this.occupiedSpace = 0;
		this.occupied = false;	
	}
	
	public Partition splitPartition (int id) {
		Partition newPart = new Partition(id, this.freeSpace);
		this.setFreeSpace(0);

		return newPart;
	}
	
	public static void collectGarbage (List <Partition> toCollect) {
		//TODO Implement an Algorithm to best compact garbage.
		//Take free space from occupied memory and put it back into main
		double freeTotal = 0;
		for (int j = 0; j < toCollect.size(); j++) {
			for (int i = 0; i < toCollect.size(); ++i) {
				if (toCollect.get(i).getOccupied() == false) {
						freeTotal += toCollect.get(i).getfreeSpace();
						toCollect.get(i).setFreeSpace(0);
//			if(toCollect.get(i).occupied == false) {
						toCollect.remove(i);
				}
			}
		}
		freeTotal = freeTotal + toCollect.get(toCollect.size()-1).freeSpace;
		
		//Prevents deletion of currently used blocks
		if (toCollect.get(toCollect.size()-1).getOccupied() == false)
			toCollect.remove(toCollect.size()-1);
		
		toCollect.add(new Partition (toCollect.size(),freeTotal));
	}
	
	public String toString() {
		//print List		
		return "Partition ID: " + this.id + "  " +
				"UsedSpace: " + this.occupiedSpace + "Mb  " +
				"FreeSpace: " + this.freeSpace + "Mb  " + 
				"Assigned To: " + assignedTo + '\n' + '\n';
				
	}
	
	
	public static String toListString(List<Partition> print, String utl) {
		String toPrint = "";
//		int a = print.size();
//		String toPrint = Integer.toString(a);

		for (Partition i : print) {
			//build Used Text
			if(utl.contentEquals("used"))
				if(i.getOccupied() == true)
					toPrint += i.toString();
			//build free info
			if(utl.contentEquals("free"))
				if(i.getOccupied() == false)
					toPrint += i.toString();
			
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
