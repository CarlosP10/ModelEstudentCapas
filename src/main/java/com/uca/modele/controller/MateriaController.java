package com.uca.modele.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.uca.modele.dao.MateriasDAO;
import com.uca.modele.domain.Materias;
import com.uca.modele.service.MateriasService;

public class MateriaController {

	@Autowired
	MateriasService materiasService;

	@Autowired
	MateriasDAO materiasDAO;

	@RequestMapping("/materiasTable")
	public String materiasTable() {
		return "catalogoM";
	}

	@RequestMapping("/verMaterias")
	public @ResponseBody List<Materias> verMaterias() {
		Sort sort = Sort.by(Direction.ASC, "ccliente");
		return materiasService.findAll(sort);
	}

	@RequestMapping("/editarMateria")
	public ModelAndView buscar(@RequestParam Integer id) {
		ModelAndView mav = new ModelAndView();
		Materias c = materiasService.findOne(id);
		mav.addObject("materias", c);
		mav.setViewName("FALTA HACER EL HTML DE EDITAR MATERIAS");
		return mav;
	}

	@RequestMapping("/guardarMaterias")
	public ModelAndView guardarMaterias(@ModelAttribute Materias materias) {
		ModelAndView mav = new ModelAndView();
		materiasService.save(materias);
		mav.setViewName("catalogoM");
		mav.addObject("resultado", 1);
		return mav;
	}

}
