# Сборка
FROM maven:3.9-eclipse-temurin-21 AS builder

WORKDIR /temperature-service
COPY pom.xml .
RUN mvn dependency:go-offline #Кэширует в образ чтоб не перезагружать зависимости
COPY src ./src
RUN mvn package -DskipTests
#Запуск берем образ полегче
FROM eclipse-temurin:21-jre

WORKDIR /temperature-service
COPY --from=builder /temperature-service/target/temperature-service-0.0.1-SNAPSHOT.jar app.jar

RUN ls /temperature-service

# Запуск
CMD ["java", "-jar", "app.jar"]