#define base docker image
FROM openjdk:11
LABEL maintainer="sameer"
ADD target/spring-boot-app.jar spring-boot-app.jar
ENTRYPOINT ["java","-jar","spring-boot-app.jar"]