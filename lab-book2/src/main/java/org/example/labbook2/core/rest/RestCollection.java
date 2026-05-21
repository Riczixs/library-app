package org.example.labbook2.core.rest;


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
