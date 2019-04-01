#Docker Sample Restful service
FROM openjdk:8-jre-alpine
EXPOSE 8080
COPY target/SystemEventsService-1.jar /SystemEventsService.jar	
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "/SystemEventsService.jar"]