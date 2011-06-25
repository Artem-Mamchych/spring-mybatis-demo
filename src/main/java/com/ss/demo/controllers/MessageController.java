package com.ss.demo.controllers;

import com.ss.demo.model.entity.Message;
import com.ss.demo.services.MessageService;
import com.ss.demo.services.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MessageController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private final MessageService messageService;

    /**
     * Constructor. Injects {@link MessageService}.
     *
     * @param messageService {@link MessageService} instance to be injected
     */
    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @RequestMapping(value="/message-all", method=RequestMethod.GET)
    public ModelAndView getAllMessages() throws NotFoundException {
        logger.info("getAllMessages GET");
        List<Message> messages = messageService.getAll();
        //Message newMessage = new Message();
        //newMessage.setMessageContent("Type text");

        ModelAndView mav = new ModelAndView("messageList");
        mav.addObject("messages", messages);
        //mav.addObject("newMessage", newMessage);
        return mav;
    }


}
