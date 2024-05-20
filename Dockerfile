FROM maven:3.6.3-jdk-8 AS build

COPY src /app/src
COPY pom.xml /app

WORKDIR /app
RUN mvn clean install

FROM openjdk:8-jre-alpine

COPY --from=build /app/target/product-crud-0.0.1-SNAPSHOT.jar /app/product-crud.jar

WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar", "product-crud.jar"]
