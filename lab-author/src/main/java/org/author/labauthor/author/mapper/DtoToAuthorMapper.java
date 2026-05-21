package org.author.labauthor.author.mapper;


import lombok.RequiredArgsConstructor;
import org.author.labauthor.author.model.Author;
import org.author.labauthor.author.model.AuthorDTO;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DtoToAuthorMapper {
    public Author map(AuthorDTO author){

        return Author.builder()
                .id(author.id())
                .firstName(author.firstName())
                .lastName(author.lastName())
                .age(author.age())
                .build();
    }
}
