# JDBC (Java DataBase Controller)

El controlador depende del manejador utilizado, en este caso es MySQL

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