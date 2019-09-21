package edu.cecar.vista;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Carga extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnOk;


	public Carga() {
		setUndecorated(true);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 200, 200);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblCargandoDatos = new JLabel("Cargando...");
		lblCargandoDatos.setForeground(Color.GREEN);
		lblCargandoDatos.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCargandoDatos.setBackground(Color.GREEN);
		lblCargandoDatos.setBounds(37, 84, 122, 32);
		contentPanel.add(lblCargandoDatos);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnOk.setBounds(47, 141, 89, 23);
		btnOk.setVisible(false);
		
				
		
	}
	
	public void activar() {
		btnOk.setVisible(true);
		contentPanel.add(btnOk);
		repaint();
		
	}
	
}
