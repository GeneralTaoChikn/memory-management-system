package edu.odu.cs.cs471;

import java.util.ArrayList;
import java.util.List;

public class Partition {
	
	private int id;
	private double occupiedSpace;
	private double freeSpace;
	private boolean occupied;
	
	/**
	 * Default Constructor
	 */
	public Partition(){
		this.id = 0;
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
		occupiedSpace = 0;
		freeSpace = free;
		occupied = false;
		
	}
	
//	public void setID(int ID) {
//		this.id = ID;
//		
//	}
//	
//	public void setfreeSpace(double fs) {
//		this.freeSpace = fs;
//	}
	
	/**
	 * Designate if partition is being used
	 * @param a
	 */
	public void setOccupied(boolean a) {
		this.occupied = a;
	}


	/**
	 * There should be an ID on a block
	 * @return id
	 */
	public int getId() {
		return this.id;
	}
	
	
	/**
	 * This would be used to determine if process can be run
	 * @return amount of free space
	 */
	public double getfreeSpace() {
		return this.freeSpace;
	}
	
	public String toString(String toPrint) {
		//print List
		String use = "";
		if (this.occupied)
			use = "inUse";
		else
			use = "UnUsed";
		
		return "Partition ID: " + this.id + "  " +
				"Used Space: " + this.occupiedSpace + "  " +
				"Free Space: " + this.freeSpace + "  " +
				use + '\n' ;
				
	}
	
	public static String toListString(List<Partition> print) {
		String toPrint = "";
		
		for (int i = 0; i < print.size(); i++) {
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
