package org.author.labauthor.author.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
@Entity
@Table(name = "authors")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class Author{

    static final long serialVersionUID = 12;

    @Id
    @Column(name="id", columnDefinition = "varbinary(16)")
    private UUID id;

    @Setter
    @Column(name="first_name",length = 100, nullable = false)
    private String firstName;

    @Setter
    @Column(name="last_name", length = 100, nullable = false)
    private String lastName;

    @Setter
    @Column(name="age")
    private Integer age;

}