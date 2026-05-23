FROM eclipse-temurin:25-alpine as builder

ENV SERVER_PORT=8761
ENV EUREKA_CLIENT_FETCH_REGISTRY=false
ENV EUREKA_CLIENT_REGISTER_WITH_EUREKA=false
ENV EUREKA_CLIENT_SERVICE_URL_DEFAULTZONE=http://localhost:8761/eureka
ENV EUREKA_SERVER_ENABLE_SELF_PRESERVATION=false
ENV EUREKA_SERVER_EVICTION_INTERVAL_TIMER_IN_MS=2000

WORKDIR app
ARG JAR_FILE=target/*.jar
ARG JAR_DIR=${0%/*}
COPY ${JAR_FILE} app.jar
RUN java -Djarmode=layertools -jar app.jar extract
RUN pwd & ls

FROM eclipse-temurin:25-alpine
WORKDIR app
COPY --from=builder app/dependencies ./
COPY --from=builder app/spring-boot-loader ./
COPY --from=builder app/snapshot-dependencies ./
COPY --from=builder app/application ./

ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]

EXPOSE 8761

