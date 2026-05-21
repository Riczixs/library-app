package org.author.labauthor.book.rest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@LoadBalancerClient(value = "lab-author")
public class BookRestTemplateConfig {

    @Bean
    @LoadBalanced
    public RestTemplate authorRestTemplate(RestTemplateBuilder builder) {
        return builder
                .build();
    }

}
