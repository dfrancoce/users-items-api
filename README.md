# users-items-api
This project contains the API to get items associated with the username passed in the url of the main endpoint

## Getting started

These instructions will get you a copy of the project up and running on a local machine for testing purposes.

### Prerequisites

This is a Spring Boot project which is built using maven. Also docker is required to launch an instance of mysql.

### Starting the docker container for mysql

In the root directory of this project, there is a Dockerfile we will use to build the container for our mysql database. Follow the next instructions

In the root directory execute:

```
docker build -t task1-mysql .
```

And

```
docker run -d -p 3306:3306 --name task1-mysql -e MYSQL_ROOT_PASSWORD=testdevws task1-mysql
```

### Starting the app

To compile the app execute the following command in the root directory:
```
mvn clean package
```
To run the app execute:
```
java -jar target/users-items-api-0.0.1-SNAPSHOT.jar
```
Once everything is up and running, you can consult the enpoints at
```
localhost:8080/swagger-ui.html
```
