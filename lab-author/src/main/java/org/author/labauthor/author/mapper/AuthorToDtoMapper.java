package org.author.labauthor.author.mapper;


import lombok.RequiredArgsConstructor;
import org.author.labauthor.author.model.Author;
import org.author.labauthor.author.model.AuthorDTO;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthorToDtoMapper {

    public AuthorDTO map(Author author){
        if(author == null) throw new RuntimeException("Author is null");

        return new AuthorDTO(
                author.getId(),
                author.getFirstName(),
                author.getLastName(),
                author.getAge()
        );
    }
}
