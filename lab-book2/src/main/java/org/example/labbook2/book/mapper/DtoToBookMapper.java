package org.example.labbook2.book.mapper;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.example.labbook2.book.model.Book;
import org.example.labbook2.book.model.BookDTO;
import org.springframework.stereotype.Component;

@Builder
@Component
@RequiredArgsConstructor
public class DtoToBookMapper {
    public Book map(BookDTO book){
        if(book==null) throw new NullPointerException("book is null");
        return Book.builder()
                .ISBN(book.ISBN())
                .title(book.title())
                .edition(book.edition())
                .author(book.author())
                .build();
    }
}
