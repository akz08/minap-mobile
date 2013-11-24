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
		btnInitalDiagnosis.setBounds(129, 178, 199, 70);
		navigationPage.add(btnInitalDiagnosis);
		
		JButton btnDemographicsAndAdmission = new JButton("Demographics and Admission");
		btnDemographicsAndAdmission.setBounds(129, 275, 199, 70);
		navigationPage.add(btnDemographicsAndAdmission);
		
		JLabel lblNavigation = new JLabel("Navigation");
		lblNavigation.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNavigation.setBounds(178, 19, 115, 34);
		navigationPage.add(lblNavigation);
		
		JButton btnNewButton = new JButton("Path two");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(340, 275, 117, 70);
		navigationPage.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Path one");
		btnNewButton_1.setBounds(6, 275, 117, 70);
		navigationPage.add(btnNewButton_1);
		
		JButton btnInitalReperfusion = new JButton("Inital Reperfusion");
		btnInitalReperfusion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInitalReperfusion.setBounds(129, 379, 199, 70);
		navigationPage.add(btnInitalReperfusion);
		
		JButton btnPathFour = new JButton("Path four");
		btnPathFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPathFour.setBounds(340, 379, 117, 70);
		navigationPage.add(btnPathFour);
		
		JButton btnPathThree = new JButton("Path three");
		btnPathThree.setBounds(6, 379, 117, 70);
		navigationPage.add(btnPathThree);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(357, 6, 117, 29);
		navigationPage.add(btnLogout);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(0, 561, 117, 57);
		navigationPage.add(btnBack);
		
		JButton btnNewButton_2 = new JButton("Upload");
		btnNewButton_2.setBounds(176, 488, 117, 57);
		navigationPage.add(btnNewButton_2);
		
		JButton btnPatientsInfo = new JButton("Patient's Info");
		btnPatientsInfo.setBounds(129, 85, 199, 70);
		navigationPage.add(btnPatientsInfo);
	}
}
