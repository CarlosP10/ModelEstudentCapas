package com.uca.modele.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.modele.domain.Cuenta;
import com.uca.modele.service.CuentaService;

@Controller
public class MainController {

	@Autowired
	CuentaService cuentaService; 
	
	@RequestMapping("/index")
	public String pantallaMain() {
		return "login2";
	}
	
	
	//iniciar sesion
	@RequestMapping("/index2")
	public ModelAndView index2(@RequestParam String nombreusuario,@RequestParam String contrasenia)throws Exception {
		ModelAndView mav = new ModelAndView();
		Cuenta c = cuentaService.login(nombreusuario, contrasenia);
		mav.addObject("cuenta", c);
		if (c.getIdTipo().getIdTipo() == 1) {
			mav.setViewName("redirect:/indexAdmin");
		} else {
			mav.setViewName("redirect:/indexCoordi");
		}
		return mav;
	};
	
	//cerrar sesion de usuario
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession request) {
		ModelAndView mav = new ModelAndView();
		Cuenta cuentas = null;
		try {
			cuentas = (Cuenta) request.getAttribute("nombre_usuario");
			cuentas.setSesion(false);
			cuentaService.save(cuentas);
			request.removeAttribute("nombre_usuario");
			mav.setViewName("redirect:/index");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	
	//para validar la sesion del admin 
	public ModelAndView sesionAdmin(HttpSession request, ModelAndView mav) {
		Cuenta user = null;
		user = (Cuenta) request.getAttribute("user");
		if (user != null) {
			if (user.getIdTipo().getIdTipo() == 1) {
				mav.clear();
				mav.setViewName("redirect:/indexAdmin");
			}
		} else {
			mav.clear();
			mav.setViewName("redirect:/index");
		}
		return mav;
	}
	
	//validar sesion del coordi 
	public ModelAndView sesionCoordinador(HttpSession request, ModelAndView mav) {
		Cuenta user = null;
		user = (Cuenta) request.getAttribute("user");
		if (user != null) {
			if (user.getIdTipo().getIdTipo() == 2) {
				mav.clear();
				mav.setViewName("redirect:/indexCoordi");
			}
		} else {
			mav.clear();
			mav.setViewName("redirect:/index");
		}
		return mav;
	}

}
