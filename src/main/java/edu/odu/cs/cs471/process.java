package edu.odu.cs.cs471;

import java.util.List;
import java.util.Random;

public class process {
	
	private String ProcessName;
	private int ProcessNum;
	private double size;
	private int pageNum;
	private String location;
	private boolean inUse;
	private int whichBlock;
	
	/**
	 * Default Constructor
	 */
	public process() {
		ProcessName = "";
		size = 0;
		pageNum = 0;
		location = "";
		inUse = false;
		
	}
	
	/**
	 * Constructor
	 * @param procNme
	 * @param procNum
	 */
	public process (String procNme, int procNum) {
		ProcessName = procNme;
		ProcessNum = procNum;
		size = genSize();
		pageNum = 0;
		location = "";
		inUse = false;
	}
	
//	/**
//	 * Sets the process Name
//	 * @param process
//	 */
//	public void setProcName (String process) {
//		this.ProcessName = process;
//	}
//	
//	/**
//	 * TODO generate a random size
//	 */
//	public void setSize () {
//		
//	}
	
	/**
	 * TODO generate random PageNumber
	 */
	public void setpageNum () {
		
	}
	
	/**
	 * TODO generate random Location
	 */
	public void setlocation () {
		
	}
	
	/**
	 * Determine whether the process is running or not
	 * @param processing
	 */
	public void setInUse (boolean processing) {
		this.inUse = processing;
	}
	
	
//	/**
//	 * Retrieve Process Name
//	 * @return process name
//	 */
//	public String getProcName () {
//		return this.ProcessName;
//	}
	
	public boolean getinUse () {
		return this.inUse;
	}
	
	/**@override
	 * Prints out characteristics of Process
	 * @return process characteristics
	 */
	public String toString(String toPrint) {
		//print List
		if (toPrint.equals("List"))
			return this.ProcessNum +':' +" Process Name: " + this.ProcessName + "  " +
				"Size: " + this.size + "  " + '\n';
		
		//Print Status
		else
			return "Process Name: " + this.ProcessName + '\n' +
				"Size: " + this.size + '\n' +
				"Page #: " + this.pageNum + '\n' +
				"Location: " + this.location ;
				
	}
	
	/**
	 * Prints out contents of list
	 * @param print
	 * @return List
	 */
	public static String toListString(List<process> print) {
		String toPrint = "";
		
		for (int i = 0; i < print.size(); i++) {
			toPrint += print.get(i).toString("List");
		}
		
		return toPrint;
	}
	
	public void checkifPartittionFits (List<Partition> doesItFit) {
		
		for (int i = 0; i < doesItFit.size(); i++) {
			if(doesItFit.get(i).getfreeSpace() > this.size) {
				doesItFit.get(i).setOccupied(true);
				
				this.inUse = true;		
				this.whichBlock = i;	
			}
		}

	}
	
	/**
	 * Modified Code from GeeksforGeeks
	 * https://www.geeksforgeeks.org/generating-random-numbers-in-java/
	 * @return random number
	 */
    public static int genSize()
    { 
        // create instance of Random class 
        Random rand = new Random(); 
        int rand_int; 
        // Generate random integers in range 0 to 5 
        do {
        	rand_int = rand.nextInt(1000) % 800; 
        }while (rand_int < 120);
 
        return rand_int;
    } 
	
}
