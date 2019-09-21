package edu.cecar.conectarAPI;

public class SingletonConectarAPI {

	private SingletonConectarAPI() {}
	
	private static ConectarAPI api;
	
	public static ConectarAPI getConectarAPI() {
	 
		if(api ==null) api = new ConectarAPI();
		
		return api;
	}
	
	
}
