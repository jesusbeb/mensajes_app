
package com.mycompany.mensajes_app;

import java.util.Scanner;

/* Las clases service son las encargadas de trabajar con los datos ingresados por 
el usuario
*/
public class mensajesService {
    
    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Escribe tu mensaje: ");
        String mensaje = sc.nextLine();     
        System.out.println("Escribe tu nombre: ");
        String nombre = sc.nextLine();
        
        //Creamos el objeto mensaje
        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        //Enviamos el objeto mensaje a la capa DAO
        MensajesDAO.crearMensajeDB(registro);
    }
    
    
    public static void listarMensajes(){
        MensajesDAO.leerMensajeDB();
    }
    
    
    public static void borrarMensaje(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Indica el ID del mensaje a borrar: ");
        int id_mensaje = sc.nextInt();
        MensajesDAO.borrarMensajeDB(id_mensaje);
    }
    
    
    public static void editarMensaje(){
        
    }
}
