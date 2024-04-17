FROM adoptopenjdk/openjdk11:alpine-jre
VOLUME /tmp
ADD ./build/libs/customer-service.jar app.jar
EXPOSE 7000
ENTRYPOINT ["java","-Djava.awt.headless=true","-Duser.timezone=America/Bogota","-jar","/app.jar"]