FROM gradle:8.4.0-jdk21 AS builder
WORKDIR /build

COPY build.gradle.kts settings.gradle.kts ./

RUN gradle --no-daemon dependencies || true

COPY src ./src

RUN gradle --no-daemon bootJar -x test

FROM gcr.io/distroless/java21-debian12
WORKDIR /app
COPY --from=builder /build/build/libs/*.jar app.jar
EXPOSE 8080
CMD ["-jar", "/app/app.jar"]
