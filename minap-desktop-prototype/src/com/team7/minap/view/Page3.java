package com.team7.minap.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Page3 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page3 window = new Page3();
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
	public Page3() {
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
		
		textField = new JTextField();
		textField.setBounds(107, 238, 269, 41);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(357, 6, 117, 29);
		panel.add(btnLogout);
		
		JButton btnSearch = new JButton("Search!");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setBounds(179, 291, 113, 43);
		panel.add(btnSearch);
		
		JButton btnShowallrecrods = new JButton("Show All Recrods");
		btnShowallrecrods.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnShowallrecrods.setBounds(163, 392, 144, 51);
		panel.add(btnShowallrecrods);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(0, 575, 117, 41);
		panel.add(btnBack);
	}

}
