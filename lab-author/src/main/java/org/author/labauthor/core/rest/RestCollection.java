package org.author.labauthor.core.rest;


import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class RestCollection<T> {
    List<T> items;
}
