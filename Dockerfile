FROM openjdk:21-jdk-slim

COPY build/libs/RutBisApi-0.0.1-SNAPSHOT.jar /app/application.jar

CMD ["java", "-jar", "/app/application.jar"]