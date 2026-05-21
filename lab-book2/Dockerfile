FROM eclipse-temurin:21.0.8_9-jre

EXPOSE 8082

ENV SPRING_DATASOURCE_URL=jdbc:mysql://db:3306/db_books
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=root

COPY target/lab-book2-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]