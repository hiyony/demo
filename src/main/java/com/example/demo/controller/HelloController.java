package com.example.demo.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@Autowired
	MessageSource messageSource;

	@RequestMapping("/hello")
	public String hello(Model model, Locale locale) {
		
		model.addAttribute("title", messageSource.getMessage("app.title", null, locale));
		model.addAttribute("hello", "Helllooooo!");
		return "hello"; //HTMLとreturnの名前が必ず同じようにする
	}
}
