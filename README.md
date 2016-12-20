# spring-boot-sample-logback-access-swagger

# build & run 
mvn clean install && java -Dspring.profiles.active=dev -jar target/spring-boot-sample-logback-access-swagger-0.0.2-SNAPSHOT.jar

# API documentation path
http://localhost:8080/swagger-ui.html

# curl commands
curl -i http://localhost:8080/api/v1/ping
