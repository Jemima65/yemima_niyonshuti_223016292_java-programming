//GROUP ASSIGNMENT_26_09_2025
//GROUP 15
//NIYONSABA Erina 223007511
//NIYIGENA Djamila 223017067
//NIYONSHUTI Yemima 223016292


package com.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.util.db.MuseumDB;



public class UserPanel extends JPanel implements ActionListener {
	
	JTextField idTxt=new JTextField();
	JTextField nameTxt=new JTextField();
	JTextField emailTxt=new JTextField();
	JTextField roleTxt=new JTextField();
	JPasswordField passTxt=new 	JPasswordField();

	
	JButton addBtn=new JButton("add"),
			updateBtn=new JButton("update"),

	      deleteBtn=new JButton("delete"),
	      loadBtn=new JButton("load");

	JTable table;
	DefaultTableModel model;
	
	public UserPanel(){
		setLayout(null);
		String[]labels={"ID","username","password","email","role"};
		String[]cols= {"userid","username","password","email","role"};
		model=new DefaultTableModel(labels,0);
		table =new JTable(model);
		
		JScrollPane sp=new JScrollPane(table);
		sp.setBounds(20,200,800,300);
		int y=20;
		addField("ID",idTxt,y);
		y+=30;
		addField("username",nameTxt,y);
		y+=30;
		addField("password",passTxt,y);
		y+=30;
		addField("email",emailTxt,y);
		y+=30;
		addField("role",roleTxt,y);

		addButtons();
		add(sp);
	}
		
	private void addField(String lbl, JComponent txt,int y) {
		JLabel l=new JLabel(lbl);
		l.setBounds(20,y,80,25);
		txt.setBounds(100,y,150,25);
		add(l);
		add(txt);
	}
		
	

	private void addButtons() {
		addBtn.setBounds(300,20,100,30);
		updateBtn.setBounds(300,60,100,30);
		deleteBtn.setBounds(300,100,100,30);
		loadBtn.setBounds(300,140,100,30);
		add(addBtn);
		add(updateBtn);
		add(deleteBtn);
		add(loadBtn);

		addBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		loadBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try(Connection con=MuseumDB.getConnection()){
			String sgl=("INSERT INTO user(username,password,email,role) VALUES(?,?,?,?)");
			if(e.getSource()==addBtn){
				PreparedStatement ps=con.prepareStatement(sgl);
			    
				ps.setString(1,nameTxt.getText());
				ps.setString(2,new String(passTxt.getPassword()));
				ps.setString(3,emailTxt.getText());
		        ps.setString(4,roleTxt.getText());
				ps.executeUpdate();
					JOptionPane.showMessageDialog(this, "insert successfully");
			}
			else if(e.getSource()==updateBtn){
				sgl="UPDATE user SET username=?,email=?,role=? WHERE userid=?";
				PreparedStatement ps=con.prepareStatement(sgl);
		        ps.setString(1,nameTxt.getText());
		        ps.setString(2,emailTxt.getText());
				ps.setString(3,roleTxt.getText());
				ps.setInt(4,Integer.parseInt(idTxt.getText()));
				ps.executeUpdate();
				JOptionPane.showMessageDialog(this, "update successfully");
				}
			else if(e.getSource()==deleteBtn){
				sgl="DELETE FROM user WHERE userid=?";
	            		PreparedStatement ps=con.prepareStatement(sgl);
				   
				    ps.setInt(1,Integer.parseInt(idTxt.getText()));
				    ps.executeUpdate();
				    JOptionPane.showMessageDialog(this, "delete successfully");
			}
			
			else if(e.getSource()==loadBtn){
				model.setRowCount(0);
				sgl="SELECT *FROM user";
				ResultSet rs=con.createStatement().executeQuery(sgl);
				while(rs.next()){
				model.addRow(new Object[]{
						rs.getInt("userid"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("email"),
						rs.getString("role")
				});
				}
			}
			
			
	}catch(Exception Ex){ Ex.printStackTrace();}
}}


