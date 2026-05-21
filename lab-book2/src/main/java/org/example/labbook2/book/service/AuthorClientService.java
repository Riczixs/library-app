package org.example.labbook2.book.service;

import lombok.RequiredArgsConstructor;
import org.example.labbook2.book.model.AuthorId;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class AuthorClientService {
    private final RestTemplate restTemplate;
    private final LoadBalancerClient loadBalancerClient;

    public AuthorId findAuthor(AuthorId authorId) {
        try {
            return restTemplate.getForObject("http://lab-author/api/authors/{id}", AuthorId.class, authorId.getId());
        } catch (HttpClientErrorException.NotFound e) {
            throw new RuntimeException(e);
        }
    }
}
