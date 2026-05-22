package org.author.labauthor.author.controller;

import lombok.RequiredArgsConstructor;
import org.author.labauthor.author.model.Author;
import org.author.labauthor.author.model.AuthorDTO;
import org.author.labauthor.author.model.AuthorId;
import org.author.labauthor.author.repository.AuthorRepository;
import org.author.labauthor.author.rest.AuthorRest;
import org.author.labauthor.author.rest.AuthorRestMapper;
import org.author.labauthor.author.service.AuthorService;
import org.author.labauthor.core.rest.RestCollection;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    private final AuthorService authorService;
    private final AuthorRepository authorRepository;
    private final AuthorRestMapper authorRestMapper;

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<RestCollection<AuthorRest>> getAll(){
        Iterable<Author> authors = authorService.getAll();
        return ResponseEntity.ok(authorRestMapper.toCollectionDTO(authors));
    }

    @GetMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<AuthorRest> getById(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(authorService.getById(AuthorId.of(id)));
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes =  MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<AuthorDTO> createUpdateAuthor(@PathVariable UUID id, @RequestBody AuthorDTO authorDTO){
        AuthorId authorId = AuthorId.of(id);
        if(!authorRepository.existsById(authorId.getId())){
            return ResponseEntity.ok(authorService.create(
                    new AuthorDTO(
                            authorId.getId(),
                            authorDTO.firstName(),
                            authorDTO.lastName(),
                            authorDTO.age()
                    )
            ));
        }else{
            authorService.update(authorId, authorDTO);
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping(
            path ="/{id}"
    )
    public ResponseEntity<Void> deleteAuthor(@PathVariable UUID id){
        try{
            authorService.delete(AuthorId.of(id));
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

}
