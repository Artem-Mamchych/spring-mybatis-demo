package com.ss.demo.model.mybatis;

import com.ss.demo.model.entity.Message;

import java.util.List;

public interface MessageDaoMybatis {

    public void saveOrUpdate(Message persistent);

    public void delete(Long id);

    public void delete(Message persistent);

    public Message get(Long id);

    public List<Message> getAll();
}
