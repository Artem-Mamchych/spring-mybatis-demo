package com.ss.demo.model.entity;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

public class Message extends Persistent {

    private Integer id;
    private String messageContent;
    private Date datePosted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", messageContent='" + messageContent + '\'' +
                ", datePosted=" + datePosted +
                '}';
    }

    public Long assignId() {
        Long nextId = idSequence.incrementAndGet();
        this.id = nextId.intValue();
		return nextId;
	}

    private static final AtomicLong idSequence = new AtomicLong();
}