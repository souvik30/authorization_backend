FROM openjdk:8
EXPOSE 8084
ADD target/authorization-service-0.0.1-SNAPSHOT.jar auth.jar
ENTRYPOINT ["java","-jar", "/auth.jar"]