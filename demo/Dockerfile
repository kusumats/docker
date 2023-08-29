FROM adoptopenjdk:11-jre-hotspot
EXPOSE 8080
ADD target/demo-0.0.1-SNAPSHOT.jar springboot-docker-demo.jar
ENTRYPOINT ["java", "-jar", "/springboot-docker-demo.jar"]