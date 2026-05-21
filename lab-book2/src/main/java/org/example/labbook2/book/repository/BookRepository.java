package org.example.labbook2.book.repository;

import org.example.labbook2.book.model.AuthorId;
import org.example.labbook2.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
    Iterable<Book> findByAuthorId(UUID authorId);
    Optional<Book> findBookByISBNAndAuthor(UUID ISBN, AuthorId author);
    boolean existsByISBNAndAuthor(UUID ISBN, AuthorId author);
    void deleteByAuthor(AuthorId authorId);
}
