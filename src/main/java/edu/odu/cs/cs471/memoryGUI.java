package edu.odu.cs.cs471;

import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.JList;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class memoryGUI {

	private JFrame frame;
	private JTextField App2Launch;
	private int processCount = 0;
	private JTextField ProcStatus;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					memoryGUI window = new memoryGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public memoryGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 680);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
//		List <Partition> partitions = Partition.prepopulate();
		List <Partition> partitions = new ArrayList<Partition> ();
		partitions.clear();
		partitions.add(new Partition (partitions.size(), 512));
		
		List <process> processes = new ArrayList<process> ();
		processes.clear();
		
		
		/**
		 * Process to Launch
		 */
		App2Launch = new JTextField();
		App2Launch.setBounds(39, 559, 116, 22);
		frame.getContentPane().add(App2Launch);
		App2Launch.setColumns(10);
		
		ProcStatus = new JTextField();
		ProcStatus.setBounds(454, 559, 63, 22);
		frame.getContentPane().add(ProcStatus);
		ProcStatus.setColumns(10);
		
		/**
		 * Process List
		 */
		JTextPane ProcessList = new JTextPane();
		ProcessList.setBounds(12, 52, 305, 435);
		frame.getContentPane().add(ProcessList);
		
		/**
		 * Partitions TextPane
		 */
		JTextPane Running = new JTextPane();
		Running.setBounds(329, 52, 305, 435);
		frame.getContentPane().add(Running);
		
		/**
		 * Running TextPane
		 */
		JTextPane Partitions = new JTextPane();
		Partitions.setBounds(663, 52, 273, 334);
		frame.getContentPane().add(Partitions);
		
		/**
		 * ProcessInfo TextPane
		 */
		JTextPane ProcessInfo = new JTextPane();
		ProcessInfo.setBounds(663, 415, 279, 178);
		frame.getContentPane().add(ProcessInfo);
		
//======================================================================
		/**
		 * Launch
		 */
		JButton btnLaunch = new JButton("Launch");
		btnLaunch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//add Process
//				processes.add(new process(App2Launch.getText(), processes.size() - 57));
				processes.add(new process(App2Launch.getText(), processCount));
				processCount++;
				App2Launch.setText("");
				
				//check if process fits in a partition
				for (int i = 0; i < processes.size(); i++) {
					processes.get(i).checkifPartittionFits(partitions);
				}
				
				//update output
				ProcessList.setText(process.toListString(processes));
				Running.setText(Partition.toListString(partitions,"used"));
				Partitions.setText(Partition.toListString(partitions, "free"));
			}
		});
		btnLaunch.setBounds(204, 558, 97, 25);
		frame.getContentPane().add(btnLaunch);
		
		/**
		 * Terminate
		 */
		JButton btnTerminate = new JButton("Terminate");
		btnTerminate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//TODO Remove a running process
				//Run next process
				
				
				int p = 0;
				boolean rmvElement = false;
				
				do {
					if (processes.get(p).getinUse() == true) {
						
						//reset allocated partition
						partitions.get(processes.get(p).getwhichBlock()).resetPartition();
						Running.setText(Partition.toListString(partitions, "used"));
						
						//remove process
						processes.remove(p);
						//if executed, exit while loop
						rmvElement = true;
						for (int i = 0; i < processes.size(); i++) {
							processes.get(i).checkifPartittionFits(partitions);
						}
					}
					
					p++;
				}while(rmvElement == false  || p < processes.size());
				
				//update output
				ProcessList.setText(process.toListString(processes));
				Running.setText(Partition.toListString(partitions,"used"));
				Partitions.setText(Partition.toListString(partitions, "free"));
				
//				App2Launch.setText(Integer.toString(processes.size()));

			}
		});
		btnTerminate.setBounds(311, 558, 97, 25);
		frame.getContentPane().add(btnTerminate);
		
		
		/**
		 * Status
		 */
		JButton btnStatus = new JButton("Status");
		btnStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				int n = Integer.parseInt(ProcStatus.getText());
//				int i = 0;
//				do {
//					if ((processes.get(i).getProcNum() != n))
//						i++;
//					else
//						ProcessInfo.setText(processes.get(i-1).toString(""));
//					
//				}while((i < processes.size()) &&(processes.get(i).getProcNum() != n));
////				for (int i = 0; i < processes.size(); i++) {
////					if (Integer.compare(processes.get(i).getProcNum(), n))
////						ProcessInfo.setText(processes.get(i).toString(""));
////				}
////		
				if(ProcStatus.getText() != "") {
					int n = Integer.parseInt(ProcStatus.getText());
					ProcessInfo.setText(processes.get(n).toString(""));
					ProcStatus.setText("");
				}
			}
		});
		btnStatus.setBounds(529, 558, 97, 25);
		frame.getContentPane().add(btnStatus);
		
//======================================================================
		/**
		 * JLabels
		 */
		JLabel lblProcess = new JLabel("Process");
		lblProcess.setBounds(39, 542, 56, 16);
		frame.getContentPane().add(lblProcess);
		
		JLabel lblProcesses = new JLabel("Processes");
		lblProcesses.setBounds(39, 25, 82, 16);
		frame.getContentPane().add(lblProcesses);
		
		JLabel lblUsed = new JLabel("Blockes Used & Processes");
		lblUsed.setBounds(355, 25, 220, 16);
		frame.getContentPane().add(lblUsed);
		
		JLabel lblFreeBlocks = new JLabel("Free Blocks");
		lblFreeBlocks.setBounds(663, 25, 102, 16);
		frame.getContentPane().add(lblFreeBlocks);
		
		JLabel lblProcessInformation = new JLabel("Process Information");
		lblProcessInformation.setBounds(663, 396, 116, 16);
		frame.getContentPane().add(lblProcessInformation);

	}
}
