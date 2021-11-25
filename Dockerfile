# Define docker file
FROM openjdk:8-jdk-alpine
RUN apk update 
RUN apk add --no-cache maven
RUN apk add bash
WORKDIR /usr/src/app
ADD . /usr/src/app
# RUN mvn clean install
CMD ["java","-jar","-Dserver.port=${PORT}","/usr/src/app/target/hello-world-0.0.1-SNAPSHOT.jar"]
