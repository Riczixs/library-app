package org.example.labbook2.book.model;
import java.util.UUID;

public record BookDTO (
    UUID ISBN, String title, Integer edition, AuthorId author
){}
