package com.uca.mestudiantes.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class MainController {

	// VISTA EXPEDIENTE NUEVO
	@RequestMapping("/agregarEN")
	public ModelAndView agregarEN() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("agregarEN");
		return mav;
	}

	// VISTA BUSCAR ALUMNO
	@RequestMapping("/busquedaA")
	public ModelAndView busquedaA() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("busquedaA");
		return mav;
	}

	// VISTA CATALOGO CENTRO ESCOLAR
	@RequestMapping("/catalogoCE")
	public ModelAndView catalogoCE() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("catalogoCE");
		return mav;
	}

	// VISTA CATALOGO MATERIAS
	@RequestMapping("/catalogoM")
	public ModelAndView catalogoM() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("catalogoM");
		return mav;
	}

	// VISTA CATALOGO USUARIOS DEL SISTEMA
	@RequestMapping("/catalogoUS")
	public ModelAndView catalogoUS() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("catalogoUS");
		return mav;
	}

	// VISTA EXPEDIENTE ALUMNO
	@RequestMapping("/expedienteA")
	public ModelAndView expedienteA() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("expedienteA");
		return mav;
	}

	// VISTA LOGIN
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}

	// VISTA MODIFICAR EXPEDIENTE
	@RequestMapping("/modificarExp")
	public ModelAndView modificarExp() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("modificarExp");
		return mav;
	}

	// VISTA REGISTRARSE
	@RequestMapping("/register")
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("register");
		return mav;
	}

}
