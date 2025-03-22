package com.devops.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@Value("${app.default-hostname}")
	private String defaultHostname;

	@GetMapping("/")
	public String index(final Model model) {
		String hostname;
		try {
			hostname = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			logger.error("Failed to retrieve hostname", e);
			hostname = defaultHostname;
		}
		model.addAttribute("hostname", hostname);
		return "index";
	}
}
