FROM openjdk:11
RUN groupadd spring
RUN useradd -g spring -ms /bin/bash spring
USER spring:spring
WORKDIR /home/spring
COPY ./target/*.jar application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "application.jar"]