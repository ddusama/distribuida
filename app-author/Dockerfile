FROM eclipse-temurin:17.0.5_8-jre-alpine

RUN mkdir /app
WORKDIR /app

ARG NAME_APP=app-authors

COPY build/quarkus-app/ .


CMD ["java", "-jar", "quarkus-run.jar"]

