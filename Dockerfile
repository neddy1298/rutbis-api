FROM openjdk:23-jdk

COPY RutBisApi-0.0.1-SNAPSHOT.jar /app/application.jar

CMD ["java", "-jar", "/app/application.jar"]
