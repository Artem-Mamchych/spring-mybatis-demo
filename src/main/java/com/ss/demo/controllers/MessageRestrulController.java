package com.ss.demo.controllers;

import com.ss.demo.model.entity.Message;
import com.ss.demo.services.MessageService;
import com.ss.demo.services.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * MessageRestrulController handles requests only for processing
 * HTTP protocol methods: POST, GET, PUT, DELETE on Message class instance
 */

@Controller
@RequestMapping(value="/message")
public class MessageRestrulController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private final MessageService messageService;

    /**
     * Constructor. Injects {@link MessageService}.
     *
     * @param messageService {@link MessageService} instance to be injected
     */
    @Autowired
    public MessageRestrulController(MessageService messageService) {
        this.messageService = messageService;
    }

	@RequestMapping(method=RequestMethod.GET)
	public String getCreateForm(Model model) {
	    logger.info("getCreateForm RequestMapping(method=RequestMethod.GET)");
		model.addAttribute(new Message());
		return "message/createForm";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String create(Message message, BindingResult result) {
	    logger.info("create RequestMapping(method=RequestMethod.POST)");
		if (result.hasErrors()) {
			return "message/createForm";
		}
		message.setDatePosted(new Date(System.currentTimeMillis()));
        messageService.add(message);
		return "redirect:/message/" + message.getId();
	}

	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String getView(@PathVariable Long id, Model model) {
	    logger.info("getView RequestMapping(value={id}, method=RequestMethod.GET)");
        Message message = null;
        try {
            message = messageService.get(id.intValue());
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        if (message == null) {
			throw new NotFoundException("Message with id:" + id + " not found");
		}
		model.addAttribute(message);
		return "message/view";
	}

    @RequestMapping(value="{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable Long id, Model model) {
	    logger.info("RequestMethod.DELETE handler");
        try {
            this.messageService.delete(id.intValue());
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
		return "redirect:/message-all";
	}

    @RequestMapping(value="{id}", method=RequestMethod.PUT)
	public String update(@PathVariable Long id, Model model) {
	    logger.info("RequestMethod.PUT handler");
        Message message = null;
        try {
            message = messageService.get(id.intValue());
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
		return "redirect:/message-all"; //TODO redirect to edit form
	}
}
