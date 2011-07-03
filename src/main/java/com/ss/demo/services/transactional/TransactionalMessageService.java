package com.ss.demo.services.transactional;

import com.ss.demo.model.entity.Message;
import com.ss.demo.model.mybatis.MessageDaoMybatis;
import com.ss.demo.services.MessageService;
import com.ss.demo.services.exceptions.NotFoundException;

import java.util.List;

public class TransactionalMessageService implements MessageService {

    //private final SecurityService securityService;
    private MessageDaoMybatis dao;

    public TransactionalMessageService(MessageDaoMybatis messageDao) {
        this.dao = messageDao;
    }

    @Override
    public void add(Message message) {
        dao.save(message);
    }

    @Override
    public List<Message> getAll() throws NotFoundException {
        List<Message> list = dao.getAll();
        return list;
    }

    @Override
    public Message get(Integer id) throws NotFoundException {
        if (!dao.isExist(id)) {
            throw new NotFoundException("Entity with id: " + id + " not found");
        }
        return dao.get(id);
    }

    @Override
    public void delete(Integer id) throws NotFoundException {
        if (!dao.isExist(id)) {
            throw new NotFoundException("Entity with id: " + id + " not found");
        }
        dao.delete(id);
    }

    @Override
    public void update(Message persistent){
        dao.update(persistent);
    }
}
