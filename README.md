## Product CRUD w/ Java and Spring Boot

This project was planned to be a simple CRUD with Bearer token authentication

---

### In order to run the project

- Clone this repository
  ```
  https://github.com/FelipeRodrigues05/product-crud.git
  ```
- Install dependencies in CMD or via IntelliJ IDEA
  ```
   mvn clean install
  ```
- Copy the .env.example to env.properties
- Configure your favorite database in my case I'm using MySQL
- Run the project in CMD or via IntelliJ IDEA
  ```
  mvn springboot:run
  ```
- Open Insomnia or Postman
- Go to `http://localhost:8080/auth/register` to create your user and get the token
- In every request you need this token to make all other requests

--- 

## Making Requests

In order to make requests you need the token, that have been created in `/auth/register` route, this token is valid for 2 hours

### To make your first request
- With your new token you need to pass it as Authorization in the Auth tab on Insomnia
  ![image](https://github.com/FelipeRodrigues05/product-crud/assets/84999106/7fab0e53-a17f-4c85-ba40-1a56b803721e)
- In this tab you need to select `Bearer Token` and insert the token like this
  ![image](https://github.com/FelipeRodrigues05/product-crud/assets/84999106/7d0e9d45-aee8-4e53-869e-ab7a9fa82a79)
- Now you are ready to make requests, example below
  ![image](https://github.com/FelipeRodrigues05/product-crud/assets/84999106/b7962734-4117-4165-8e3c-e1aa2e4164d2)

---

## Some improvements I want to make
- Containerize this application
