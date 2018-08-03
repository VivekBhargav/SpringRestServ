package com.task20.springMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerClass {
	
	
	@RequestMapping(" ")
	public String defaultOp() {
		return "index";
	}
	
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String customer() {
        return "customer";
    }
}
