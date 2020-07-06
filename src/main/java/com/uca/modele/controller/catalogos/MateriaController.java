package com.uca.modele.controller.catalogos;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import com.uca.modele.dao.MateriasDAO;
import com.uca.modele.domain.Materias;
import com.uca.modele.dto.TableDTO;
import com.uca.modele.service.MateriasService;

@Controller
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
		Sort sort = Sort.by(Direction.ASC, "idMateria");
		return materiasService.findAll(sort);
	}

	@RequestMapping("/editarMaterias")
	public ModelAndView buscar(@RequestParam Integer id) {
		ModelAndView mav = new ModelAndView();
		Materias c = materiasService.findOne(id);
		mav.addObject("materias", c);
		mav.setViewName("modificarMateria");
		return mav;
	}
	
	@RequestMapping("/nuevoM")
	public ModelAndView nuevoM() {
		ModelAndView mav = new ModelAndView();
		Materias c = new Materias();
		mav.addObject("materias", c);
		mav.setViewName("nuevaMateria");
		return mav;
	}
	
	@RequestMapping("/cargarMaterias")
	public @ResponseBody TableDTO cargarCuenta(@RequestParam Integer draw,
			@RequestParam Integer start, @RequestParam Integer length, 
			@RequestParam(value="search[value]", required = false) String search) {
		Page<Materias> cuentas = materiasService.findAll(PageRequest.of(start/length, length, Sort.by(Direction.ASC, "idMateria")));
		
		List<String[]> data = new ArrayList<>();
		
		for(Materias u: cuentas) {
			data.add(new String[] {u.getIdMateria().toString(), u.getIdMateria().toString(),
					u.getDescripcion(), u.getEstado() == true ? "Activo" : "Inactivo"});
		}
		
		TableDTO dto = new TableDTO();
		dto.setData(data);
		dto.setDraw(draw);
		dto.setRecordsFiltered(materiasService.countAll().intValue());
		dto.setRecordsTotal(materiasService.countAll().intValue());
		return dto;
	}
	
	@RequestMapping("/guardarMateriasn")
	public ModelAndView guardarMateriasn(@Valid @ModelAttribute Materias materias,BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			mav.setViewName("nuevaMateria");		
//			mav.setViewName("modificarMateria");
		} else {
			materiasService.save(materias);
			mav.setViewName("catalogoM");
			mav.addObject("resultado", 1);			
		}
		return mav;
	}

}
