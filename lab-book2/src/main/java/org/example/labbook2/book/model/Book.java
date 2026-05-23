package org.example.labbook2.book.model;

import jakarta.persistence.*;
import lombok.*;


import java.util.UUID;

@Entity
@Table(name = "books")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Book {

    @Id
    @Column(name="ISBN", columnDefinition = "BINARY(16)")
    private UUID ISBN;

    @Setter
    @Column(name="title",length = 100, nullable = false)
    private String title;

    @Setter
    @Column(name="edition", nullable = false)
    private Integer edition;

    @Embedded
    @Setter
    @AttributeOverride(name="id", column= @Column(name="author", columnDefinition = "BINARY(16)"))
    private AuthorId author;


}
