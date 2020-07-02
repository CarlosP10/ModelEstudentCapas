package com.uca.modele.controller.catalogos;

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

import com.uca.modele.dao.EscuelasDAO;
import com.uca.modele.domain.Escuelas;
import com.uca.modele.service.EscuelasService;

@Controller
public class EscuelaController {
	
	@Autowired
	EscuelasService escuelasService;

	@Autowired
	EscuelasDAO escuelasDAO;

	@RequestMapping("/EscuelasTable")
	public String EscuelasTable() {
		return "catalogoCE";
	}

	@RequestMapping("/verEscuelas")
	public @ResponseBody List<Escuelas> verEscuelas() {
		Sort sort = Sort.by(Direction.ASC, "id_escuela");
		return escuelasService.findAll(sort);
	}

	@RequestMapping("/editarEscuela")
	public ModelAndView buscar(@RequestParam Integer id) {
		ModelAndView mav = new ModelAndView();
		Escuelas c = escuelasService.findOne(id);
		mav.addObject("escuelas", c);
		mav.setViewName("FALTA HACER EL HTML DE EDITAR Escuelas");
		return mav;
	}

	@RequestMapping("/guardarEscuelas")
	public ModelAndView guardarEscuelas(@ModelAttribute Escuelas escuelas) {
		ModelAndView mav = new ModelAndView();
		escuelasService.save(escuelas);
		mav.setViewName("catalogoCE");
		mav.addObject("resultado", 1);
		return mav;
	}
}
