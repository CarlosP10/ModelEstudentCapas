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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.modele.domain.Cuenta;
import com.uca.modele.service.CuentaService;

@Controller
public class MainController {

//	@RequestMapping("/login")
	//public ModelAndView indexLaboratorio8() {
		//ModelAndView mav = new ModelAndView();
		//mav.setViewName("login");
	//	return mav;
	//}

	@Autowired
	CuentaService cuentaService; 
	
	//mostrar pantalla inicial de login
	@RequestMapping("/index")
	public ModelAndView index(HttpSession request) {
		ModelAndView mav = new ModelAndView();
		Cuenta user = null;
		if (request.getAttribute("user") != null) {
			user = (Cuenta) request.getAttribute("user");
			if (user.getIdTipo().getIdTipo() == 1) {
				mav.setViewName("redirect:/indexAdmin");
			} else {
				mav.setViewName("redirect:/indexCoordi");
			}
		} else {
			mav.setViewName("/login");
		}
		return mav;
	}
	
	
	//serrar sesion de usuario
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession request) {
		ModelAndView mav = new ModelAndView();
		Cuenta user = null;
		try {
			user = (Cuenta) request.getAttribute("user");
			user.setSesion(false);
			cuentaService.save(user);
			request.removeAttribute("user");
			mav.setViewName("redirect:/index");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	
	//iniciar sesion 
	@RequestMapping("/iniciarSesion")
	public ModelAndView iniciarSesion(@Valid @ModelAttribute Cuenta cuenta, BindingResult result, HttpSession request) {
		ModelAndView mav = new ModelAndView();
		Cuenta user = null;
		try {
			user = cuentaService.login(cuenta.getNombreUsuario(), cuenta.getContrasenia());
			if (user == null) {
				mav.setViewName("index");
				mav.addObject("mensaje", "Su usuario y/o contraseña son incorrectos!");
			} else {
				if (user.getEstado() == true) {
					if (user.getSesion() == false) {
						if (user.getIdTipo().getIdTipo() == 1) {
							mav.setViewName("redirect:/indexAdmin");
						} else {
							mav.setViewName("redirect:/indexCoordi");
						}
						user.setSesion(true);
						cuentaService.save(user);
						request.setAttribute("user", user);
					} else {
						mav.setViewName("index");
						mav.addObject("mensaje", "Su sesión ya esta activa!");
					}
				} else {
					mav.setViewName("index");
					mav.addObject("mensaje", "Su cuenta no ha sido activada!");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	
	//para validar la sesion del admin (aun no se implemento)
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
	
	//validar sesion del coordi (aun no se implemento)
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
