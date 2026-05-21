package org.example.labbook2.book.service;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
public class AuthorDeletedEvent {
    private UUID authorId;
}
