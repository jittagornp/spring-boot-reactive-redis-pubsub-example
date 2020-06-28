FROM openjdk:11-jre-slim
EXPOSE 8081
ADD target/*.jar /app.jar
ENTRYPOINT java $JAVA_OPTS -jar /app.jar