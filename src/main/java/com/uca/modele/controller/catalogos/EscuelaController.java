package com.uca.modele.controller.catalogos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
import com.uca.modele.dto.TableDTO;
import com.uca.modele.service.EscuelasService;

@Controller
public class EscuelaController {
	
	@Autowired
	EscuelasService escuelasService;

	@Autowired
	EscuelasDAO escuelasDAO;

	@RequestMapping("/escuelasTable")
	public String EscuelasTable() {
		return "catalogoCE";
	}

	@RequestMapping("/verEscuelas")
	public @ResponseBody List<Escuelas> verEscuelas() {
		Sort sort = Sort.by(Direction.ASC, "idEscuela");
		return escuelasService.findAll(sort);
	}

	@RequestMapping("/editarCE")
	public ModelAndView buscar(@RequestParam Integer id) {
		ModelAndView mav = new ModelAndView();
		Escuelas c = escuelasService.findOne(id);
		mav.addObject("escuelas", c);
		mav.setViewName("modificarCE");
		return mav;
	}
	
	@RequestMapping("/cargarCE")
	public @ResponseBody TableDTO cargarCuenta(@RequestParam Integer draw,
			@RequestParam Integer start, @RequestParam Integer length, 
			@RequestParam(value="search[value]", required = false) String search) {
		Page<Escuelas> cuentas = escuelasService.findAll(PageRequest.of(start/length, length, Sort.by(Direction.ASC, "idEscuela")));
		
		List<String[]> data = new ArrayList<>();
		
		for(Escuelas u: cuentas) {
			data.add(new String[] {u.getIdEscuela().toString(), u.getNumeroCod().toString(),
					u.getDescripcion(), u.getEstado() == true ? "Activo" : "Inactivo"});
		}
		
		TableDTO dto = new TableDTO();
		dto.setData(data);
		dto.setDraw(draw);
		dto.setRecordsFiltered(escuelasService.countAll().intValue());
		dto.setRecordsTotal(escuelasService.countAll().intValue());
		return dto;
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
