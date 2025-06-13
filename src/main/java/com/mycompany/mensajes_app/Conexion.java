package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//
public class Conexion {

    //Metodo para conectarnos a la BD    
    public Connection get_connection(){
        //Definimos un objeto de tipo connection como nulo
        Connection connection = null;
        
        //Hacemos la conexion
        try{
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/mensajes_app","root","");         
        } catch(SQLException e){
            //En caso de que no se haga la conexion mostramos el mensaje que manda la excepcion
            System.out.println(e); 
        }
        return connection;
    }
    

    
}
