FROM openjdk:11
ADD target/books-0.0.1-SNAPSHOT.jar books-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "books-0.0.1-SNAPSHOT.jar"]