/*Crear nuevo proyecto: File, New Project, Java with Maven, damos nombre
- Creamos la clase principal Main
- Agregamos una dependencia: Clic en derecho en carpeta Dependencies, Add Dependency...
 tecleamos "mysql-connector-java"y clic en Add
 */
import com.mycompany.mensajes_app.Conexion;
import com.mycompany.mensajes_app.mensajesService;
import java.sql.Connection;
import java.util.Scanner;


public class Inicio {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int opcion = 0;
        
        do{
            System.out.println("\n-----------------------");
            System.out.println("Aplicacion de mensajes");
            System.out.println("1. Crear mensaje");
            System.out.println("2. Listar mensajes");
            System.out.println("3. Editar mensaje");
            System.out.println("4. Eliminar mensaje");
            System.out.println("5. Salir\n");
            //Leemos opcion del usuario
            opcion = sc.nextInt();
            
            switch (opcion){
                case 1:
                    mensajesService.crearMensaje();
                    break;
                case 2:
                    mensajesService.listarMensajes();
                    break;
                case 3:
                    mensajesService.editarMensaje();
                    break;
                case 4:
                    mensajesService.borrarMensaje();
                    break;
                default:
                    break;
            }
            
        } while(opcion != 5);
    }
    
}
