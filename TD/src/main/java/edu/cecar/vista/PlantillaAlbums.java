package edu.cecar.vista;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import edu.cecar.modelo.Albums;

public class PlantillaAlbums extends JPanel {
	private JTextField txtEmail;
	private JTextField txtId;
	private JTextField txtPostId;


	public PlantillaAlbums(int x, int y, Albums albums) {
		setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		setBackground(Color.WHITE);
		setBounds(x, y, 1000, 150);
		setLayout(null);
		
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(10, 11, 46, 14);
		add(lblId);
		
		JLabel lblPostid = new JLabel("UserID");
		lblPostid.setBounds(82, 11, 46, 14);
		add(lblPostid);
		
		
		
	
		
		
		JLabel lblEmail = new JLabel("Title");
		lblEmail.setBounds(395, 11, 46, 14);
		add(lblEmail);
		
		txtEmail = new JTextField(albums.getTitle());
		txtEmail.setBounds(322, 38, 195, 20);	
		add(txtEmail);
		txtEmail.setColumns(10);
		
		
		
		txtId = new JTextField(albums.getId());
		txtId.setBounds(10, 38, 46, 20);
		add(txtId);
		txtId.setColumns(10);
		
		txtPostId = new JTextField(albums.getUserID());
		txtPostId.setBounds(66, 38, 83, 20);
		add(txtPostId);
		txtPostId.setColumns(10);

	}
}
