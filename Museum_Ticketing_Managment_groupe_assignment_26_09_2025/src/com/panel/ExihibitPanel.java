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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.util.db.MuseumDB;

public class ExihibitPanel extends JPanel implements ActionListener{
	JTextField exhibitidTxt=new JTextField();
	JTextField categoryTxt=new JTextField();
	JTextField ownerTxt=new JTextField();
	JTextField locationTxt=new JTextField();
	
	JButton addBtn=new JButton("add"),
			updateBtn=new JButton("update"),

	      deleteBtn=new JButton("delete"),
	      loadBtn=new JButton("load");

	JTable table;
	DefaultTableModel model;
	
	public ExihibitPanel(){
		setLayout(null);
		String[]labels={"Exihibitid","category","owner","location"};
		String[]cols= {"Exihibitid","category","owner","location"};
		model=new DefaultTableModel(labels,0);
		table =new JTable(model);
		JScrollPane sp=new JScrollPane(table);
		sp.setBounds(20,200,800,300);
		int y=20;
		
		addField("Exihibit",exhibitidTxt,y);
		y+=30;
		addField("category",categoryTxt,y);
		y+=30;
		addField("owner",ownerTxt,y);
		y+=30;
		addField("location",locationTxt,y);
		y+=30;
		

		addButtons();
		add(sp);
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

	private void addField(String lbl, JComponent txt,int y) {
		JLabel l=new JLabel(lbl);
		l.setBounds(20,y,80,25);
		txt.setBounds(100,y,150,25);
		add(l);
		add(txt);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try(Connection con=MuseumDB.getConnection()){
			String sgl=("INSERT INTO exihibit(category,owner,location) VALUES(?,?,?)");
			if(e.getSource()==addBtn){
				PreparedStatement ps=con.prepareStatement(sgl);
			    
				ps.setString(1,categoryTxt.getText());
		        ps.setString(2,ownerTxt.getText());
		        ps.setString(3,locationTxt.getText());
				ps.executeUpdate();
					JOptionPane.showMessageDialog(this, "insert successfully");
			}
			else if(e.getSource()==updateBtn){
				sgl="UPDATE exihibit SET category=?,owner=?,location=? WHERE exhibitid=?";
				PreparedStatement ps=con.prepareStatement(sgl);
				ps.setString(1,categoryTxt.getText());
		        ps.setString(2,ownerTxt.getText());
		        ps.setString(3,locationTxt.getText());
		        ps.setInt(4,Integer.parseInt(exhibitidTxt.getText()));
				ps.executeUpdate();
				JOptionPane.showMessageDialog(this, "update successfully");
			}
			else if(e.getSource()==deleteBtn){
				sgl="DELETE FROM exihibit WHERE exhibitid=?";
	            		PreparedStatement ps=con.prepareStatement(sgl);
				 
				    ps.setInt(1,Integer.parseInt(exhibitidTxt.getText()));
				    ps.executeUpdate();
				    JOptionPane.showMessageDialog(this, "delete successfully");
			}
		
			else if(e.getSource()==loadBtn){
				model.setRowCount(0);
				sgl="SELECT *FROM exihibit";
				ResultSet rs=con.createStatement().executeQuery(sgl);
				while(rs.next()){
				model.addRow(new Object[]{
						rs.getInt("exhibitid"),
						rs.getString("category"),
						rs.getString("owner"),
						rs.getString("location")
					
				});
				}
			}
			
			
	}catch(Exception Ex){ Ex.printStackTrace();}
}}


