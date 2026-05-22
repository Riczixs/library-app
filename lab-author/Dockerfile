FROM eclipse-temurin:25-alpine as builder
ENV SPRING_DATASOURCE_URL=jdbc:mysql://db:3306/db_authors
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=root
ENV SPRING_JPA_PROPERTIES_PREFERRED_UUID_JDBC_TYPE=BINARY
ENV EUREKA_INSTANCE_PREFER_IP_ADDRESS=true

WORKDIR app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
RUN java -Djarmode=layertools -jar app.jar extract


FROM eclipse-temurin:25-alpine
WORKDIR app
#THE ORDER IS IMPORTANT 
COPY --from=builder app/dependencies ./
COPY --from=builder app/spring-boot-loader ./
COPY --from=builder app/snapshot-dependencies ./
COPY --from=builder app/application ./

ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]

EXPOSE 8081

# COPY target/lab-author-0.0.1-SNAPSHOT.jar app.jar
# CMD ["java", "-jar", "app.jar"]