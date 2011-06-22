package com.ss.demo.model;

import com.ss.demo.model.entity.Message;
import com.ss.demo.model.entity.Persitent;

import java.util.List;

public interface Dao<T extends Persitent> {

    void saveOrUpdate(T persistent);

    public void save(Message persistent);

    public void update(Message persistent);

    void delete(Integer id);

    void delete(T persistent);

    T get(Integer id);

    List<T> getAll();
}

