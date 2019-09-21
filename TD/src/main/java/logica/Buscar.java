package logica;

import java.util.ArrayList;

import edu.cecar.conectarAPI.ConectarAPI;
import edu.cecar.modelo.Albums;
import edu.cecar.modelo.Comments;
import edu.cecar.modelo.Photo;
import edu.cecar.modelo.Posts;

public class Buscar implements Runnable{

	static	String  idUser;
	String tipoBuscar ;
	
	public static ArrayList<String> idPosts = new ArrayList<String>();
	public static ArrayList<String> idComments = new ArrayList<String>();
	
	
	public static ArrayList<String> idAlbums = new ArrayList<String>();
	public static ArrayList<String> idPhotos = new ArrayList<String>();

	
	public Buscar(String idUser, String tipoBuscar) {
		super();
		Buscar.idUser = idUser;
		this.tipoBuscar= tipoBuscar;
	}




	private static void comments() {
		
	for (String idPost : idPosts) {
		for (Comments comment : ConectarAPI.comment.values()) {
			if(comment.getPostID().equals(idPost)) {
				idComments.add(comment.getId());
			}
		}
	}
	
	}
	
	
	
	
	private static void post() {		
		for (Posts posts : ConectarAPI.posts.values()) {
			if(posts.getUserId().equals(idUser)) {
				idPosts.add(posts.getId());
			}
		}
		
		
		 comments();

	}


	
	
	
	
	private static void albums() {
		
		for (Albums album : ConectarAPI.albumns.values()) {
			if(album.getUserID().equals(idUser)) {
				idAlbums.add(album.getId());
			}
		}
		
		photos();
	}
	
	
	
	
	
	private static void photos() {
		
	for (String idBums : idAlbums) {
		for (Photo photos : ConectarAPI.photos.values()) {
			if(photos.getAlbumID().equals(idBums)) {
				idPhotos.add(photos.getId());
			}
		}
	}
	
	}
	
	
	


	public synchronized void run() {
		if(tipoBuscar.equals("texto")) {
			idPosts.clear();
			idComments.clear();
			post();
			
			
			for (String string : idPosts) {
				System.out.println("id post: "+string);
			}
			for (String string : idComments) {
				System.out.println("id comment: "+string);
			}
		}else if(tipoBuscar.equals("multimedia")) {
			idAlbums.clear();
			idPhotos.clear();
			albums();
			
			
			for (String string : idAlbums) {
				System.out.println("id albums: "+string);
			}
			for (String string : idPhotos) {
				System.out.println("id photos: "+string);
			}
		}
		
	//	notifyAll();
		
	}
	


}
