
package edu.cecar.conectarAPI;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

import javax.print.DocFlavor.INPUT_STREAM;

import edu.cecar.modelo.Albums;
import edu.cecar.modelo.Comments;
import edu.cecar.modelo.Photo;
import edu.cecar.modelo.Posts;
import edu.cecar.modelo.Usuario;
import us.monoid.json.JSONArray;
import us.monoid.json.JSONException;
import us.monoid.json.JSONObject;
import us.monoid.web.Resty;

public class ConectarAPI {


	private String accessToken = "4ZQvuWN6KMaf8lnh0hUmgNZjXYRqpl1j-jjj";

	static public HashMap<String,Usuario > usuarios = new HashMap<String, Usuario>();
	static public HashMap<String,Posts > posts = new HashMap<String, Posts>();
	static public HashMap<String,Comments > comment = new HashMap<String, Comments>();
	static public HashMap<String,Albums > albumns = new HashMap<String, Albums>();
	static public HashMap<String,Photo> photos = new HashMap<String, Photo>();





	public ConectarAPI() {
		try {
			cargarLista("users");
			
			cargarLista("posts");
			cargarLista("comments");
			cargarLista("albums");
			cargarLista("photos");
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public JSONObject getJSOnResourceCharacters(String opcion, int pagina) throws IOException, Exception {


		String url = String.format("https://gorest.co.in/public-api/"+opcion+"?page="+pagina+"?_format=json&access-token="+accessToken);
		return new Resty().json(url).object();

	}



	

	private void cargarLista(String datos) throws JSONException, IOException, Exception {


		JSONArray jSONCharacter= null;              

		int paginas= Integer.valueOf((getJSOnResourceCharacters(datos,0).getJSONObject("_meta").get("pageCount").toString()));

		for (int j = 1; j <= paginas; j++) {

			System.out.println(j+"-"+datos);
			if(j==87 && datos.equals("users")) accessToken="lIBfD2USCUu8C2cSGuiy_0mQuqNe6ugWfTbX";
			if(j==60 && datos.equals("posts")) accessToken="Y2uo3DziwXbIhPZfat3ujs--MNS__jNijMMS";
			
			
			jSONCharacter   = getJSOnResourceCharacters(datos,j).getJSONArray("result");

			int cantidad= jSONCharacter.length();


			for (int i = 0; i < cantidad; i++) {

				if("users".equals(datos)) {
					String id=jSONCharacter.getJSONObject(i).get("id").toString();
					String first_name= jSONCharacter.getJSONObject(i).get("first_name").toString();
					String last_name= jSONCharacter.getJSONObject(i).get("last_name").toString();
					String gender= jSONCharacter.getJSONObject(i).get("gender").toString();
					String dob= jSONCharacter.getJSONObject(i).get("dob").toString();
					String email= jSONCharacter.getJSONObject(i).get("email").toString();
					String phone= jSONCharacter.getJSONObject(i).get("phone").toString();
					String website= jSONCharacter.getJSONObject(i).get("website").toString();
					String address= jSONCharacter.getJSONObject(i).get("address").toString();
					String status= jSONCharacter.getJSONObject(i).get("status").toString();
					
					usuarios.put(id, new Usuario(id,first_name, last_name, gender, dob, email, phone, website, address, status));


				}else if("posts".equals(datos)) {

					String id= jSONCharacter.getJSONObject(i).get("id").toString();
					String userId= jSONCharacter.getJSONObject(i).get("user_id").toString();
					String title= jSONCharacter.getJSONObject(i).get("title").toString();
					String body= jSONCharacter.getJSONObject(i).get("body").toString();

					posts.put(id, new Posts(id, userId, title, body));	

				}else if("comments".equals(datos)) {

					
					
					String id= jSONCharacter.getJSONObject(i).get("id").toString();
					String postID= jSONCharacter.getJSONObject(i).get("post_id").toString();
					String name= jSONCharacter.getJSONObject(i).get("name").toString();
					String email= jSONCharacter.getJSONObject(i).get("email").toString();
					String body= jSONCharacter.getJSONObject(i).get("body").toString();					
					
					comment.put(id, new Comments(id, postID, name, email, body));
					
					
				}else if("albums".equals(datos)) {
					
					
					String id= jSONCharacter.getJSONObject(i).get("id").toString();
					String userID= jSONCharacter.getJSONObject(i).get("user_id").toString();
					String title= jSONCharacter.getJSONObject(i).get("title").toString();				
					
					albumns.put(id, new Albums(id, userID, title));
					
					
					
				}else if("photos".equals(datos)) {
					
				
					
					String id= jSONCharacter.getJSONObject(i).get("id").toString();
					String albumID= jSONCharacter.getJSONObject(i).get("album_id").toString();
					String title= jSONCharacter.getJSONObject(i).get("title").toString();
					String photoUrl= jSONCharacter.getJSONObject(i).get("url").toString();
					String photoThumbnailUrl= jSONCharacter.getJSONObject(i).get("thumbnail").toString();
					System.out.println(photoUrl);
					
				//	descargarPhoto("Photo_Url/"+id,new URL(photoUrl));
					//descargarPhoto("Photo_Thumbnail_Url/"+id,new URL(photoThumbnailUrl));
					
					photos.put(id, new Photo(id, albumID, title, photoUrl, photoThumbnailUrl));
					
				}
			}  

		}

	}
	
	
	private void descargarPhoto(String id, URL url) throws IOException {
		
		URLConnection urlCon = url.openConnection();
		InputStream is = urlCon.getInputStream();
		FileOutputStream fos = new FileOutputStream("imagen/"+id+".jpg");
		byte[] array = new byte[1000];
		int leido = is.read(array);
		while (leido > 0) {
			fos.write(array, 0, leido);
			leido = is.read(array);
		}
		
		is.close();
		fos.close();
		
		
	}


}
