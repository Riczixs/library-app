package org.author.labauthor.author.rest;

import org.author.labauthor.author.model.Author;
import org.author.labauthor.core.rest.RestCollection;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.stream.StreamSupport;

@Component
public class AuthorRestMapper {

    public AuthorRest toAuthorRest(Author author) {
        if(author == null){
            return null;
        }
        return new AuthorRest(
                author.getId(),
                author.getFirstName(),
                author.getLastName(),
                author.getAge()
        );
    }

    public RestCollection<AuthorRest> toCollectionDTO(Iterable<Author> authors){
        if(authors == null){
            Collections.emptyIterator();
        }
        return RestCollection.<AuthorRest>builder()
                .items(StreamSupport.stream(authors.spliterator(), false)
                        .map(this::toAuthorRest).toList())
                .build();
    }
}
