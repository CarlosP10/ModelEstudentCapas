package com.uca.modele.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.modele.domain.Expediente;
import com.uca.modele.domain.Materias;
import com.uca.modele.service.ExpedienteService;

@Controller
public class ExpedienteController {
	
	@Autowired
	private ExpedienteService expedienteService;
	
	@RequestMapping("/pantallaInicialExpediente")
	public String pantallaExp() {
		return "expedienteA";
	}
	
	@RequestMapping("/verExpediente")
	public @ResponseBody List<Expediente> verExpediente() {
		Sort sort = Sort.by(Direction.ASC, "ccliente");
		return expedienteService.findAll(sort);
	}

	@RequestMapping("/editarExpediente")
	public ModelAndView buscar(@RequestParam Integer id) {
		ModelAndView mav = new ModelAndView();
		Expediente c = expedienteService.findOne(id);
		mav.addObject("expediente", c);
		mav.setViewName("modificarExp");
		return mav;
	}

	@RequestMapping("/guardarExpediente")
	public ModelAndView guardarExpediente(@ModelAttribute Expediente expedientes) {
		ModelAndView mav = new ModelAndView();
		expedienteService.save(expedientes);
		mav.setViewName("busquedaA");
		mav.addObject("resultado", 1);
		return mav;
	}

}
