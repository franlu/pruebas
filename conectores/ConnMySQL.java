package conectores;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;

public class ConnMySQL {
	
	public static void main(String[] args) {
	    
	    System.out.println("Iniciando");
	    
	    // Creando la conexión
	    try {
	    	
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection(
	        				"jdbc:mysql://www.db4free.net:3306/tubalcain",
	        				"tubalcain_dam",
	        				"12345678"
	        				); 
	        
	        String sql = "CREATE TABLE IF NOT EXISTS USUARIO " +
	               "(id INTEGER not NULL, " +
	               " nombre VARCHAR(255), " + 
	               " apellido VARCHAR(255), " + 
	               " edad INTEGER, " + 
	               " PRIMARY KEY ( id ))"; 
	        
	        String query = "SELECT nombre, edad from USUARIO";
	        
	        Statement stmt = null;
	        try {
	            stmt = con.createStatement();
	            stmt.executeUpdate(sql);
	            ResultSet rs = stmt.executeQuery(query);
	            String nombre, edad;
	            while (rs.next()){
	                nombre = rs.getString("nombre");
	                edad = rs.getString("edad");
	                System.out.println("Usuario: " + nombre + " Edad: " + edad);
	            }
	        }
	        catch (SQLException e){
	            e.printStackTrace();
	        } finally {
	            stmt.close();
	            con.close();
	            System.out.println("Se ha cerrado la conexión");
	        }
	       
	    }
	    catch (ClassNotFoundException ex) {
	        ex.printStackTrace();
	    }
	    catch ( Exception e){
	        e.printStackTrace();
	    }
	}
	    
}
