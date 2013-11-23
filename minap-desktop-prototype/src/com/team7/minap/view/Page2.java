package com.team7.minap.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Page2 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page2 window = new Page2();
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
	public Page2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 480, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 480, 640);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton createNewRecord = new JButton("Create New Record");
		createNewRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		createNewRecord.setBounds(111, 195, 251, 75);
		panel.add(createNewRecord);
		
		JButton readRecord = new JButton("Read Record");
		readRecord.setBounds(111, 331, 251, 75);
		panel.add(readRecord);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(357, 6, 117, 29);
		panel.add(btnLogout);
	}

}
