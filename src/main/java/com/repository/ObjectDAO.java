package com.repository;

import java.util.List;
import java.util.UUID;

public interface ObjectDAO<T> {
    void insert(T obj);

    List<T> findAll();

    void update(T obj);

    boolean deleteById(UUID id);

    T getById(UUID id);

}
