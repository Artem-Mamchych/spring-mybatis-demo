package com.ss.demo.model;

import com.ss.demo.model.entity.Persitent;

import java.util.List;

public interface Dao<T extends Persitent> {

    void saveOrUpdate(T persistent);

    void delete(Long id);

    void delete(T persistent);

    T get(Long id);

    List<T> getAll();
}

