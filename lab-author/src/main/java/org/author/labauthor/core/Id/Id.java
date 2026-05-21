package org.author.labauthor.core.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public abstract class Id<T>{ //prob exists just for clarity of code?
     private UUID id;
}
