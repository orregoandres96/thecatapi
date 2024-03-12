# thecatapi

Para ejecutar la API

1. Clonar el repositorio
2. Desde la consola de comandos dirijase al directorio raiz del proyecto
3. Ejecute los siguientes comandos `$ ./mvnw clean package` `$ docker build -t thecatapi .` `$ docker run -p 8080:8080 thecatapi`

NOTA: Tambien tiene la opción de ejecutar el archivo run.sh `$ sh run.sh` que ya ejecuta todos los comandos mencionados en el punto 3
