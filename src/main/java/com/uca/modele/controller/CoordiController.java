package com.uca.modele.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CoordiController {
	
	@RequestMapping("/indexCoordi")
	public String indexAdmin() {
		return "expedienteA";
	}

}
