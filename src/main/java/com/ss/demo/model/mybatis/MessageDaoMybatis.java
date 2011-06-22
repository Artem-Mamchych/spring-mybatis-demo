package com.ss.demo.model.mybatis;

import com.ss.demo.model.Dao;
import com.ss.demo.model.entity.Message;

import java.util.List;

public interface MessageDaoMybatis extends Dao<Message> {

    public void saveOrUpdate(Message persistent);

    public void save(Message persistent);

    public void update(Message persistent);

    public void delete(Integer id);

    public void delete(Message persistent);

    public Message get(Integer id);

    public List<Message> getAll();
}
