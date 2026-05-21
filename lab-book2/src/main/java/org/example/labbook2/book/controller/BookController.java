package org.example.labbook2.book.controller;
import lombok.RequiredArgsConstructor;

import org.example.labbook2.book.model.Book;
import org.example.labbook2.book.model.BookDTO;
import org.example.labbook2.book.model.BookId;
import org.example.labbook2.book.repository.BookRepository;
import org.example.labbook2.book.service.BookService;
import org.example.labbook2.core.rest.BookRest;
import org.example.labbook2.core.rest.BookRestMapper;
import org.example.labbook2.book.model.AuthorId;
import org.example.labbook2.core.rest.RestCollection;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;
import java.util.stream.StreamSupport;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;
    private final BookRepository bookRepository;
    private final BookRestMapper bookRestMapper;

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<RestCollection<BookRest>> getBooks(){
        Iterable<Book> books = bookService.getAll();
        return ResponseEntity.ok(bookRestMapper.toCollectionDTO(books));
    }

    @GetMapping(
            path="/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BookDTO> getBookById(@PathVariable UUID id){
        try{
            return ResponseEntity.ok(bookService.getById(BookId.of(id)));
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(
            path = "/authors/{bookId}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes =  MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Void> addBookToAuthor(@PathVariable UUID bookId, @RequestBody BookDTO bookDTO){
        try{
            BookId bookID = BookId.of(bookId);
            if(!bookService.checkIfBookExists(bookID, bookDTO.author())){
                bookService.saveBook(
                        new BookDTO(bookId,
                                bookDTO.title(),
                                bookDTO.edition(),
                                bookDTO.author())
                        );
                return ResponseEntity.created(URI.create("/api/authors/" + bookDTO.author().getId() + "/books/" + bookID.getId())).build();
            }else{
                bookService.update(bookID, bookDTO);
                return ResponseEntity.noContent().build();
            }
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping(
            path="/authors/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<RestCollection<BookRest>> getAuthorBooks(@PathVariable UUID id){
            try {
                Iterable<Book> books = bookService.getAll(AuthorId.of(id));
                long ept = StreamSupport.stream(books.spliterator(), false)
                        .count();
                if (ept == 0) return ResponseEntity.noContent().build();
                return ResponseEntity.ok(bookRestMapper.toCollectionDTO(books));
            }catch(RuntimeException e){
                return ResponseEntity.notFound().build();
            }
        }

    @PutMapping(
            path="/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BookDTO> updateBook(@PathVariable UUID id, @RequestBody BookDTO book){
        BookId bookIsbn = BookId.of(id);
        if(!bookRepository.existsById(bookIsbn.getId())) {
            return ResponseEntity.ok(bookService.saveBook(
                    new BookDTO(
                            bookIsbn.getId(),
                            book.title(),
                            book.edition(),
                            book.author()
                    )
            ));
        }else{
            BookDTO dto = bookService.update(bookIsbn, book);
            return ResponseEntity.ok(dto);
        }
    }

    @DeleteMapping(
            path="/{id}"
    )
    public ResponseEntity<Void> deleteBook(@PathVariable UUID id){
        if(!bookRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        bookService.delete(BookId.of(id));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(
            path = "/{authorId}/author"
    )
    public ResponseEntity<Void> deleteAuthorBooks(@PathVariable UUID authorId){
        bookService.deleteAuthorsBooks(AuthorId.of(authorId));
        return ResponseEntity.noContent().build();
    }

}
