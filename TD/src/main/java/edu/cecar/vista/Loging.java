package edu.cecar.vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import edu.cecar.componentes.baseDatos.ConectarMySQL;

public class Loging extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	String name;


	public Loging() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 210, 199);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(10, 28, 46, 14);
		contentPanel.add(lblId);
		
		JLabel lblPassword = new JLabel("passWord:");
		lblPassword.setBounds(10, 70, 73, 14);
		contentPanel.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(97, 25, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(97, 67, 86, 17);
		contentPanel.add(passwordField);
		
		JButton btnAcceder = new JButton("Acceder");
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			try {
				
			PreparedStatement 	pst = ConectarMySQL.getConexion().prepareStatement("SELECT name FROM bdgorest.usersystem where id= ? and password= ?");
				
				pst.setString(1, textField.getText());
				pst.setString(2, String.valueOf(passwordField.getPassword()));
				
				
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				name= rs.getString(1);
			}
			rs.close();
			pst.close();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			setVisible(false);
			
			}
		});
		btnAcceder.setBounds(45, 122, 89, 23);
		contentPanel.add(btnAcceder);
	}
	
	public String[] getUSer() {
	
		String[] resultado = {textField.getText(),name};
		return resultado;

	}
}
