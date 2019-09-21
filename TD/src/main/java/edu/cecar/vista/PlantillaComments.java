package edu.cecar.vista;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import edu.cecar.modelo.Comments;

public class PlantillaComments extends JPanel {
	private JTextField txtEmail;
	private JTextField txtId;
	private JTextField txtPostId;


	public PlantillaComments(int x, int y, Comments comments) {
		setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		setBackground(Color.WHITE);
		setBounds(x, y, 1000, 150);
		setLayout(null);
		
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(10, 11, 46, 14);
		add(lblId);
		
		JLabel lblPostid = new JLabel("postId");
		lblPostid.setBounds(82, 11, 46, 14);
		add(lblPostid);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(201, 11, 46, 14);
		add(lblName);
		
		JLabel lblNewLabel = new JLabel("Body");
		lblNewLabel.setBounds(702, 11, 46, 14);
		add(lblNewLabel);
		
		JTextArea txtBody = new JTextArea();
		txtBody.setBorder(new LineBorder(Color.BLACK));
		txtBody.setWrapStyleWord(true);
		txtBody.setLineWrap(true);
		txtBody.setBounds(527, 36, 463, 101);
		txtBody.append(comments.getBody());
		add(txtBody);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(395, 11, 46, 14);
		add(lblEmail);
		
		txtEmail = new JTextField(comments.getEmail());
		txtEmail.setBounds(322, 38, 195, 20);
		add(txtEmail);
		txtEmail.setColumns(10);
		
		JTextArea txtName = new JTextArea(comments.getName());
		txtName.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtName.setBounds(159, 36, 153, 42);
		add(txtName);
		
		txtId = new JTextField(comments.getId());
		txtId.setBounds(10, 38, 46, 20);
		add(txtId);
		txtId.setColumns(10);
		
		txtPostId = new JTextField(comments.getPostID());
		txtPostId.setBounds(66, 38, 83, 20);
		add(txtPostId);
		txtPostId.setColumns(10);

	}
}
