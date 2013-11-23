package com.team7.minap.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Page6 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page6 window = new Page6();
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
	public Page6() {
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
		
		JPanel navigationPage = new JPanel();
		navigationPage.setBounds(0, 0, 480, 640);
		frame.getContentPane().add(navigationPage);
		navigationPage.setLayout(null);
		
		JButton btnInitalDiagnosis = new JButton("Inital Diagnosis");
		btnInitalDiagnosis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInitalDiagnosis.setBounds(129, 105, 199, 83);
		navigationPage.add(btnInitalDiagnosis);
		
		JButton btnDemographicsAndAdmission = new JButton("Demographics and Admission");
		btnDemographicsAndAdmission.setBounds(129, 209, 199, 83);
		navigationPage.add(btnDemographicsAndAdmission);
		
		JLabel lblNavigation = new JLabel("Navigation");
		lblNavigation.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNavigation.setBounds(178, 19, 115, 34);
		navigationPage.add(lblNavigation);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(340, 211, 117, 79);
		navigationPage.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(6, 209, 117, 83);
		navigationPage.add(btnNewButton_1);
		
		JButton btnInitalReperfusion = new JButton("Inital Reperfusion");
		btnInitalReperfusion.setBounds(129, 325, 199, 83);
		navigationPage.add(btnInitalReperfusion);
		
		JButton button_2 = new JButton("New button");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setBounds(340, 327, 117, 79);
		navigationPage.add(button_2);
		
		JButton button_3 = new JButton("New button");
		button_3.setBounds(6, 327, 117, 79);
		navigationPage.add(button_3);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(357, 6, 117, 29);
		navigationPage.add(btnLogout);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(0, 561, 117, 57);
		navigationPage.add(btnBack);
		
		JButton btnNewButton_2 = new JButton("Upload");
		btnNewButton_2.setBounds(176, 475, 117, 57);
		navigationPage.add(btnNewButton_2);
	}
}
