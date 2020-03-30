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

public class memoryGUI {

	private JFrame frame;
	private JTextField textField;

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
		
		textField = new JTextField();
		textField.setBounds(39, 559, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnLaunch = new JButton("Launch");
		btnLaunch.setBounds(204, 558, 97, 25);
		frame.getContentPane().add(btnLaunch);
		
		JLabel lblProcess = new JLabel("Process");
		lblProcess.setBounds(39, 542, 56, 16);
		frame.getContentPane().add(lblProcess);
		
		JButton btnTerminate = new JButton("Terminate");
		btnTerminate.setBounds(345, 558, 97, 25);
		frame.getContentPane().add(btnTerminate);
		
		JButton btnStatus = new JButton("Status.");
		btnStatus.setBounds(494, 558, 97, 25);
		frame.getContentPane().add(btnStatus);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(663, 415, 279, 178);
		frame.getContentPane().add(textPane);
		
		JTextPane ProcessList = new JTextPane();
		ProcessList.setBounds(39, 52, 279, 429);
		frame.getContentPane().add(ProcessList);
		
		JTextPane Partitions = new JTextPane();
		Partitions.setBounds(351, 52, 259, 435);
		frame.getContentPane().add(Partitions);
		
		JTextPane Running = new JTextPane();
		Running.setBounds(663, 52, 273, 334);
		frame.getContentPane().add(Running);
		
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
