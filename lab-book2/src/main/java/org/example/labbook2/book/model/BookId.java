package org.example.labbook2.book.model;



import org.example.labbook2.core.Id.Id;

import java.util.UUID;

public class BookId extends Id<Book> {
    public BookId(UUID id) {
        super(id);
    }
    public static BookId of(UUID id) {
        return new BookId(id);
    }
    public static BookId of(Book book){
      return new BookId(book.getISBN());
    }
}
