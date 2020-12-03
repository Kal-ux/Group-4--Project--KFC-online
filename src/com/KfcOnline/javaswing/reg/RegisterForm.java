package com.KfcOnline.javaswing.reg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class RegisterForm extends javax.swing.JFrame {
	
	Connection conn =null;
	PreparedStatement pst=null;

	private JPanel contentPane;
	private JTextField Name;
	private JTextField Email;
	private JTextField IDNumber;
	private JPasswordField password;
	private JTextField phoneNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterForm frame = new RegisterForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the form.
	 */
	public RegisterForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 398, 523);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		phoneNo = new JTextField();
		phoneNo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		phoneNo.setColumns(10);
		phoneNo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		phoneNo.setBounds(87, 293, 205, 33);
		contentPane.add(phoneNo);
		
		Name = new JTextField();
		Name.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Name.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Name.setBounds(87, 89, 205, 33);
		contentPane.add(Name);
		Name.setColumns(10);
		
		Email = new JTextField();
		Email.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Email.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Email.setColumns(10);
		Email.setBounds(87, 155, 205, 33);
		contentPane.add(Email);
		
		IDNumber = new JTextField();
		IDNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		IDNumber.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		IDNumber.setColumns(10);
		IDNumber.setBounds(87, 218, 205, 33);
		contentPane.add(IDNumber);
		
		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 13));
		password.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		password.setColumns(10);
		password.setBounds(87, 354, 205, 33);
		contentPane.add(password);
		
		JLabel lblRegister = new JLabel("REGISTER");
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setForeground(new Color(255, 255, 255));
		lblRegister.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRegister.setBounds(87, 11, 205, 27);
		contentPane.add(lblRegister);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(89, 72, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(87, 133, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblIdNumber = new JLabel("ID Number:");
		lblIdNumber.setForeground(Color.WHITE);
		lblIdNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdNumber.setBounds(87, 199, 98, 14);
		contentPane.add(lblIdNumber);
		
		JLabel lblEmail_1_1 = new JLabel("Password:");
		lblEmail_1_1.setForeground(Color.WHITE);
		lblEmail_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail_1_1.setBounds(87, 337, 98, 14);
		contentPane.add(lblEmail_1_1);
		
		
		JButton btnNewButton = new JButton("Create Account");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=Name.getText();
				String email=Email.getText();
				String id=IDNumber.getText();
				String phone=phoneNo.getText();
				String pass=password.getText();
				
				if (name.equals("")) {
					JOptionPane.showMessageDialog(null, "name is required");
				}
				
				if (email.equals("")) {
					JOptionPane.showMessageDialog(null, "please enter email");
				}
				if (id.equals("")) {
					JOptionPane.showMessageDialog(null, "ID is required");
				}
				if (pass.equals("")) {
					JOptionPane.showMessageDialog(null, "Password is required");
				}
				else {
				try {
					String query = "INSERT INTO `user`(`Name`, `Email`, `IDNumber`, `phoneNo`, `password`) VALUES (?,?,?,?,?)";
					conn = DriverManager.getConnection("jdbc:mysql://localhost/userregistration","root","");
					pst=conn.prepareStatement(query);
					pst.setString(1,Name.getText());
					pst.setString(2,Email.getText());
					pst.setString(3,IDNumber.getText());
					pst.setString(4,phoneNo.getText());
					pst.setString(5,password.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "REGISTRATION SUCCESSFUL!");
					new Login().setVisible(true);
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
				
			}
			
		}	
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(139, 0, 0));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBounds(114, 424, 148, 40);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(178, 34, 34));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(new Color(178, 34, 34));
		lblNewLabel.setBounds(0, 0, 382, 51);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/kfc-icon.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(195, 49, 223, 411);
		contentPane.add(label);
		
		JLabel lblEmail_1_1_2 = new JLabel("Phone Number:");
		lblEmail_1_1_2.setForeground(Color.WHITE);
		lblEmail_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail_1_1_2.setBounds(87, 276, 131, 14);
		contentPane.add(lblEmail_1_1_2);
	}
}
