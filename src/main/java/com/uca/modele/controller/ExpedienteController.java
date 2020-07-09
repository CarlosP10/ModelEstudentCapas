package com.uca.modele.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.modele.domain.Escuelas;
import com.uca.modele.domain.Expediente;
import com.uca.modele.domain.Materias;
import com.uca.modele.domain.Municipio;
import com.uca.modele.service.EscuelasService;
import com.uca.modele.service.ExpedienteService;
import com.uca.modele.service.MateriasxAlumnoService;

@Controller
public class ExpedienteController {
	
	@Autowired
	private ExpedienteService expedienteService;
	@Autowired
	private EscuelasService escuelaService;
	@Autowired
	MateriasxAlumnoService mxAlService;
	
	@RequestMapping("/pantallaInicialExpediente")
	public String pantallaExp() {
		return "expedienteA";
	}
	
	@RequestMapping(value = "/expedientesNombre", method=RequestMethod.POST)
    public ModelAndView getExpedienteNombre(@RequestParam Integer tipo, 
    @RequestParam(required = false) String valor1) throws Exception {
		ModelAndView mav = new ModelAndView();
		List<Expediente> expedientes = null;
		switch (tipo) {
		case 1:
			try {
				expedientes = expedienteService.findByName(valor1);
			} catch (Exception e) {
				 e.printStackTrace();
			}			
			break;
		case 2:
			try {
				expedientes = expedienteService.findByLastName(valor1);
			} catch (Exception e) {
				 e.printStackTrace();
			}			
			break;

		default:
			expedientes = new ArrayList<>();
			mav.setViewName("expedienteA");
			break;
		}
		for (Expediente e1: expedientes) {
			e1.setAprobadas(mxAlService.getAprobadas(e1.getIdExpediente()));
			e1.setReprobadas(mxAlService.getReprobadas(e1.getIdExpediente()));
			e1.setPromedio(mxAlService.getProm(e1.getIdExpediente()));
		}
		mav.addObject("expedientes", expedientes);
		mav.setViewName("expedienteMate");
		return mav;
    }
	
	@RequestMapping("/verExpediente")
	public @ResponseBody List<Expediente> verExpediente() {
		Sort sort = Sort.by(Direction.ASC, "idExpediente");
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
	public ModelAndView guardarExpediente(@Valid @ModelAttribute Expediente expedientes,BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			List<Escuelas> escuelas = null;
			try {
				escuelaService.findAll();
			} catch (Exception e1) {
				 e1.printStackTrace();
			}
			mav.addObject("escuelas", escuelas);
			mav.setViewName("modificarExp");
		} else {
			expedienteService.save(expedientes);
			mav.setViewName("expedienteA");
			mav.addObject("resultado", 1);
		}
			
		return mav;
	}
	
	@RequestMapping("/ingresarExpediente")
	public ModelAndView ingresarExpediente() 
	{
		ModelAndView mav = new ModelAndView();
		Expediente expediente = new Expediente();
		
		mav.addObject("expediente", expediente);
		mav.setViewName("nuevoExp");
		
		return mav;
	}
	
	@RequestMapping("/guardarExpedienteN")
	public ModelAndView save(@Valid @ModelAttribute Expediente expediente, BindingResult result) {
		ModelAndView mav = new ModelAndView();

		if(result.hasErrors()) 
		{
			mav.setViewName("nuevoExp");
		}
		else 
		{
			expedienteService.save(expediente);
			mav.addObject("exitoCategoria", true);
			mav.setViewName("expedienteA");
		}
		
		return mav;
	}
	

}
