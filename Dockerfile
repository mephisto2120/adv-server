FROM openjdk:11-jre-slim

COPY target/adv-server.jar /app.jar
CMD java ${JAVA_OPTS} -Dspring.profiles.active=${ACTIVE_PROFILES} -jar /app.jar
