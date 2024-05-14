package com.shahbaz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankOperationController {
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/offers")
	public String showOffers() {
		return "offers";
	}
	
	@GetMapping("/balance")
	public String checkBalance() {
		return "show_offers";
	}
	
	@GetMapping("/denied")
	public String accessDenied() {
		return "access_denied";
	}
}
