# Springboot-docker
Docker springboot mysql application

Copy the docker-compose.yml and Run docker-compose up -d command run application.
1. GET Endpoint to fetch all users => http://localhost:8081/api/users
2. POST Endpoint to create new users => http://localhost:8081/api/users
   Sample Payload
{
    "name": "John Doe 4",
    "email": "johndoe4@example.com"
}
