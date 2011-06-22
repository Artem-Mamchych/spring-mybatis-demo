package com.ss.demo.model.mybatis;

import com.ss.demo.model.entity.Message;

import java.util.List;

public interface MessageMapper {

	Integer insert(Message message);

	List<Message> selectAll();

	Message select(Integer id);

	Integer update(Message message);

	Integer delete(Integer id);

}