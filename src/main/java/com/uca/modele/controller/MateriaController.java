package com.uca.modele.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.modele.dao.MateriasDAO;
import com.uca.modele.domain.Materias;
import com.uca.modele.service.MateriasService;

public class MateriaController {

	@Autowired
	MateriasService materiasService;

	@Autowired
	MateriasDAO materiasDAO;

	// VISTA PARA MATERIA
	@RequestMapping("/materia")
	public ModelAndView verMateria() {
		ModelAndView mav = new ModelAndView();
		Materias materias = new Materias();
		List<Materias> materiass = null;
		try {
			materiass = materiasService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("error", "");

		mav.addObject("materiass", materiass);
		mav.addObject("materias", materias);
		mav.setViewName("catalogoM");
		return mav;
	}
	
	
}
