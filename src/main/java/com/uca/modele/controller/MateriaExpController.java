package com.uca.modele.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.modele.domain.Ciclo;
import com.uca.modele.domain.Expediente;
import com.uca.modele.domain.Materias;
import com.uca.modele.domain.MateriasxAlumno;
import com.uca.modele.dto.TableDTO;
import com.uca.modele.service.CicloService;
import com.uca.modele.service.ExpedienteService;
import com.uca.modele.service.MateriasService;
import com.uca.modele.service.MateriasxAlumnoService;

@Controller
public class MateriaExpController {
	
	@Autowired
	MateriasService materiasService;
	
	@Autowired
	CicloService cicloService;
	
	@Autowired
	ExpedienteService expedienteService;
	
	@Autowired
	MateriasxAlumnoService materiasxAlumnoService;
	
	@RequestMapping("/materiasExp")
	public ModelAndView MateriaExpTable(@RequestParam Integer id) {
		ModelAndView mav = new ModelAndView();
		List<MateriasxAlumno> c = materiasxAlumnoService.findAllMatbyIdExp(id);
		for (MateriasxAlumno m : c) {
			System.out.print(id + "aca no es!");
		}
		mav.addObject("expedientes", c);
		mav.addObject("idExp", id);
		mav.setViewName("materiaExp");
		return mav;
	}
	
	@RequestMapping("/expedienteMate")
	public String ExpMatTable() {
		return "expedienteMate";
	}
	
	//editar materia existente para equis estudiante
	@RequestMapping("/editarMExp")
	public ModelAndView buscar(@RequestParam Integer id) {
		ModelAndView mav = new ModelAndView();
		MateriasxAlumno mxAlumno = materiasxAlumnoService.findOne(id);
		List<Ciclo> ciclos = null;
		List<Materias> materias = null;
		try {
			ciclos = cicloService.findAll();
			materias = materiasService.findAll();
		} catch (Exception e) {
			 e.printStackTrace();
		}
		System.out.println(id);
		mav.addObject("materias", materias);
		mav.addObject("ciclos", ciclos);
		mav.addObject("mxAlumno", mxAlumno);
		mav.addObject("idMateriaexp", id);
		mav.setViewName("modificarMatExp");
		return mav;
	}
	
	
	//agregar nueva materia para ese mismo expediente
	@RequestMapping("/nuevaMExp")
	public ModelAndView nuevaMExp(@RequestParam Integer idExp) {
		ModelAndView mav = new ModelAndView();
		MateriasxAlumno mxAlumnos = materiasxAlumnoService.findOne(idExp);
		List<Ciclo> ciclos = null;
		List<Materias> materias = null;
		try {
			ciclos = cicloService.findAll();
			materias = materiasService.findAll();
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
		mav.addObject("materias", materias);
		mav.addObject("ciclos", ciclos);
		mav.addObject("mxAlumno", mxAlumnos);
		mav.setViewName("nuevoMatExp");
		return mav;
	}
	
	@RequestMapping("/cargarMExp")
	public @ResponseBody TableDTO cargarMExp(@RequestParam Integer draw,
			@RequestParam Integer start, @RequestParam Integer length, 
			@RequestParam(value="search[value]", required = false) String search, @RequestParam Integer id) {
		List<MateriasxAlumno> mxAlum = materiasxAlumnoService.findAllMatbyIdExp(id);
		
		List<String[]> data = new ArrayList<>();
		
		for(MateriasxAlumno u: mxAlum) {
			data.add(new String[] {u.getIdMateriaexp().toString(), u.getMateria().getNombre(),
					u.getAnio().toString(), u.getCiclo().getCiclo(),u.getNota().toString(),u.getNota() >= 6 ? "Aprobada" : "Reprobada"});
		}
		
		TableDTO dto = new TableDTO();
		dto.setData(data);
		dto.setDraw(draw);
		dto.setRecordsFiltered(materiasxAlumnoService.countAll().intValue());
		dto.setRecordsTotal(materiasxAlumnoService.countAll().intValue());
		return dto;
	}
	
	@RequestMapping("/cargarExpMat")
	public @ResponseBody TableDTO cargarExpMat(@RequestParam Integer draw) {
		List<Expediente> mxAlum = expedienteService.findAll();
		
		List<String[]> data = new ArrayList<>();
		
		for(Expediente u: mxAlum) {
			data.add(new String[] {u.getIdExpediente().toString(), u.getNombres(),u.getApellidos(),
					u.getAprobadas().toString(), 
					u.getReprobadas().toString(),
					u.getPromedio().toString()});
		}
		
		TableDTO dto = new TableDTO();
		dto.setData(data);
		dto.setDraw(draw);
		dto.setRecordsFiltered(materiasxAlumnoService.countAll().intValue());
		dto.setRecordsTotal(materiasxAlumnoService.countAll().intValue());
		return dto;
	}
	
	//guardar para la materia editada
	@RequestMapping("/guardarMExp")
	public ModelAndView guardarMExp(@Valid @ModelAttribute MateriasxAlumno mxAlumno,BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			List<Ciclo> ciclos = null;
			List<Materias> materias = null;
			try {
				ciclos = cicloService.findAll();
				materias = materiasService.findAll();
			} catch (Exception e) {
				 e.printStackTrace();
			}
			mav.addObject("materias", materias);
			mav.addObject("ciclos", ciclos);
			mav.setViewName("modificarMatExp");
		}else {
			materiasxAlumnoService.save(mxAlumno);
			mav.setViewName("expedienteA");
			mav.addObject("resultado", 1);			
		}
		return mav;
	}
	
	
	//guardar  para la materia nueva que se acaba de crear para el estudiante
	@RequestMapping("/guardarMExpN")
	public ModelAndView guardarMExpN(@Valid @ModelAttribute MateriasxAlumno id,BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			List<Ciclo> ciclos = null;
			List<Materias> materias = null;
			try {
				ciclos = cicloService.findAll();
				materias = materiasService.findAll();
			} catch (Exception e) {
				 e.printStackTrace();
			}
			mav.addObject("materias", materias);
			mav.addObject("ciclos", ciclos);
			mav.setViewName("nuevoMatExp");
		}else {
			materiasxAlumnoService.save(id);
			mav.setViewName("expedienteA");
			mav.addObject("resultado", 1);			
		}
		return mav;
	}

}
