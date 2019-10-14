package com.julian.bootmvchibernate.controller;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.Formatter;

import com.julian.bootmvchibernate.model.User;
import com.julian.bootmvchibernate.service.GeneralService;


public class UserFormatter implements Formatter<User> {
	
	@Autowired
	@Qualifier("userService")
	public GeneralService<User> userService;

	@Override
	public String print(User object, Locale locale) {
		return (object != null ? object.getUsername() : "");
	}

	@Override
	public User parse(String text, Locale locale) throws ParseException {
		final Integer userId = Integer.parseInt(text);
		return userService.get(userId);
	}

}
