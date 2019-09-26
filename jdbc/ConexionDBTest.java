import java.util.Scanner;

public class ConexionDBTest {
	
	public static void main(String[] args) {

		//Datos de la BD y usuario
		String database = "jdbc:mysql://localhost:3306/Prebes39";
    	String username = "root";
    	String password = "";

    	Scanner leer = new Scanner(System.in);
    	int opcion;
    	int num_prebe;
    	String nombre;
    	int edad;

		ConexionDB conexion = new ConexionDB(database,username,password);
	    conexion.conectarBD();

	    System.out.println("Selecciona una opción: ");
	    System.out.println("1. Crear registro");
	    System.out.println("2. Leer registro");
	    System.out.println("3. Actualizar registro");
	    System.out.println("4. Borrar registro");
	    System.out.println("5. Leer todo");

	    opcion = Integer.parseInt(leer.nextLine());
	    
	    switch (opcion) {
	    	case 1:
	    		System.out.print("Ingresa el num. prebe: ");
	    		num_prebe = Integer.parseInt(leer.nextLine());
				System.out.print("Ingresa el nombre: ");
	    		nombre = leer.nextLine();
	    		System.out.print("Ingresa la edad: ");
	    		edad = Integer.parseInt(leer.nextLine());
	    		conexion.create(num_prebe,nombre,edad);
	    		break;
	    	case 2:
	    		System.out.print("Ingresa el num. prebe a consultar: ");
	    		num_prebe = Integer.parseInt(leer.nextLine());
				conexion.read(num_prebe);
	    		break;
	    	case 3:
	    		System.out.print("Ingresa el num. prebe a modificar: ");
	    		num_prebe = Integer.parseInt(leer.nextLine());
				System.out.print("Ingresa el nombre: ");
	    		nombre = leer.nextLine();
	    		System.out.print("Ingresa la edad: ");
	    		edad = Integer.parseInt(leer.nextLine());
	    		conexion.update(num_prebe,nombre,edad);
	    		break;
	    	case 4:
	    		System.out.print("Ingresa el num. prebe a eliminar: ");
	    		num_prebe = Integer.parseInt(leer.nextLine());
				conexion.delete(num_prebe);
	    		break;
	    	case 5:
				conexion.read();
	    		break;
	    }
	    conexion.cerrarConexion();
    }
}

