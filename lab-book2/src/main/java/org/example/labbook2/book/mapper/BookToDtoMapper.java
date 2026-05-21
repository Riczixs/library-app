package org.example.labbook2.book.mapper;


import org.example.labbook2.book.model.Book;
import org.example.labbook2.book.model.BookDTO;
import org.springframework.stereotype.Component;

@Component
public class BookToDtoMapper {
    public BookDTO map(Book book){
        if(book==null) throw new NullPointerException("book is null");

        return new BookDTO(
                book.getISBN(),
                book.getTitle(),
                book.getEdition(),
                book.getAuthor()
        );
    }
}
