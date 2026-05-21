package org.example.labbook2.book.model;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.util.UUID;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
@EqualsAndHashCode
public class AuthorId {
    private UUID id;
    public AuthorId(UUID id) {
        this.id = id;
    }
    public static AuthorId of(UUID id) {
        return new AuthorId(id);
    }
}
