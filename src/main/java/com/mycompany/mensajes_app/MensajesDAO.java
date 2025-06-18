
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
                System.out.println(ex);
            }
        } catch(SQLException e){ //Por si alguna razon no nos conectamos a la BD
            System.out.println(e);
        } 
            
    }
    
    
    public static void leerMensajeDB(){
        Conexion db_connect = new Conexion();
        PreparedStatement ps = null; //Prepara la sentencia
        ResultSet rs = null; //Trae los datos de la BD, en filas para procesarlos
        
         try( Connection conexion = db_connect.get_connection() ){
             String query = "SELECT * FROM mensajes";
             ps = conexion.prepareStatement(query);
             rs = ps.executeQuery(); //executeQuert Solo pide datos, no crea, actualiza o elimina
             
             //Mientras ResultSet tenga datos, imprimirlos
             while( rs.next() ){                 
                 System.out.println("ID: " +rs.getInt("id_mensaje")); //id_mensaje nombre del campo en la BD
                 System.out.println("Mensaje: " +rs.getString("mensaje")); //mensaje es el nombre del campo en la BD
                 System.out.println("Autor: " +rs.getString("autor_mensaje"));
                 System.out.println("Fecha: " +rs.getString("fecha_mensaje"));
                 System.out.println(""); //Salto de linea
             }
             
         } catch(SQLException e){
                System.out.println("No se pudieron recuperar los mensajes");
                System.out.println(e);
         }
    }
    
    
    public static void borrarMensajeDB(int id_mensaje){
        Conexion db_connect = new Conexion();
        
        try( Connection conexion = db_connect.get_connection() ) {
            PreparedStatement ps = null;
            try{
                String query = "DELETE from mensajes WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, id_mensaje);
                ps.executeUpdate();
                System.out.println("El mensaje ha sido borrado");                      
            } catch(SQLException ex){
                System.out.println(ex);   
                System.out.println("No se pudo borrar el mensaje");
            }
        } catch(SQLException e){
            System.out.println(e);
            System.out.println("No fue posible conectarse a la BD");
        }
    }
    
    
    public static void actualizarMensajeDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        
        try(Connection conexion = db_connect.get_connection()){
            PreparedStatement ps = null;
            
            try{
                String query = "UPDATE mensajes SET mensaje = ? "
                        + "WHERE id_mensaje = ? ";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getId_mensaje());
                ps.executeUpdate();
                System.out.println("El mensaje se actualizo con exito");
            } catch(SQLException ex){
                System.out.println(ex);
                System.out.println("No se pudo actualizar el mensaje");
            }
        } catch(SQLException e){
            System.out.println(e);
        }
    }
    
}
