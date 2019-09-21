package edu.cecar.vista;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.cecar.conectarAPI.ConectarAPI;
import logica.Buscar;

public class ImprimirResultado extends JDialog {

	private final JPanel contentPanel = new JPanel();

	
	public ImprimirResultado(String tipo) {
		setTitle("Resultados");
		setBounds(100, 100, 1051, 755);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			JPanel panel = new JPanel();
			panel.setBounds(10, 5, 1015, 700);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lbTipo = new JLabel(tipo);
				lbTipo.setBounds(331, 11, 300, 65);
				panel.add(lbTipo);
				lbTipo.setFont(new Font("Tahoma", Font.BOLD, 44));
			}
		
		if(tipo.equals("Posts")) {
			int aux=70;
			
			for (String idPosts  : Buscar.idPosts) {
				
				
				panel.add(new PlantillaPost(1,aux,ConectarAPI.posts.get(idPosts)));
				aux+=160;
				
			}
			
		}else 	if(tipo.equals("Comments")) {
			int aux=70;
			
			for (String idCome  : Buscar.idComments) {
				
				
				panel.add(new PlantillaComments(1,aux,ConectarAPI.comment.get(idCome)));
				aux+=160;
				
			}
			
		}else if(tipo.equals("Albums")) {
			int aux=70;
			
			for (String idAlbums  : Buscar.idAlbums) {
				
				
				panel.add(new PlantillaAlbums(1,aux,ConectarAPI.albumns.get(idAlbums)));
				aux+=160;
				
			}
			
		} else if(tipo.equals("Photos")) {
			int aux=70;
			
			for (String idPhotos  : Buscar.idPhotos) {
				
				
				panel.add(new PlantillaPhoto(1,aux,ConectarAPI.photos.get(idPhotos)));
				aux+=160;
				
			}
			
		} 
	
		
	
		
	}
}
