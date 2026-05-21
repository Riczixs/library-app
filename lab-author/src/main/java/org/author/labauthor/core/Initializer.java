//package org.author.labauthor.core;
//
//import lombok.RequiredArgsConstructor;
//import org.author.labauthor.author.model.AuthorDTO;
//import org.author.labauthor.author.service.AuthorService;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.stereotype.Component;
//
//import java.util.UUID;
//
//@Component
//@RequiredArgsConstructor
//public class Initializer implements InitializingBean {
//    private final AuthorService authorService;
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        authorService.create(AuthorDTO.builder()
//                        .id(UUID.nameUUIDFromBytes(("John Smith").getBytes()))
//                        .firstName("John")
//                        .lastName("Smith")
//                        .age(30)
//                .build());
//        authorService.create(AuthorDTO.builder()
//                .id(UUID.nameUUIDFromBytes(("Billy Kimbell").getBytes()))
//                .firstName("Billy")
//                .lastName("Kimbell")
//                .age(27)
//                .build());
//        authorService.create(AuthorDTO.builder()
//                .id(UUID.nameUUIDFromBytes(("Jane Doe").getBytes()))
//                .firstName("Jane")
//                .lastName("Doe")
//                .age(41)
//                .build());
//        authorService.create(AuthorDTO.builder()
//                .id(UUID.nameUUIDFromBytes(("Mary Jane").getBytes()))
//                .firstName("Mary")
//                .lastName("Jane")
//                .age(25)
//                .build());
//    }
//
//
//}
