package org.author.labauthor.author.service;

import lombok.RequiredArgsConstructor;
import org.author.labauthor.author.mapper.AuthorToDtoMapper;
import org.author.labauthor.author.mapper.DtoToAuthorMapper;
import org.author.labauthor.author.model.Author;
import org.author.labauthor.author.model.AuthorDTO;
import org.author.labauthor.author.model.AuthorId;
import org.author.labauthor.author.repository.AuthorRepository;
import org.author.labauthor.author.rest.AuthorRest;
import org.author.labauthor.author.rest.AuthorRestMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthorService implements CrudService{
    private final AuthorRepository authorRepository;
    //public final BookRepository bookRepository;
    private final AuthorToDtoMapper authorToDtoMapper;
    private final DtoToAuthorMapper dtoToAuthorMapper;
    private final AuthorRestMapper authorRestMapper;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public Iterable<Author> getAll(){
        return authorRepository.findAll();
    }

    @Transactional
    public AuthorDTO create(AuthorDTO authorDTO){
        if(authorDTO == null) throw new RuntimeException();
        Author author = dtoToAuthorMapper.map(authorDTO);
        return authorToDtoMapper.map(authorRepository.save(author));
    }

    @Transactional
    public AuthorDTO update(AuthorId id, AuthorDTO authorDTO){
        Author toUpdate = authorRepository.findById(id.getId()).orElseThrow(() -> new RuntimeException("Author not found!"));
        updateFrom(authorDTO::age, toUpdate::setAge);
        updateFrom(authorDTO::firstName, toUpdate::setFirstName);
        updateFrom(authorDTO::lastName, toUpdate::setLastName);
        return authorToDtoMapper.map(authorRepository.save(toUpdate));
    }

    @Transactional
    public void delete(AuthorId id){
        authorRepository.findById(id.getId())
                .ifPresentOrElse(author ->{
                    eventPublisher.publishEvent(AuthorDeletedEvent.builder()
                            .authorId(author.getId())
                            .build());
                    authorRepository.delete(author);
                }, () -> {
                    throw new RuntimeException("Author not found!");
                });
    }

    @Transactional
    public AuthorRest getById(AuthorId id) throws RuntimeException{
        Author result = authorRepository.findById(id.getId()).orElseThrow(RuntimeException::new);
        return authorRestMapper.toAuthorRest(result);
    }
}
