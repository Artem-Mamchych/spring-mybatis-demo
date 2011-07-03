package com.ss.demo.model.entity;

import java.util.Date;

/**
 * Stores message entity.
 */
public class Message extends Persistent {

    private Integer id;
    private String messageContent;
    private Date datePosted;

    /**
     * {@inheritDoc }
     */
    public Integer getId() {
        return id;
    }

    /**
     * {@inheritDoc }
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get body of message.
     * @return the id
     */
    public String getMessageContent() {
        return messageContent;
    }

    /**
     * Set body of message.
     * @param messageContent
     */
    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    /**
     * Get date when message was posted.
     * @return the id
     */
    public Date getDatePosted() {
        return datePosted;
    }

    /**
     * Set date when message was posted.
     * @param datePosted new Date
     */
    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", messageContent='" + messageContent + '\'' +
                ", datePosted=" + datePosted +
                '}';
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (datePosted != null ? !datePosted.equals(message.datePosted) : message.datePosted != null) return false;
        if (id != null ? !id.equals(message.id) : message.id != null) return false;
        if (messageContent != null ? !messageContent.equals(message.messageContent) : message.messageContent != null)
            return false;

        return true;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (messageContent != null ? messageContent.hashCode() : 0);
        result = 31 * result + (datePosted != null ? datePosted.hashCode() : 0);
        return result;
    }
}