package com.uca.modele.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping("/indexAdmin")
	public String indexAdmin() {
		return "indexAdmin";
	}
}
