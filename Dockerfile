FROM maven:3.8.8-amazoncorretto-17 as build
WORKDIR /app
COPY . .
RUN mvn clean package -X -DskipTests

FROM openjdk:17-ea-10-jdk-slim
WORKDIR /app
COPY --from=build ./app/target/*.jar ./demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT java -jar demo-0.0.1-SNAPSHOT.jar