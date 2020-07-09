package com.uca.modele.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.modele.domain.Cuenta;
import com.uca.modele.service.CuentaService;

@Controller
public class MainController {

	@RequestMapping("/login")
	public ModelAndView indexLaboratorio8() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}

}
