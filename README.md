# thecatapi

Desarrollado con

1. JAVA 17
2. Spring Boot 3.2.3

Para ejecutar la API

1. Clonar el repositorio
2. Desde la consola de comandos dirijase al directorio raiz del proyecto
3. Ejecute los siguientes comandos `$ ./mvnw clean package` `$ docker build -t thecatapi .` `$ docker run -p 8080:8080 thecatapi`

La aplicación se ejecuta en `localhost` por el puerto `8080`

GET /breeds :
`localhost:8080/api/v1/breeds`

GET /breeds/:breed_id :
`localhost:8080/api/v1/breeds/abys`

GET /breeds/search :
`localhost:8080/api/v1/breeds/search?q=colorpoint&attach_image=1`

NOTA: Tambien tiene la opción de ejecutar el archivo run.sh `$ sh run.sh` que ya ejecuta todos los comandos mencionados en el punto 3
