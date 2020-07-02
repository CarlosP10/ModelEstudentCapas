package com.uca.modele.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uca.modele.domain.Cuenta;
import com.uca.modele.domain.Escuelas;
import com.uca.modele.domain.Materias;
import com.uca.modele.service.CuentaService;
import com.uca.modele.service.EscuelasService;
import com.uca.modele.service.MateriasService;

@Controller
public class AdminController {
	
	@Autowired
	EscuelasService escuelasService;
	@Autowired
	MateriasService materiasService;
	@Autowired
	CuentaService cuentaService;
	
	@RequestMapping("/verCatalogoEscuela")
	public @ResponseBody List<Escuelas> verEscuelas(){
		Sort sort = Sort.by(Direction.ASC, "id_escuela");
		return escuelasService.findAll(sort);
	}
	
	@RequestMapping("verCatalogoMateria")
	public @ResponseBody List<Materias> verMaterias(){
		Sort sort = Sort.by(Direction.ASC, "id_materia");
		return materiasService.findAll(sort);
	}
	
	@RequestMapping("verCatalogoCuenta")
	public @ResponseBody List<Cuenta> verCuentas(){
		Sort sort = Sort.by(Direction.ASC, "id_cuenta");
		return cuentaService.findAll(sort);
	}

}
