package com.ss.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This example shows usage of request.getParameter("param_name")
 */
@Controller
public class SumController extends AbstractController {
    private int count = 0;

    @RequestMapping(value="/sum", method= RequestMethod.GET)
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("calc");
        try {
            count++;
            String x = request.getParameter("x");
            String y  = request.getParameter("y");
            if (x == null || x.length() == 0) {
                 x = "0";
            }
            if (y == null || y.length() == 0) {
                y = "0";
            }
            int sum = Integer.parseInt(x) + Integer.parseInt(y);
            mav.addObject("sum", sum);
            mav.addObject("x", x);
            mav.addObject("y", y);
            mav.addObject("count", count);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return mav;
    }
}