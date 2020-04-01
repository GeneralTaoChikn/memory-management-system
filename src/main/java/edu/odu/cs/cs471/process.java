package edu.odu.cs.cs471;

import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;
/**
 * Object Class for Process Object
 * @author Chris
 *
 */
public class process {
	
	private String ProcessName;
	private int ProcessNum;
	private double size;
	private int pageNum;
	private String location;
	private boolean inUse;
	private int whichBlock;
	
//======================================================================
///Constructors
	/**
	 * Default Constructor
	 */
	public process() {
		ProcessName = "";
		size = 0;
		pageNum = 0;
		location = "";
		inUse = false;
		whichBlock = -1;
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
		whichBlock = 0;
	}
	
	/**
	 * Constructor with Size
	 * @param procNme
	 * @param procNum
	 * @param pSize
	 */
	public process (String procNme, int procNum, double pSize) {
		ProcessName = procNme;
		ProcessNum = procNum;
		size = pSize;
		pageNum = 0;
		location = "";
		inUse = false;
		whichBlock = 0;
	}
//======================================================================
///Setters
	/**
	 * Sets the process Name
	 * @param process
	 */
	public void setProcName (String process) {
		this.ProcessName = process;
	}
	
	/**
	 * TODO generate a random size
	 */
	public void setSize (double s) {
		this.size = s;
	}
	
	/**
	 * TODO generate random PageNumber
	 */
	public void setpageNum () {
		
	}
	
	/**
	 * Determine whether the process is running or not
	 * @param processing
	 */
	public void setInUse (boolean processing) {
		this.inUse = processing;
	}
	
	public void setwichBlock (int block) {
		this.whichBlock = block;
	}
//======================================================================
///Getters
	

	public String getProcName () {
		return this.ProcessName;
	}
	
	public int getProcNum () {
		return this.ProcessNum;
	}
	
	public double getSize() {
		return this.size;
	}
	public boolean getinUse () {
		return this.inUse;
	}
	
	public int getwhichBlock () {
		return this.whichBlock;
	}
	
//======================================================================
	
	/**@override
	 * Prints out characteristics of Process
	 * @return process characteristics
	 */
	public String toString(String toPrint) {
		//print List
		if (toPrint.equals("List"))
			return " Process: " + this.ProcessName + "  " +
				"Size: " + this.size + " Mb" + '\n';
		
		//Print Status
		else
			return "Process Name: " + this.ProcessName + '\n' +
				"Size: " + this.size + "Mb \n" +
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
		
		for (process ptr : print) {
			toPrint += ptr.toString("List");
		}
		
//		for (int i = 0; i < print.size(); i++) {
//			toPrint += print.get(i).toString("List");
//		}
		
		return toPrint;
	}
	
	public boolean checkifPartittionFits (List<Partition> doesItFit) {
		boolean allocated = false;

		for (int i = 0; i < doesItFit.size(); i++) {

			if ((doesItFit.get(i).getOccupied() == false) && (allocated == false)) {
				if(doesItFit.get(i).getfreeSpace() > this.size) {
					doesItFit.get(i).setOccupied(true);
					doesItFit.get(i).setassignedTo(this.ProcessName);
					doesItFit.get(i).setOcSpace(this.size);
					doesItFit.add(doesItFit.get(i).splitPartition(doesItFit.size()));
					this.pageNum = 0;
					this.location = "Main Memory";
					this.inUse = true;		
					this.whichBlock = i;
					allocated = true;
				}
				else {
					this.location = "Virtual";
					this.pageNum = process.genSize();
					
				}
			}	
		}
		
		return allocated;

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
        	rand_int = rand.nextInt(1000) % 800 ; 
        }while (rand_int < 120);
 
        return rand_int;
    } 
	
}
