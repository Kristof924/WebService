FROM maven:4.0.0-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --form=build /target/rm-0.0.1-SNAPSHOT.jar rm.jar
EXPOSE 8080
ENTRYPOINT("java", "jar", "rm.jar")
