package com.team7.minap.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JLayeredPane;

public class Page1 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page1 window = new Page1();
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
	public Page1() {
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
		frame.setPreferredSize(new Dimension(480, 640));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel loginPage = new JPanel();
		loginPage.setForeground(Color.LIGHT_GRAY);
		loginPage.setPreferredSize(new Dimension(480, 640));
		loginPage.setBounds(0, 0, 480, 640);
		frame.getContentPane().add(loginPage);
		loginPage.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(177, 269, 174, 28);
		loginPage.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(177, 229, 174, 28);
		loginPage.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(104, 235, 62, 16);
		loginPage.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(104, 275, 59, 16);
		loginPage.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(160, 353, 148, 29);
		loginPage.add(btnNewButton);
		
		//windowbuilder sucks!
		frame.pack();
		frame.setVisible(true);
	}
}
