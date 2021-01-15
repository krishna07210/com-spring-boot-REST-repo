package com.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.configuration.BasicConfiguration;

@RestController
public class WelcomeController {

	@Value("${welcome.message}")
	private String welcomMessage;

	@Autowired
	BasicConfiguration basicConfiguration;

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String retriveWelcomMessage() {
		return welcomMessage;
	}

	@RequestMapping(value = "/dynamic-configuration", method = RequestMethod.GET)
	public Map dynamicConfiguration() {
		Map map = new HashMap();
		map.put("message", basicConfiguration.getMessage());
		map.put("number", basicConfiguration.getNumber());
		map.put("value", basicConfiguration.isValue());
		return map;
	}
}
