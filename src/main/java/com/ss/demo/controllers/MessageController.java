package com.ss.demo.controllers;

import com.ss.demo.model.entity.Message;
import com.ss.demo.services.MessageService;
import com.ss.demo.services.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MessageController {

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

    @RequestMapping(value = "/messages/all", method = RequestMethod.GET)
    public ModelAndView showAll() throws NotFoundException {

        List<Message> messages = messageService.getAll();
        return new ModelAndView("messageList")
                .addObject("messages", messages);
    }
}
