package com.team7.minap.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class Page4 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page4 window = new Page4();
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
	public Page4() {
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
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(363, 6, 117, 29);
		panel.add(btnLogout);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(0, 569, 117, 42);
		panel.add(btnBack);
		
		JLabel lblSearchResults = new JLabel("      Search Results");
		lblSearchResults.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblSearchResults.setBounds(133, 118, 195, 61);
		panel.add(lblSearchResults);
		
		JButton btnNewSearch = new JButton("New Search");
		btnNewSearch.setBounds(295, 439, 117, 42);
		panel.add(btnNewSearch);
	}
}
