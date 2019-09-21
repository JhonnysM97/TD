package edu.cecar.modelo;

public class Photo {

	
	String id, albumID, photoUrl,title, 	photoThumbnailUrl;

	public Photo(String id, String albumID,String title, String photoUrl, String photoThumbnailUrl) {
		super();
		this.id = id;
		this.albumID = albumID;	
		this.photoUrl = photoUrl;
		this.title=title;
		this.photoThumbnailUrl = photoThumbnailUrl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAlbumID() {
		return albumID;
	}

	public void setAlbumID(String albumID) {
		this.albumID = albumID;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getPhotoThumbnailUrl() {
		return photoThumbnailUrl;
	}

	public void setPhotoThumbnailUrl(String photoThumbnailUrl) {
		this.photoThumbnailUrl = photoThumbnailUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	
}
