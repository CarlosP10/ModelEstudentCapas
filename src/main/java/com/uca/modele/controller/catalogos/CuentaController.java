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
import com.uca.modele.domain.Cuenta;
import com.uca.modele.dto.TableDTO;
import com.uca.modele.service.CuentaService;

@Controller
public class CuentaController {
	
	@Autowired
	CuentaService cuentaService;
	
	@RequestMapping("/cuentaTable")
	public String CuentaTable() {
		return "catalogoUS";
	}
	
	@RequestMapping("/editarUS")
	public ModelAndView buscar(@RequestParam Integer id) {
		ModelAndView mav = new ModelAndView();
		Cuenta c = cuentaService.findOne(id);
		mav.addObject("cuenta", c);
		mav.setViewName("editCatalogoUS");
		return mav;
	}
	

	@RequestMapping("/verCuenta")
	public @ResponseBody List<Cuenta> verCuenta() {
		Sort sort = Sort.by(Direction.ASC, "id_cuenta");
		return cuentaService.findAll(sort);
	}
	
	@RequestMapping("/cargarUS")
	public @ResponseBody TableDTO cargarCuenta(@RequestParam Integer draw,
			@RequestParam Integer start, @RequestParam Integer length, 
			@RequestParam(value="search[value]", required = false) String search) {
		Page<Cuenta> cuentas = cuentaService.findAll(PageRequest.of(start/length, length, Sort.by(Direction.ASC, "id_cuenta")));
		
		List<String[]> data = new ArrayList<>();
		
		for(Cuenta u: cuentas) {
			data.add(new String[] {u.getId_cuenta().toString(),
					u.getDescripcion(), u.getEstado() == true ? "Activo" : "Inactivo"});
		}
		
		TableDTO dto = new TableDTO();
		dto.setData(data);
		dto.setDraw(draw);
		dto.setRecordsFiltered(cuentaService.countAll().intValue());
		dto.setRecordsTotal(cuentaService.countAll().intValue());
		return dto;
	}

	@RequestMapping("/guardarCuenta")
	public ModelAndView guardarCuenta(@ModelAttribute Cuenta cuenta) {
		ModelAndView mav = new ModelAndView();
		cuentaService.save(cuenta);
		mav.setViewName("catalogoUS");
		mav.addObject("resultado", 1);
		return mav;
	}


}
