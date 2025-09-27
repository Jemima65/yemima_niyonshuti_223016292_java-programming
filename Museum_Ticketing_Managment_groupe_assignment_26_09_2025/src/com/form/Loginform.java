
//GROUP ASSIGNMENT_26_09_2025
//GROUP 15
//NIYONSABA Erina 223007511
//NIYIGENA Djamila 223017067
//NIYONSHUTI Yemima 223016292
package com.form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.util.db.MuseumDB;

public class Loginform extends JFrame implements ActionListener{
	
	JTextField userText=new JTextField("enter user name");
	JPasswordField passText=new JPasswordField("password");
	
	JButton loginbtn=new JButton("login");
	JButton cancelbtn=new JButton("cancel");
	
	//
	public Loginform(){
		setTitle("login form");
		setBounds(100,100,300,250);
		setLayout(null);
		
		userText.setBounds(50,30,120,25);
		passText.setBounds(50,70,120,25);
		
		loginbtn.setBounds(20,100,120,30);
		cancelbtn.setBounds(150,100,120,30);
		
		add(userText);
		add(passText);
		add(loginbtn);
		add(cancelbtn);
		
		loginbtn.addActionListener(this);
		cancelbtn.addActionListener(this);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}	
	

	public void actionPerformed(ActionEvent e) {
		try(Connection con=MuseumDB.getConnection()){
		String sql="select* FROM user WHERE username=? AND password=?";
		PreparedStatement ps=con.prepareCall(sql);
		
		ps.setString(1,userText.getText());
		ps.setString(2,new String(passText.getPassword()));
		
		ResultSet rs=ps.executeQuery();
		if (rs.next()){
			String role=rs.getString("role");
			dispose();
			new Museum_Ticket(role,rs.getInt("userid"));
			}
		else{
			JOptionPane.showMessageDialog(this, "invalid");
		}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		}
		
		
		
		
		
	}
	

	

	
