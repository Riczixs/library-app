package org.author.labauthor.author.service;

import java.util.function.Consumer;
import java.util.function.Supplier;

public interface CrudService {
    default <T> void updateFrom(Supplier<T> getter, Consumer<T> setter){
        T value = getter.get();
        if(value != null){
            setter.accept(value);
        }
    }
}
