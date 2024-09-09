# User API SAMALUC Challenge

Este proyecto es una aplicaction springoboot desarrollado con java 17 como entorno de ejecución y con gradle como gestor de proyecto.

El contrato (api.yml) del proyecto se puede encontrar en resource de la carpeta main, para revisar respuestas y body request, body response.

## Ejecutar el proyecto
No hay variables de entorno ni argumentos de la maquina virtual.

Se puede hacer mediante las siguientes maneras:

1.- Para ejecutar importar a un IDE eclipse como Spring tool suite y ejecutarlo desde la herramientas boot dashboard.

2.- Hacer ./gradlew build y java -jar /users.jar.

### Crear un usuario
Se puede hacer mediante las siguientes maneras:

1.- usar la collection postman adjunta y ejecutar el endpoint create-user

2.- mediante el curl:

curl --location 'http://localhost:8080/create-user' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Juan Rodriguez",
    "email": "juanrodriguez.org",
    "password": "hunter2",
    "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "contrycode": "57"
        }
    ]
}'
