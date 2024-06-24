package com.elthobhy.barbershop.services;

import java.util.List;

public interface GenericCrud<T, ID> {
    T create(T entity);

    T update(T entity);

    List<T> read();

    T getById(ID id);

    boolean softDelete(ID id);

    boolean hardDelete(ID id);
}
