FROM amazoncorretto:21

WORKDIR /univille-calendar

COPY build/libs/*.jar .

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "univille-calendar-0.0.1.jar"]