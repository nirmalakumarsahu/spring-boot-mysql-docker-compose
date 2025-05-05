FROM eclipse-temurin:17-jdk

LABEL maintainer="nirmalakumarsahu.in"

WORKDIR /app

COPY target/spring-boot-mysql-docker-compose.jar app.jar

EXPOSE 9070

ENTRYPOINT ["java", "-jar", "app.jar"]