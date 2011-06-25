package com.ss.demo.services.transactional;

import com.ss.demo.model.entity.Message;
import com.ss.demo.model.mybatis.MessageDaoMybatis;
import com.ss.demo.services.MessageService;
import com.ss.demo.services.exceptions.NotFoundException;

import java.util.List;

public class TransactionalMessageService implements MessageService {

    //private final SecurityService securityService;
    /*private MessageService messageService;*/
    private MessageDaoMybatis dao;

    public TransactionalMessageService(/*MessageService messageService, */MessageDaoMybatis messageDao) {
        /*this.messageService = messageService;*/
        this.dao = messageDao;
    }

    @Override
    public void add(Message message) {
        // Check if the user is authenticated
//        if (currentUser == null) {
//            throw new IllegalStateException("User should log in to post answers.");
//        }

//        Message m = dao.get(message.getId());
//        if (m == null) {
//            throw new NotFoundException("Message with id: " + message.getId() + " not found");
//        }
        //dao.saveOrUpdate();
        dao.save(message);
    }

    @Override
    public List<Message> getAll() throws NotFoundException {
          // Check if the user is authenticated
//        if (currentUser == null) {
//            throw new IllegalStateException("User should log in to post answers.");
//        }

        List<Message> list = dao.getAll();
//        if (list == null) {
//            throw new NotFoundException("Message with id: " + message.getId() + " not found");
//        }
        //dao.saveOrUpdate();
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

    public long getNextId(){
        long id = dao.getLastInsertId();
        return id + 1;
    }
}
