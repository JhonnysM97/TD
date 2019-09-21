
package edu.cecar.componentes.baseDatos;


import java.sql.Connection;
import java.sql.DriverManager;



final public class ConectarMySQL {

	//** Declaracion de variables
	private static Connection conexion;





	public static void getConectarMySQL(String servidorNombre,String nombreBD,String usuario,String password) throws Exception{

		if (conexion == null) {

		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

			}catch  (Exception e) {

				System.out.println("Error"+e);
			}


			
			String url= "jdbc:mysql://" + servidorNombre + "/" + nombreBD + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; 

		
			conexion=DriverManager.getConnection(url,usuario,password);

			conexion.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);


		}

	}



	

	public static Connection getConexion() {

		return conexion;
	}



}


