FROM amazoncorretto:21

WORKDIR /uc-app-back

COPY build/libs/*.jar .

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "univille-calendar.jar"]