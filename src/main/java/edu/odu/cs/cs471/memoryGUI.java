package edu.odu.cs.cs471;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JList;
import java.awt.BorderLayout;
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
		
		List <Partition> partitions = Partition.prepopulate();
		List <process> processes = new ArrayList<process> ();
		
		String procLst, prtLst, rnLst, procInfo;
		
		
		/**
		 * Process to Launch
		 */
		App2Launch = new JTextField();
		App2Launch.setBounds(39, 559, 116, 22);
		frame.getContentPane().add(App2Launch);
		App2Launch.setColumns(10);
		
//======================================================================		
		/**
		 * ProcessList TextPane
		 */
		JTextPane ProcessList = new JTextPane();
		ProcessList.setBounds(39, 52, 279, 429);
		frame.getContentPane().add(ProcessList);
		
		/**
		 * Partitions TextPane
		 */
		JTextPane Partitions = new JTextPane();
		Partitions.setBounds(351, 52, 259, 435);
		frame.getContentPane().add(Partitions);
		
		/**
		 * Running TextPane
		 */
		JTextPane Running = new JTextPane();
		Running.setBounds(663, 52, 273, 334);
		frame.getContentPane().add(Running);
		
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
				processes.add(new process(App2Launch.getText(), processes.size() - 57));
				App2Launch.setText("");
				
				//check if process fits in a partition
				for (int i = 0; i < processes.size(); i++) {
					processes.get(i).checkifPartittionFits(partitions);
				}
				
				//update output
				ProcessList.setText(process.toListString(processes));
				Partition.toListString(partitions);
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
				
				int i = 0;
				do {
					if (processes.get(i).getinUse()) {
						processes.remove(i);
					}
				}while(!processes.get(i).getinUse());

			}
		});
		btnTerminate.setBounds(345, 558, 97, 25);
		frame.getContentPane().add(btnTerminate);
		
		/**
		 * Status
		 */
		JButton btnStatus = new JButton("Status");
		btnStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
