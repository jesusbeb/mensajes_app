
package com.mycompany.mensajes_app;

public class Mensajes {
    int id_mensaje;
    private String mensaje;
    private String autor_mensaje;
    private String fecha_mensaje;
    
    //Constructor vacio
    public Mensajes(){
        
    }
    
    //Constructor con todos los atributos
    public Mensajes(String mensaje, String autor_mensaje, String fecha_mensaje){
        this.mensaje = mensaje;
        this.autor_mensaje = autor_mensaje;
        this.fecha_mensaje = fecha_mensaje;
    }
    
    
    //Getters & Setters

    public int getId_mensaje() {
        return id_mensaje;
    }

    public void setId_mensaje(int id_mensaje) {
        this.id_mensaje = id_mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAutor_mensaje() {
        return autor_mensaje;
    }

    public void setAutor_mensaje(String autor_mensaje) {
        this.autor_mensaje = autor_mensaje;
    }

    public String getFecha_mensaje() {
        return fecha_mensaje;
    }

    public void setFecha_mensaje(String fecha_mensaje) {
        this.fecha_mensaje = fecha_mensaje;
    }
    
}
