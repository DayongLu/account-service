FROM openjdk:8-jdk-alpine
RUN mkdir as-config-server
RUN chmod 777 as-config-server
RUN adduser -S app
USER app

COPY ./target/account-service-0.0.1-SNAPSHOT.jar as-config-server/account-service.jar
WORKDIR as-config-server
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","account-service.jar"]