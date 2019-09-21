package logica;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.cecar.componentes.baseDatos.ConectarMySQL;
import edu.cecar.conectarAPI.ConectarAPI;
import edu.cecar.modelo.Albums;
import edu.cecar.modelo.Comments;
import edu.cecar.modelo.Photo;
import edu.cecar.modelo.Posts;
import edu.cecar.modelo.Usuario;

public class Migrar {



	public static void iniciar() {



		try {



			for (Usuario ususario : ConectarAPI.usuarios.values()) {

				PreparedStatement pst = ConectarMySQL.getConexion().prepareStatement("insert into users value(?,?,?,?,?,?,?)");				
				pst.setString(1, ususario.getId());
				pst.setString(2, ususario.getFirst_name());
				pst.setString(3, ususario.getLast_name());
				pst.setString(4, ususario.getGender());
				pst.setString(5, ususario.getEmail());
				pst.setString(6, ususario.getPhone());
				pst.setString(7, ususario.getStatus());		
				pst.execute();

			}

			for (Posts posts : ConectarAPI.posts.values()) {

				PreparedStatement pst = ConectarMySQL.getConexion().prepareStatement("insert into Posts value(?,?,?,?)");				
				pst.setString(1, posts.getId());
				pst.setString(2, posts.getUserId());
				pst.setString(3, posts.getTitle());
				pst.setString(4, posts.getBody());				
				pst.execute();

			}


			for (Comments comment : ConectarAPI.comment.values()) {

				PreparedStatement pst = ConectarMySQL.getConexion().prepareStatement("insert into Comments value(?,?,?,?,?)");				
				pst.setString(1, comment.getId());
				pst.setString(2, comment.getPostID());
				pst.setString(3, comment.getName());
				pst.setString(4, comment.getEmail());
				pst.setString(5, comment.getBody());					
				pst.execute();

			}




			for (Albums albumn : ConectarAPI.albumns.values()) {

				PreparedStatement pst = ConectarMySQL.getConexion().prepareStatement("insert Albums users value(?,?,?)");				
				pst.setString(1, albumn.getId());
				pst.setString(2, albumn.getUserID());
				pst.setString(3, albumn.getTitle());		
				pst.execute();

			}
			
			

			for (Photo photos : ConectarAPI.photos.values()) {

				PreparedStatement pst = ConectarMySQL.getConexion().prepareStatement("insert Photos users value(?,?,?,?,?)");				
				pst.setString(1, photos.getId());
				pst.setString(2, photos.getTitle());
				pst.setString(3, photos.getPhotoUrl());
				pst.setString(4, photos.getPhotoThumbnailUrl());
				pst.setString(5, photos.getAlbumID());
				
				pst.execute();

			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}





	}

}
