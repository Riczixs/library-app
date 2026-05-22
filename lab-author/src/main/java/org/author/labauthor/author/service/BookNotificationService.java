package org.author.labauthor.author.service;

import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class BookNotificationService {

    private final RestTemplate restTemplate;


    @EventListener
    public void onAuthorDeleted(AuthorDeletedEvent event) {
        try{
            restTemplate.delete( "http://lab-book2:8082/api/books/{authorId}/author", event.getAuthorId());
        } catch (HttpClientErrorException e) {
            throw new NotFoundException(e);
        }
    }

}
