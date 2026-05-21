package org.author.labauthor.core.rest;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
public class BookRest {
    private UUID isbn;
    private String title;
}
