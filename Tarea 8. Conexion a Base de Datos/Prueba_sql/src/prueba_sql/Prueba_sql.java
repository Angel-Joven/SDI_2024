/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba_sql;

// Importamos completamente la libreria de "java.sql".
import java.sql.*;

/**
 *
 * @author Angel_Joven
 */
public class Prueba_sql {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Creamos nuestras variables en formato "String" para usarlas al
        // momento de conectarnos a nuestra base de datos.
        String host;
        String dbName;
        String dbUser;
        String dbPass;
        
        // Creamos un "try-catch"
        try {
            // Cargamos nuestro driver.
            // Gracias a este metodo estatico, 
            // se podra realizar la conexion a la base de datos.
            Class.forName("com.mysql.jdbc.Driver");
            
            // Definimos el valor de nuestras variables,
            // agregando la informacion necesaria.
            host = "jdbc:mysql://localhost:3306/";
            dbName = "veterinaria";
            dbUser = "root";
            //dbPass="123456";
            dbPass=""; // En el caso de XAMPP, por defecto no hay dbPass.
            
            // Establecemos la conexion en base a la informacion previamente ingresada.
            Connection db = DriverManager.getConnection(host+dbName,dbUser,dbPass);
            
            // Sirve para podernos comunicar con nuestra base de datos
            // con ayuda de sentencias SQL.
            Statement st = db.createStatement();
            
            // Representa el resultado de la ejecucion de una sentencia.
            ResultSet rs = st.executeQuery("SELECT * FROM mascota");
            
            // Si no hay registros en la sentencia ejecutada,
            // imprime "Nada".
            if(rs.wasNull())
                System.out.println("NADA\n");
            
            // Lee todos los registros de nuestra consulta y las
            // imprime en base a los nombres de los campos que queramos.
            while(rs.next())
                System.out.println(rs.getString("id_mascota")+" "+rs.getString("nombre_mascota")+" ");
            
            // Cerramos la conexion de nuestra base de datos y de las consultas.
            rs.close();
                st.close();
                db.close();
                
          // Aca nos imprime los errores que se generen
          // al momento de conectar a nuestra base de datos
          // o de algun dato erroneo en nuestras consultas.
        } catch(Exception e){
            System.out.println("Error de conexion!\n"+e);
        }
        
    }
    
}
