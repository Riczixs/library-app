//package org.example.labbook2.core;
//
//import lombok.RequiredArgsConstructor;
//import org.book.labbook.book.model.AuthorId;
//import org.book.labbook.book.model.BookDTO;
//import org.book.labbook.book.service.BookService;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.stereotype.Component;
//
//import java.util.UUID;
//
//@Component
//@RequiredArgsConstructor
//public class Initializer implements InitializingBean {
//    private final BookService bookService;
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        bookService.saveBook(BookDTO.builder()
//                .ISBN(UUID.nameUUIDFromBytes(("Book1").getBytes()))
//                .title("Book 1")
//                .edition(1)
//                .author(AuthorId.of(UUID.nameUUIDFromBytes(("John Smith").getBytes())))
//                .build());
//        bookService.saveBook(BookDTO.builder()
//                .ISBN(UUID.nameUUIDFromBytes(("Book2").getBytes()))
//                .title("Book 2")
//                .edition(1)
//                .author(AuthorId.of(UUID.nameUUIDFromBytes(("John Smith").getBytes())))
//                .build());
//        bookService.saveBook(BookDTO.builder()
//                .ISBN(UUID.nameUUIDFromBytes(("Book3").getBytes()))
//                .title("Book 3")
//                .edition(1)
//                .author(AuthorId.of(UUID.nameUUIDFromBytes(("Billy Kimbell").getBytes())))
//                .build());
//        bookService.saveBook(BookDTO.builder()
//                .ISBN(UUID.nameUUIDFromBytes(("Book4").getBytes()))
//                .title("Book 4")
//                .edition(1)
//                .author(AuthorId.of(UUID.nameUUIDFromBytes(("Billy Kimbell").getBytes())))
//                .build());
//        bookService.saveBook(BookDTO.builder()
//                .ISBN(UUID.nameUUIDFromBytes(("Book5").getBytes()))
//                .title("Book 5")
//                .edition(1)
//                .author(AuthorId.of(UUID.nameUUIDFromBytes(("Jane Doe").getBytes())))
//                .build());
//        bookService.saveBook(BookDTO.builder()
//                .ISBN(UUID.nameUUIDFromBytes(("Book6").getBytes()))
//                .title("Book 6")
//                .edition(1)
//                .author(AuthorId.of(UUID.nameUUIDFromBytes(("Jane Doe").getBytes())))
//                .build());
//        bookService.saveBook(BookDTO.builder()
//                .ISBN(UUID.nameUUIDFromBytes(("Book7").getBytes()))
//                .title("Book 7")
//                .edition(1)
//                .author(AuthorId.of(UUID.nameUUIDFromBytes(("Mary Jane").getBytes())))
//                .build());
//        bookService.saveBook(BookDTO.builder()
//                .ISBN(UUID.nameUUIDFromBytes(("Book8").getBytes()))
//                .title("Book 8")
//                .edition(1)
//                .author(AuthorId.of(UUID.nameUUIDFromBytes(("Mary Jane").getBytes())))
//                .build());
//    }
//}
