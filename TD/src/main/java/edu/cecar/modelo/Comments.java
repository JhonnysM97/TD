package edu.cecar.modelo;

public class Comments {
	
	String id, postID,name, email, body;

	public Comments(String id, String postID, String name, String email, String body) {
		super();
		this.id = id;
		this.postID = postID;
		this.name = name;
		this.email = email;
		this.body = body;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPostID() {
		return postID;
	}

	public void setPostID(String postID) {
		this.postID = postID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	
	
	

}
