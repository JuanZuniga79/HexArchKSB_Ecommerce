# Build Stage
FROM gradle:jdk21-corretto as builder
WORKDIR /app
COPY . .
RUN gradle build --no-daemon

# Runtime Stage
FROM amazoncorretto:21-alpine-jdk as runtime
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
