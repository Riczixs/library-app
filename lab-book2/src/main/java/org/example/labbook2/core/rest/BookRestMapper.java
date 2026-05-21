package org.example.labbook2.core.rest;


import org.example.labbook2.book.model.Book;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Component
public class BookRestMapper {

    public BookRest toDTO(Book book){
        if(book == null){
            return null;
        }
        return new BookRest(book.getISBN(), book.getTitle());
    }

    public RestCollection<BookRest> toCollectionDTO(Iterable<Book> books){
        if(books == null){
            return new RestCollection<>();
        }
        return RestCollection.<BookRest>builder()
                .items(StreamSupport.stream(books.spliterator(),false)
                        .map(this::toDTO)
                        .toList())
                .build();
    }

}
