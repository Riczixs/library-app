package org.author.labauthor.author.service;


import lombok.*;

import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthorDeletedEvent {
    private UUID authorId;
}
