
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/* Las clases DAO son las encargadas de hacer la conexion con la BD
*/
public class MensajesDAO {
    
    public static void crearMensajeDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        
        //Con el metodo try nos conectamos a la BD
        try( Connection conexion = db_connect.get_connection() ){
            //Objeto de Sentencia Preparada
            PreparedStatement ps = null;
            
            //try para insertar los datos en la BD
            try{
                //Creamos la consulta para insertar los datos
                //A ps le pasamos la sentencia SQL para insertar los datos
                String query = "INSERT INTO mensajes (mensaje, autor_mensaje) VALUES (?,?)";
                ps = conexion.prepareStatement(query);
                //El mensaje consta de cuatro atributos, pero solo pasamos dos, ya 
                //que los otros dos son automaticos por la BD (id y fecha)
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                //Ejecuta la sentencia a la BD
                ps.executeUpdate();
                System.out.println("Mensaje creado");
                
            } catch(SQLException ex){ //En caso de no crear el mensaje
                System.out.println("ex");
            }
        } catch(SQLException e){ //Por si alguna razon no nos conectamos a la BD
            System.out.println(e);
        } 
            
    }
    
    
    public static void leerMensajeDB(){
        
    }
    
    
    public static void borrarMensajeDB(int id_mensaje){
        
    }
    
    
    public static void actualizarMensajeDB(Mensajes mensaje){
        
    }
    
}
