/*Crear nuevo proyecto: File, New Project, Java with Maven, damos nombre
- Creamos la clase principal Main
- Agregamos una dependencia: Clic en derecho en carpeta Dependencies, Add Dependency...
 tecleamos "mysql-connector-java"y clic en Add
 */
import com.mycompany.mensajes_app.Conexion;
import java.sql.Connection;


public class Inicio {
    public static void main(String[] args) {
        
        Conexion conexion = new Conexion();

        //Hacemos la conexion a la BD
        //En try creamos un objeto del tipo Connection para usar el metodo get_connection
        try(Connection cnx = conexion.get_connection()){
            
        } catch(Exception e){
            System.out.println(e);          
        }
    }
    
}
