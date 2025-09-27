//GROUP ASSIGNMENT_26_09_2025
//GROUP 15
//NIYONSABA Erina 223007511
//NIYIGENA Djamila 223017067
//NIYONSHUTI Yemima 223016292


package com.form;

import java.awt.BorderLayout;

import javax.swing.*;

import com.panel.*;



public class Museum_Ticket extends JFrame {

	JTabbedPane tabs=new JTabbedPane();
	
	//constructor
	
	public  Museum_Ticket(String role,int userid){
		setTitle("Museum ticket");
		setSize(900,600);
		setLayout(new BorderLayout());
		if (role.equalsIgnoreCase("admin")){
			
			tabs.add("user",new UserPanel());
			tabs.add("ticket",new TicketPanel());
			tabs.add("Exihibit",new ExihibitPanel());
			
		}
		else if (role.equalsIgnoreCase("ticket")){
			tabs.add("ticket",new TicketPanel());
			}
		else if (role.equalsIgnoreCase("exihibit")){
			tabs.add("display",new ExihibitPanel());
			
		}
		add(tabs,BorderLayout.CENTER);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}


	
	

}
