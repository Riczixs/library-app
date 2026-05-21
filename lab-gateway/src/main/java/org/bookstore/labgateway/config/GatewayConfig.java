package org.bookstore.labgateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {


    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("authors", r ->
                        r.host("localhost:8083")
                                .and()
                                .path(
                                        "/api/authors/**"
                                )
                                .uri("lb://lab-author:8081")
                )
                .route("books", r ->
                        r.host("localhost:8083")
                                .and()
                                .path(
                                        "/api/books/**"
                                )
                                .uri("lb://lab-book:8082")
                )
                .build();
    }
}