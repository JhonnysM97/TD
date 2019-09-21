package edu.cecar.vista;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import edu.cecar.modelo.Photo;

public class PlantillaPhoto extends JPanel {
	private JTextField txtId;
	private JTextField txtAlbumId;


	public PlantillaPhoto(int x, int y, Photo photo) {
		setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		setBackground(Color.WHITE);
		setBounds(x, y, 1000, 150);
		setLayout(null);
		
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(10, 11, 46, 14);
		add(lblId);
		
		JLabel lblPostid = new JLabel("albunId");
		lblPostid.setBounds(82, 11, 46, 14);
		add(lblPostid);
		
		JLabel lblName = new JLabel("Title");
		lblName.setBounds(201, 11, 46, 14);
		add(lblName);
		
		JLabel lblNewLabel = new JLabel("Photo Thumbnail Url");
		lblNewLabel.setBounds(707, 11, 158, 14);
		add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Photo Url");
		lblEmail.setBounds(423, 11, 105, 14);
		add(lblEmail);
		
		JTextArea txtTitle = new JTextArea(photo.getTitle());
		txtTitle.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtTitle.setBounds(159, 36, 153, 42);
		add(txtTitle);
		
		txtId = new JTextField(photo.getId());
		txtId.setBounds(10, 38, 46, 20);
		add(txtId);
		txtId.setColumns(10);
		
		txtAlbumId = new JTextField(photo.getAlbumID());
		txtAlbumId.setBounds(66, 38, 83, 20);
		add(txtAlbumId);
		txtAlbumId.setColumns(10);
		
		JLabel lbImage1 = new JLabel("");
		Image img= new ImageIcon("imagen/Photo_Url/"+photo.getId()+".jpg").getImage();
		ImageIcon img2=new ImageIcon(img.getScaledInstance(158, 98, Image.SCALE_SMOOTH));
		
		lbImage1.setIcon(img2);
		lbImage1.setBounds(385, 41, 158, 98);
		add(lbImage1);
		
		JLabel lbImage2 = new JLabel("");
		lbImage2.setBounds(712, 36, 153, 103);
		Image img1= new ImageIcon("imagen/Photo_Thumbnail_Url/"+photo.getId()+".jpg").getImage();
		ImageIcon img3=new ImageIcon(img1.getScaledInstance(158, 98, Image.SCALE_SMOOTH));
		lbImage2.setIcon(img3);
		add(lbImage2);

	}
}
