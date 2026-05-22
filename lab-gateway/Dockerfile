FROM eclipse-temurin:25-alpine as builder

ENV EUREKA_INSTANCE_PREFER_IP_ADDRESS=true
ENV SPRING_CLOUD_GATEWAY_SERVER_WEBFLUX_DISCOVERY_LOCATOR_ENABLED=true

WORKDIR app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
RUN java -Djarmode=layertools -jar app.jar extract

FROM eclipse-temurin:25-alpine
WORKDIR app

COPY --from=builder app/dependencies ./
COPY --from=builder app/spring-boot-loader ./
COPY --from=builder app/snapshot-dependencies ./
COPY --from=builder app/application ./

ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]

EXPOSE 8083
