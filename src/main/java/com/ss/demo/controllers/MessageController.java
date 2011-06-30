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
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * MessageController handles requests for processing messages
 */

@Controller
public class MessageController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    public static final String MESSAGE_BASEURL = "/message";
    public static final String SHOW_ALL = MESSAGE_BASEURL + "/show/all";
    public static final String CREATE = MESSAGE_BASEURL + "/create";
    public static final String CREATE2 = MESSAGE_BASEURL + "/create/message";
    public static final String SHOW_ID = MESSAGE_BASEURL + "/show/{id}";
    public static final String DELETE_ID = MESSAGE_BASEURL + "/delete/{id}";
    public static final String UPDATE_ID = MESSAGE_BASEURL + "/update/{id}";
    public static final String MESSAGE_CREATE_FORM = "message/createForm";
    public static final String REDIRECT_MESSAGE_SHOW_ID = "redirect:/message/show/";
    public static final String REDIRECT_MESSAGE_SHOW_ALL = "redirect:/message/show/all";
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

    @RequestMapping(value= SHOW_ALL, method=RequestMethod.GET)
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

	@RequestMapping(value={CREATE, CREATE2}, method=RequestMethod.GET)
	public String getCreateForm(Model model) {
	    logger.info("getCreateForm RequestMapping(method=RequestMethod.GET)|" + CREATE);
		model.addAttribute(new Message());
		return "message/createForm";
	}

	@RequestMapping(value={CREATE, CREATE2}, method=RequestMethod.POST)
	public String create(Message message, BindingResult result) {
	    logger.info("create RequestMapping(method=RequestMethod.POST)====" + CREATE);
		if (result.hasErrors()) {
			return "message/createForm";
		}
		message.setDatePosted(new Date(System.currentTimeMillis()));
        messageService.add(message);
		return REDIRECT_MESSAGE_SHOW_ALL;
	}

    @RequestMapping(value= UPDATE_ID, method=RequestMethod.GET)
	public String getEditForm(@PathVariable Long id, Model model) {
	    logger.info("getEditForm|" + UPDATE_ID);
		model.addAttribute(messageService.get(id.intValue()));
		return "message/createForm";
	}

    @RequestMapping(value= UPDATE_ID, method=RequestMethod.POST)
	public String update(Message message, BindingResult result) {
        logger.info("update|" + UPDATE_ID);
		if (result.hasErrors()) {
			return "message/createForm";
		}
		//message.setDatePosted(new Date(System.currentTimeMillis()));
        messageService.update(message);
		return REDIRECT_MESSAGE_SHOW_ALL;
	}

	@RequestMapping(value= SHOW_ID, method=RequestMethod.GET)
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

    @RequestMapping(value= DELETE_ID, method=RequestMethod.GET)
	public String delete(@PathVariable Long id, Model model) {
	    logger.info("delete/{id} handler");
        try {
            this.messageService.delete(id.intValue());
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
		return REDIRECT_MESSAGE_SHOW_ALL;
	}
}
