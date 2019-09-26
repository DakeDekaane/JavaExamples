//Estructura de la tabla
// prebe_id
// nombre
// edad



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Driver;
import java.sql.Statement;
import java.sql.ResultSet;

public class ConexionDB {

	//Atributos necesarios para la conexión
	private String database;	//URL de la BD
	private String username;	//Usuario de la BD
	private String password;	//Contraseña de la BD
	Connection myConnection;	//Objeto que realiza la conexión con la BD

	//Constructor
    public ConexionDB(String database, String username, String password){
		this.database = database;
		this.username = username;
		this.password = password;
    }

    //Realiza la conexión con la BD
    public void conectarBD() {
		try {
    		myConnection = DriverManager.getConnection(database,username,password);
    		System.out.println("Conexion exitosa a la base de datos");
	    	
    	}
    	catch(SQLException e) {
    		System.out.println("Hubo un error al conectarse a la base de datos");
    	}
	}

	//Cierra conexión con la BD
    public void cerrarConexion(){
    	try{
            myConnection.close();
            System.out.println("Se ha cerrado la conexión");
        }
        catch(SQLException e){
            System.out.println("Hubo un error al cerrar la conexión");
        }
    }

    //Create
    // insert into <table> values (... <lista de valores>)
    // insert into <table> (col1,col2,col3) vaues (value1,value2,value3)
    public void create(int id, String nombre, int edad){
    	try {
    		//Se crea la sentencia SQL
    		String sentencia = "insert into Prebes values("
    			+ id + ","
    			+ "\"" + nombre + "\","
    			+ edad + ")";
    		//System.out.println(sentencia);

    		//Se crea un objeto Statement que recibe sentencias
    		Statement st = myConnection.createStatement();

    		
    		st.executeUpdate(sentencia);
    	}
    	catch(SQLException e){
    		System.out.println("Hubo un error al crear registro");
    	}
    }

    // Retrieve/Read
    // select <rows> from <table> where <condiciones>
    public void read() {
    	try {
    		//Se crea la sentencia SQL para la consulta
    	   	String consulta = "select * from Prebes";

    	   	//Se crea un objeto Statement que recibe sentencias
    	   	Statement myStatement = myConnection.createStatement();

    	   	//Se ejecuta la instrucción SQL (para consultar->executeQuery)
	    	ResultSet myResultSet = myStatement.executeQuery(query);

	    	//ResultSet es un conjunto con los renglones de la consulta,
	    	//por lo que se iteran todos los valores
	    	while(myResultSet.next()){
	    		System.out.println("Num. prebe: " + myResultSet.getString("prebe_id"));
	    		System.out.println("Nombre: " + myResultSet.getString("nombre"));
	    		System.out.println("Edad: " + myResultSet.getString("edad"));
	    	}	
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
	}


	public void read(int id) {
    	try {
    	   	//Se crea la sentencia SQL para la consulta
    	   	String query = "select * from Prebes where prebe_id = " + id;
			
			//Se crea un objeto Statement que recibe sentencias
    	   	Statement myStatement = myConnection.createStatement();

    	   	//Se ejecuta la instrucción SQL (para consultar->executeQuery)
	    	ResultSet myResultSet = myStatement.executeQuery(query);

	    	//Se itera sobre el conjunto de resultados
	    	while(myResultSet.next()){
	    		System.out.println("Num. prebe: " + myResultSet.getString("prebe_id"));
	    		System.out.println("Nombre: " + myResultSet.getString("nombre"));
	    		System.out.println("Edad: " + myResultSet.getString("edad"));
	    	}	
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
	}

	//Update
	// update <table> set <attr1> = <value1> ... where <condiciones>
	public void update(int id, String nombre, int edad){
    	try {
    		//Se crea la sentencia SQL para la consulta
    		String sentencia = "update Prebes set "
    			+ "nombre = \"" + nombre + "\", "
    			+ "edad = " + edad + " "
    			+ " where prebe_id = " + id;
    		//System.out.println(sentencia);

    		//Se crea un objeto Statement que recibe sentencias
    		Statement st = myConnection.createStatement();
    		
    		//Se ejecuta la instrucción SQL (para actualizar->executeUpdate)
    		st.executeUpdate(sentencia);
    	}
    	catch(SQLException e){
    		System.out.println("Hubo un error al actualizar registro");
    	}
    }

    //Delete
    // delete from <table> where <condiciones>
    public void delete(int id){
    	try {
    		//Se crea la sentencia SQL para la consulta
    		String sentencia = "delete from Prebes where prebe_id = " + id;
    		//System.out.println(sentencia);

    		//Se crea un objeto Statement que recibe sentencias
    		Statement st = myConnection.createStatement();

    		//Se ejecuta la instrucción SQL (para borrar->executeUpdate)
    		st.executeUpdate(sentencia);
    	}
    	catch(SQLException e){
    		System.out.println("Hubo un error al borrar registro");
    	}
    } 
}