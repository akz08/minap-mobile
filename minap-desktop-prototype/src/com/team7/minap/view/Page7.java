package com.team7.minap.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;

import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class Page7 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page7 window = new Page7();
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
	public Page7() {
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
		
		JPanel intialDiagnosis = new JPanel();
		intialDiagnosis.setBounds(0, 6, 480, 640);
		frame.getContentPane().add(intialDiagnosis);
		intialDiagnosis.setLayout(null);
		
		JLabel lblWhatIsYour = new JLabel("What is your working diagnosis?");
		lblWhatIsYour.setBounds(100, 63, 260, 53);
		intialDiagnosis.add(lblWhatIsYour);
		lblWhatIsYour.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JLabel lblInitalDiagnosis = new JLabel("Inital Diagnosis");
		lblInitalDiagnosis.setBounds(154, 6, 159, 53);
		intialDiagnosis.add(lblInitalDiagnosis);
		lblInitalDiagnosis.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("1. Definite myocardial infarction");
		rdbtnNewRadioButton.setBounds(100, 111, 295, 23);
		intialDiagnosis.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		
		JRadioButton rdbtnAcuteCoronary = new JRadioButton("2. Acute coronary syndorme");
		rdbtnAcuteCoronary.setBounds(100, 146, 295, 23);
		intialDiagnosis.add(rdbtnAcuteCoronary);
		rdbtnAcuteCoronary.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		
		JRadioButton rdbtnChestPain = new JRadioButton("3. Chest pain? cause");
		rdbtnChestPain.setBounds(100, 181, 295, 23);
		intialDiagnosis.add(rdbtnChestPain);
		rdbtnChestPain.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		
		JRadioButton rdbtnOtherIntialDiagnosis = new JRadioButton("4. Other intial diagnosis");
		rdbtnOtherIntialDiagnosis.setBounds(100, 222, 295, 23);
		intialDiagnosis.add(rdbtnOtherIntialDiagnosis);
		rdbtnOtherIntialDiagnosis.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		
		JLabel lblAdmissionAfterTreatment = new JLabel("Admission after treatment for STEMI elsewhere?");
		lblAdmissionAfterTreatment.setBounds(43, 272, 383, 23);
		intialDiagnosis.add(lblAdmissionAfterTreatment);
		lblAdmissionAfterTreatment.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JButton btnYes = new JButton("Yes");
		btnYes.setBounds(91, 307, 117, 29);
		intialDiagnosis.add(btnYes);
		
		JButton btnNo = new JButton("No");
		btnNo.setBounds(243, 307, 117, 29);
		intialDiagnosis.add(btnNo);
		
		JLabel lblProcedurePerformedAt = new JLabel("Procedure performed at the Interventional Hospital?");
		lblProcedurePerformedAt.setBounds(61, 344, 365, 36);
		intialDiagnosis.add(lblProcedurePerformedAt);
		lblProcedurePerformedAt.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(100, 391, 260, 27);
		intialDiagnosis.add(comboBox);
		
		JLabel lblInterventionalCentre = new JLabel("Interventional Centre");
		lblInterventionalCentre.setBounds(43, 437, 153, 29);
		intialDiagnosis.add(lblInterventionalCentre);
		lblInterventionalCentre.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(208, 440, 178, 27);
		intialDiagnosis.add(comboBox_1);
		
		JLabel lblDateOfReturn = new JLabel("Date of Return");
		lblDateOfReturn.setBounds(43, 478, 105, 36);
		intialDiagnosis.add(lblDateOfReturn);
		lblDateOfReturn.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(189, 485, 171, 27);
		intialDiagnosis.add(comboBox_2);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogout.setBounds(363, 6, 117, 29);
		intialDiagnosis.add(btnLogout);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack.setBounds(0, 561, 117, 53);
		intialDiagnosis.add(btnBack);
		
		JButton btnNavigation = new JButton("Navigation");
		btnNavigation.setBounds(185, 561, 117, 53);
		intialDiagnosis.add(btnNavigation);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(357, 561, 117, 53);
		intialDiagnosis.add(btnNext);
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
