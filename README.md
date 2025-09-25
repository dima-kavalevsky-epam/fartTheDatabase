# User Card Service Application
## This is a Spring Boot application that manages users and their card information.

### Prerequisites
- Java 17 or later
  ```sh WSL
  sudo apt update
  sudo apt install openjdk-17-jdk
  java -version
  echo 'JAVA_HOME="/usr/lib/jvm/java-17-openjdk-amd64"' | sudo tee /etc/profile.d/java-home.sh
  echo 'export JAVA_HOME' | sudo tee -a /etc/profile.d/java-home.sh
  echo 'export PATH=$PATH:$JAVA_HOME/bin' | sudo tee -a /etc/profile.d/java-home.sh
  source /etc/profile.d/java-home.sh
  echo $JAVA_HOME
  ```
- Maven 3.6 or later
  ```sh WSL
  sudo apt update
  export M2_HOME=/opt/maven /etc/profile.d/maven.sh
  export MAVEN_HOME=/opt/maven /etc/profile.d/maven.sh
  export PATH=$PATH:$M2_HOME/bin /etc/profile.d/maven.sh
  ```
- Docker and Docker Compose (to run PostgreSQL and Redis)
  ```sh WSL
  sudo apt-get update
  sudo apt-get install docker-compose-plugin
  ```

### Setup
Start PostgreSQL and Redis using Docker:
Create a docker-compose.yml file with the following content:

```yaml
version: '3.8'
services:
  postgres:
    image: postgres:14.5
    container_name: postgres_db
    environment:
      POSTGRES_DB: usercarddb
      POSTGRES_USER: user
      POSTGRES_PASSWORD: password
    ports:
      - "5432:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data
  redis:
    image: redis:6.2-alpine
    container_name: redis_cache
    ports:
      - "6379:6379"
    volumes:
      - redis_data:/data
volumes:
    postgres_data:
    redis_data:
```

Then run the command:

```sh WSL
sudo su
## Start as daemon
docker-compose up -d
## See current status
docker-compose ps -a
## Stop
docker-compose down -v
```

### Configure application.properties:
Ensure the database and Redis connection details in src/main/resources/application.properties match your setup. The provided file is configured to work with the docker-compose.yml setup.

### Build the Application
To build the application from the command line, navigate to the root directory of the project (where the pom.xml is located) and run the following Maven command:

```sh
mvn clean install
# or
mvn clean install -DskipTests
```

This command will compile the source code, run the tests, and package the application into a JAR file in the target/ directory.

Run the Application
Once the build is successful, you can run the application using:

```sh
java -jar target/user-card-app-0.0.1-SNAPSHOT.jar
```

The application will start on the default port 8080.

### API Endpoints
You can interact with the REST API using tools like curl or Postman.

Users: /api/users
Cards: /api/users/{userId}/cards

```sh
curl -X GET http://localhost:8080/api/users
```