package logica;

import javax.swing.table.DefaultTableModel;

import edu.cecar.conectarAPI.ConectarAPI;
import edu.cecar.modelo.Usuario;

public class ListarTodo {

	
	
	
	public static void listar(DefaultTableModel model) {	

		
		
		for (Usuario user : ConectarAPI.usuarios.values()) {
			
			String id= user.getId();
			String first_name= user.getFirst_name();
			String last_name = user.getLast_name();
			String gender= user.getGender();
			String dob= user.getDob();
			String email= user.getEmail();
			String phone = user.getPhone();
			String website= user.getWebsite();
			String address= user.getAddress();
			String status= user.getStatus();
			
			String[] datos= {first_name,last_name,gender,dob,email,phone,website,address,status};
			
			model.addRow(datos);
			
			
		}
		
		
	}
}
