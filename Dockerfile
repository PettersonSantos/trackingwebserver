FROM openjdk:17-jdk-alpine
ADD target/webserver-0.0.1-SNAPSHOT.jar webserver.jar
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /webserver.jar"]