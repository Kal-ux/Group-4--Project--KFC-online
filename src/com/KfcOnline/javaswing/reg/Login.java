package com.KfcOnline.javaswing.reg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	
	Connection conn =null;

	private JPanel contentPane;
	private JTextField Name;
	private JTextField IDNumber;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public void validateUser() {
		String name=Name.getText();
		String ID=IDNumber.getText();
		String Vpassword=password.getText();
		
		
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost/userregistration","root","");
			String url ="SELECT `Name`,`IDNumber`,`password` FROM `user` WHERE `Name`='"+name+"' and `IDNumber`='"+ID+"' and `password`='"+Vpassword+"'";
			
			Statement st=conn.createStatement();
			ResultSet set=st.executeQuery(url);
			
			if (!set.next()) {
				JOptionPane.showMessageDialog(this, "Invalid Name, ID OR Password");
			}
			
		}catch (Exception e) {
			
		}
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 437);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new RegisterForm().setVisible(true);;
			}
		});
		btnRegister.setBackground(new Color(173, 255, 47));
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegister.setBounds(224, 364, 89, 23);
		contentPane.add(btnRegister);
		
		Name = new JTextField();
		Name.setBounds(154, 108, 234, 35);
		contentPane.add(Name);
		Name.setColumns(10);
		
		IDNumber = new JTextField();
		IDNumber.setBounds(154, 181, 234, 35);
		contentPane.add(IDNumber);
		IDNumber.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(154, 253, 234, 35);
		contentPane.add(password);
		
		JRadioButton rdbtnCustomer = new JRadioButton("Customer");
		rdbtnCustomer.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnCustomer.setForeground(Color.WHITE);
		rdbtnCustomer.setBackground(Color.RED);
		rdbtnCustomer.setBounds(39, 57, 109, 23);
		contentPane.add(rdbtnCustomer);
		
		JRadioButton rdbtnEmployee = new JRadioButton("Employee");
		rdbtnEmployee.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnEmployee.setForeground(Color.WHITE);
		rdbtnEmployee.setBackground(Color.RED);
		rdbtnEmployee.setBounds(398, 55, 109, 23);
		contentPane.add(rdbtnEmployee);
		
		JButton LoginBtn = new JButton("Login");
		LoginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validateUser();
			}
		});
		LoginBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		LoginBtn.setBackground(new Color(173, 255, 47));
		LoginBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		LoginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name=Name.getText();
				String id=IDNumber.getText();
				String pass=password.getText();
				
				if (name.equals("")) {
					JOptionPane.showMessageDialog(null, "name is required");
				}
				
				if (id.equals("")) {
					JOptionPane.showMessageDialog(null, "ID is required");
				}
				if (pass.equals("")) {
					JOptionPane.showMessageDialog(null, "Password is required");
				}
				else {
				new MenuJFrame().setVisible(true);
				}
			}
		});
		LoginBtn.setBounds(224, 299, 89, 23);
		contentPane.add(LoginBtn);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(154, 87, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblIdNumber = new JLabel("ID Number");
		lblIdNumber.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIdNumber.setForeground(Color.WHITE);
		lblIdNumber.setBounds(154, 161, 69, 14);
		contentPane.add(lblIdNumber);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(154, 232, 59, 14);
		contentPane.add(lblPassword);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(224, 11, 99, 40);
		contentPane.add(lblLogin);
		
		JLabel label = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/kfc-icon.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(357, 67, 262, 438);
		contentPane.add(label);
		
		JLabel lblNoAccountCreate = new JLabel("No Account? Create one");
		lblNoAccountCreate.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNoAccountCreate.setForeground(new Color(255, 255, 255));
		lblNoAccountCreate.setBounds(208, 345, 144, 14);
		contentPane.add(lblNoAccountCreate);
	}
}
