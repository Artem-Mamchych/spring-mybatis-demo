package com.ss.demo.services.transactional;

import com.ss.demo.model.entity.Message;
import com.ss.demo.model.mybatis.MessageDaoMybatis;
import com.ss.demo.services.MessageService;
import com.ss.demo.services.exceptions.NotFoundException;

import java.util.List;

public class TransactionalMessageService
        extends AbstractTransactionalEntityService<Message, MessageDaoMybatis>
        implements MessageService {

    //private final SecurityService securityService;
    /*private MessageService messageService;*/
    private MessageDaoMybatis dao;

    public TransactionalMessageService(/*MessageService messageService, */MessageDaoMybatis messageDao) {
        /*this.messageService = messageService;*/
        this.dao = messageDao;
    }

    @Override
    public void add(Message message) throws NotFoundException {
        // Check if the user is authenticated
//        if (currentUser == null) {
//            throw new IllegalStateException("User should log in to post answers.");
//        }

        Message m = dao.get(message.getId());
        if (m == null) {
            throw new NotFoundException("Message with id: " + message.getId() + " not found");
        }
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
}
