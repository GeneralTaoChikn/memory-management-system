package edu.odu.cs.cs471;

public class process {
	
	private String ProcessName;
	private double size;
	private int pageNum;
	private String location;
	private boolean inUse;
	
	public process() {
		ProcessName = "";
		size = 0;
		pageNum = 0;
		location = "";
		inUse = false;
		
	}
	
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
	public void setSize () {
		
	}
	
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
	
	
	
	/**
	 * Retrieve Process Name
	 * @return process name
	 */
	public String getProcName () {
		return this.ProcessName;
	}
	
	/**@override
	 * Prints out characteristics of Process
	 * @return process characteristics
	 */
	public String toString() {
		return "Process Name: " + this.ProcessName + '\n' +
				"Size: " + this.size + '\n' +
				"Page #: " + this.pageNum + '\n' +
				"Location: " + this.location ;
				
	}
	
}
