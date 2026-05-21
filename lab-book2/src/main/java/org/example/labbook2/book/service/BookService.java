package org.example.labbook2.book.service;

import lombok.RequiredArgsConstructor;

import org.example.labbook2.book.mapper.BookToDtoMapper;
import org.example.labbook2.book.mapper.DtoToBookMapper;
import org.example.labbook2.book.model.AuthorId;
import org.example.labbook2.book.model.Book;
import org.example.labbook2.book.model.BookDTO;
import org.example.labbook2.book.model.BookId;
import org.example.labbook2.book.repository.BookRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService implements CrudService {
    private final BookRepository bookRepository;
    private final BookToDtoMapper bookToDtoMapper;
    private final DtoToBookMapper dtoToBookMapper;
    private final AuthorClientService authorService;

    public Iterable<Book> getAll(){
        return bookRepository.findAll();
    }

    @Transactional
    public Iterable<Book> getAll(AuthorId id){ //How does it work?
        authorService.findAuthor(id);
        return bookRepository.findByAuthorId(id.getId());
    }

    @Transactional
    public BookDTO getById(BookId isbn) throws RuntimeException {
        Book book = bookRepository.findById(isbn.getId()).orElseThrow(() -> new RuntimeException("Book Not Found"));
        return bookToDtoMapper.map(book);
    }

    @Transactional
    public BookDTO getBook(BookId isbn, AuthorId authorId){
        authorService.findAuthor(authorId);
        Book book = bookRepository.findBookByISBNAndAuthor(isbn.getId(),authorId)
                .orElseThrow(() -> new RuntimeException("Book Not Found"));
        return bookToDtoMapper.map(book);
    }

    @Transactional
    public BookDTO saveBook(BookDTO book){
        authorService.findAuthor(book.author());
        Book result = dtoToBookMapper.map(book);
        return bookToDtoMapper.map(bookRepository.save(result));
    }

    public boolean checkIfBookExists(BookId isbn, AuthorId authorId){
        return bookRepository.existsByISBNAndAuthor(isbn.getId(),authorId);
    }

    @Transactional
    public BookDTO update(BookId isbn, BookDTO toUpdate){
        Book book = bookRepository.findById(isbn.getId()).orElseThrow(() -> new RuntimeException("Book of given ISBN does not exists!"));
        updateFrom(toUpdate::title, book::setTitle);
        updateFrom(toUpdate::edition, book::setEdition);
        bookRepository.save(book);
        return bookToDtoMapper.map(book);
    }

    @Transactional
    public void delete(BookId isbn){
        bookRepository.deleteById(isbn.getId());
    }


    @Transactional
    public void deleteAuthorsBooks(AuthorId authorId){
        authorService.findAuthor(authorId);
        bookRepository.deleteByAuthor(authorId);
    }

    @EventListener
    public void onAuthorDeleted(AuthorDeletedEvent event){
        bookRepository.deleteByAuthor(AuthorId.of(event.getAuthorId()));
    }

}

