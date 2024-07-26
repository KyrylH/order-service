FROM maven:3.9.8-eclipse-temurin-21-jammy as builder

WORKDIR /app
COPY . .
RUN ["mvn", "clean", "install"]

CMD ["mvn", "spring-boot:run"]