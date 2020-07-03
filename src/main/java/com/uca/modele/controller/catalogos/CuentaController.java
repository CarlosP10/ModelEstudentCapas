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

import com.uca.modele.dao.CuentaDAO;
import com.uca.modele.domain.Cuenta;
import com.uca.modele.service.CuentaService;

@Controller
public class CuentaController {
	
	@Autowired
	CuentaService cuentaService;

	@Autowired
	CuentaDAO cuentaDAO;

	@RequestMapping("/CuentaTable")
	public String CuentaTable() {
		return "catalogoUS";
	}

	@RequestMapping("/verCuenta")
	public @ResponseBody List<Cuenta> verCuenta() {
		Sort sort = Sort.by(Direction.ASC, "id_cuenta");
		return cuentaService.findAll(sort);
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
