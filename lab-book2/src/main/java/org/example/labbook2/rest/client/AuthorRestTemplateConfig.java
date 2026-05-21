package org.example.labbook2.rest.client;

import org.example.labbook2.core.rest.CustomLoadBalancerConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@LoadBalancerClient(value = "lab-book")
public class AuthorRestTemplateConfig {
    @Bean
    @LoadBalanced
    public RestTemplate authorRestTemplate(RestTemplateBuilder builder){
        return new RestTemplate();
    }

}
