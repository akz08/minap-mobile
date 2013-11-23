package com.team7.minap.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Page5 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page5 window = new Page5();
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
	public Page5() {
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
		
		JPanel sampleCrationPage = new JPanel();
		sampleCrationPage.setBounds(0, 0, 480, 640);
		frame.getContentPane().add(sampleCrationPage);
		sampleCrationPage.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(168, 177, 178, 28);
		sampleCrationPage.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(168, 217, 178, 28);
		sampleCrationPage.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(168, 257, 178, 28);
		sampleCrationPage.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(168, 297, 178, 28);
		sampleCrationPage.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(168, 337, 178, 28);
		sampleCrationPage.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(168, 377, 178, 28);
		sampleCrationPage.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(78, 183, 78, 16);
		sampleCrationPage.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(78, 223, 78, 16);
		sampleCrationPage.add(lblLastName);
		
		JLabel lblNewLabel = new JLabel("Hospital No.");
		lblNewLabel.setBounds(78, 263, 79, 16);
		sampleCrationPage.add(lblNewLabel);
		
		JLabel lblNhsNo = new JLabel("NHS No.");
		lblNhsNo.setBounds(89, 303, 59, 16);
		sampleCrationPage.add(lblNhsNo);
		
		JLabel lblPatientsInfo = new JLabel("Patient's info");
		lblPatientsInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPatientsInfo.setBounds(179, 102, 136, 50);
		sampleCrationPage.add(lblPatientsInfo);
		
		JLabel lblAdmissionTime = new JLabel("Admission Time");
		lblAdmissionTime.setBounds(54, 343, 102, 16);
		sampleCrationPage.add(lblAdmissionTime);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setBounds(112, 383, 34, 16);
		sampleCrationPage.add(lblDob);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(357, 6, 117, 29);
		sampleCrationPage.add(btnLogout);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(0, 554, 117, 62);
		sampleCrationPage.add(btnBack);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(357, 554, 117, 62);
		sampleCrationPage.add(btnNext);
		
		JButton btnNavigation = new JButton("Navigation");
		btnNavigation.setBounds(179, 541, 117, 75);
		sampleCrationPage.add(btnNavigation);
	}
}
