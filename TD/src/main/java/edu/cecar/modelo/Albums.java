package edu.cecar.modelo;

public class Albums {
	
	
	String id, userID, title;

	public Albums(String id, String userID, String title) {
		super();
		this.id = id;
		this.userID = userID;
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	

}
