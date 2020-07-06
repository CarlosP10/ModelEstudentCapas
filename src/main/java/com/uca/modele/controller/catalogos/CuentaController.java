package com.uca.modele.controller.catalogos;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.uca.modele.domain.Cuenta;
import com.uca.modele.domain.Departamento;
import com.uca.modele.domain.Municipio;
import com.uca.modele.domain.TipoUsuario;
import com.uca.modele.dto.TableDTO;
import com.uca.modele.service.CuentaService;
import com.uca.modele.service.DepartamentoService;
import com.uca.modele.service.MunicipioService;
import com.uca.modele.service.TipoUsuarioService;

@Controller
public class CuentaController {
	
	@Autowired
	CuentaService cuentaService;
	
	@Autowired
	MunicipioService muniService;
	
	@Autowired
	DepartamentoService dptoService;
	
	@Autowired
	TipoUsuarioService tipoServide;
	
	@RequestMapping("/cuentaTable")
	public String CuentaTable() {
		return "catalogoUS";
	}
	
	@RequestMapping("/editarUS")
	public ModelAndView buscar(@RequestParam Integer id) {
		ModelAndView mav = new ModelAndView();
		Cuenta c = cuentaService.findOne(id);
		List<Municipio> municipios = null;
		List<Departamento> dptos = null;
		List<TipoUsuario> tipo = null;
		try {
			dptos = dptoService.findAll();
			municipios = muniService.findAll();
			tipo = tipoServide.findAll();
		} catch (Exception e) {
			 e.printStackTrace();
		}		
		mav.addObject("dptos", dptos);
		mav.addObject("municipios", municipios);
		mav.addObject("tipoc", tipo);
		mav.addObject("cuenta", c);
		mav.setViewName("modificarCuenta");
		return mav;
	}
	
	@RequestMapping("/nuevoUS")
	public ModelAndView nuevaCuenta() {
		ModelAndView mav = new ModelAndView();
		Cuenta c = new Cuenta();
		List<Municipio> municipios = null;
		List<Departamento> dptos = null;
		List<TipoUsuario> tipo = null;
		try {
			dptos = dptoService.findAll();
			municipios = muniService.findAll();
			tipo = tipoServide.findAll();
		} catch (Exception e) {
			 e.printStackTrace();
		}		
		mav.addObject("dptos", dptos);
		mav.addObject("municipios", municipios);
		mav.addObject("tipoc", tipo);
		mav.addObject("cuenta", c);
		mav.setViewName("nuevaCuenta");
		return mav;
	}
	

	@RequestMapping("/verCuenta")
	public @ResponseBody List<Cuenta> verCuenta() {
		Sort sort = Sort.by(Direction.ASC, "idCuenta");
		return cuentaService.findAll(sort);
	}
	
	@RequestMapping("/cargarUS")
	public @ResponseBody TableDTO cargarCuenta(@RequestParam Integer draw,
			@RequestParam Integer start, @RequestParam Integer length, 
			@RequestParam(value="search[value]", required = false) String search) {
		Page<Cuenta> cuentas = cuentaService.findAll(PageRequest.of(start/length, length, Sort.by(Direction.ASC, "idCuenta")));
		
		List<String[]> data = new ArrayList<>();
		
		for(Cuenta u: cuentas) {
			data.add(new String[] {u.getIdCuenta().toString(), u.getIdCuenta().toString(),
					u.getDescripcion(),u.getEstado() == true ? "Activo" : "Inactivo"});
		}
		
		TableDTO dto = new TableDTO();
		dto.setData(data);
		dto.setDraw(draw);
		dto.setRecordsFiltered(cuentaService.countAll().intValue());
		dto.setRecordsTotal(cuentaService.countAll().intValue());
		return dto;
	}
	
	@RequestMapping("/guardarCuentan")
	public ModelAndView guardarCuentan(@Valid @ModelAttribute Cuenta cuenta,BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			List<Municipio> municipios = null;
			List<Departamento> dptos = null;
			List<TipoUsuario> tipo = null;
			try {
				dptos = dptoService.findAll();
				municipios = muniService.findAll();
				tipo = tipoServide.findAll();
			} catch (Exception e) {
				 e.printStackTrace();
			}		
			mav.addObject("dptos", dptos);
			mav.addObject("municipios", municipios);
			mav.addObject("tipoc", tipo);
//			mav.setViewName("modificarCuenta");
			mav.setViewName("nuevaCuenta");
		}else {
			cuentaService.save(cuenta);
			mav.setViewName("catalogoUS");
			mav.addObject("resultado", 1);
		}		
		return mav;
	}
}
