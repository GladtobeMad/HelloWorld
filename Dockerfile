# Dockerfile
FROM openjdk:8
ADD . /app
WORKDIR /app/src
RUN javac *.java
CMD ["java","Main"]
