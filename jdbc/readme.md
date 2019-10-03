# JDBC (Java DataBase Connectivity)

API de Java para acceder a una base de datos mediante sentencias SQL. El controlador depende del manejador utilizado, en este caso es MySQL

**Ventajas:**
- Procesamiento simple de SQL
- Rendimiento bueno con grandes cantidades de datos
- Bueno para aplicaciones pequeñas
- Fácil de aprender

**Desventajas:**
- No hay encapsulamiento (se puede ver la implementación de la base de datos)
- En aplicaciones grandes puede ser complejo
- Se necesita conocer el lenguaje de la base de datos.


## Descarga del controlador JDBC para MySQL
https://dev.mysql.com/downloads/connector/j/5.1.html

## Importar
Al descargar el comprimido, extraer **mysql-connector-java-5.1.48-bin.jar** en el directorio de trabajo

## Para compilar
`javac nombre-archivo.java`

## Para ejecutar
`java -cp .: nombre-archivo`

-cp <- define el classpath de las clases no pertenecientes a la API de Java

.:java -cp .:mysql-connector-java-5.1.48-bin.jar ConexionDBTest 

. <- directorio donde se encuentran nuestras clases creadas
: <- separador
mysql-connector-java-5.1.48-bin.jar <-- ruta del .jar del controlador