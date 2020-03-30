package edu.odu.cs.cs471;

public class Partition {
	
	private int id;
	private double freeSpace;
	private boolean occupied;
	
	/**
	 * Constructor
	 */
	public Partition(){
		this.id = 0;
		this.freeSpace = 0;
		this.occupied = false;
	}
	
	public void setID(int ID) {
		this.id = ID;
		
	}
	
	public void setfreeSpace(double fs) {
		this.freeSpace = fs;
	}
	
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
}
