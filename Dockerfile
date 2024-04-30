# Stage 1: Build Stage
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY . /app
RUN mvn clean install -U -Dmaven.test.failure.ignore=true

# Stage 2: Run Stage
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/netflix-gpt-0.0.1-SNAPSHOT.jar /app/netflix-gpt-0.0.1-SNAPSHOT.jar
EXPOSE 8000
CMD ["java", "-jar", "netflix-gpt-0.0.1-SNAPSHOT.jar"]
