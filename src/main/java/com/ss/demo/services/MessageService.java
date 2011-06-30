package com.ss.demo.services;

import com.ss.demo.model.entity.Message;
import com.ss.demo.services.exceptions.NotFoundException;

import java.util.List;

public interface MessageService {

    /**
     * Adds message.
     * User should be authorized to add message. Otherwise {@link IllegalStateException} will be thrown.
     *
     * @param message Message instance
     * @throws NotFoundException when message not found
     */
//     * @param messageId  target message primary id.
//     * @param messageBody the text of the message
    //void add(Integer messageId, String messageBody) throws NotFoundException;
    void add(Message message);

    /**
     * Deletes message.
     *
     * @param messageId message id.
     * @throws NotFoundException when message not found
     */
    void delete(Integer messageId) throws NotFoundException;

    /**
     * Returns list with all messages.
     *
     * @throws NotFoundException when messages not found
     */
    List<Message> getAll() throws NotFoundException;

    /**
     * Returns message.
     *
     * @param messageId message id.
     * @throws NotFoundException when branch not found
     */
    Message get(Integer messageId) throws NotFoundException;


    void update(Message persistent);

    long getNextId();
}
