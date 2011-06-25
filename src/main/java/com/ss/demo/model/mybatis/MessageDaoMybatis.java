package com.ss.demo.model.mybatis;

import com.ss.demo.model.Dao;
import com.ss.demo.model.entity.Message;

public interface MessageDaoMybatis extends Dao<Message> {

    Integer getLastInsertId();
}
