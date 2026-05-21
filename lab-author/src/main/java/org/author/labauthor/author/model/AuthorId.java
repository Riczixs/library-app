package org.author.labauthor.author.model;


import org.author.labauthor.core.Id.Id;
import java.util.UUID;

public class AuthorId extends Id<Author> {
    public AuthorId(UUID id) {
        super(id);
    }
    public static AuthorId of(Author author) {
        return new AuthorId(author.getId());
    }
    public static AuthorId of(UUID authorId) {
        return new AuthorId(authorId);
    }
}
