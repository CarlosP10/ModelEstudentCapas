package com.uca.modele.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.modele.domain.Cuenta;
import com.uca.modele.service.CuentaService;

@Controller
public class MainController {

	@Autowired
	private CuentaService cuentaService;
	
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		Cuenta cuenta = new Cuenta();
		
		mav.addObject("error", "");
		mav.addObject("cuenta", cuenta);
		mav.setViewName("login");
		
		return mav;
		
	}
	
	@RequestMapping(value="/verificar", method = RequestMethod.POST)
	public @ResponseBody boolean verificar(@RequestBody Cuenta login) {

		try {
			Cuenta user = cuentaService.findOne((login.getId_cuenta()));


			if(user != null){
				String contrasenia = user.getContrasenia();
				if(contrasenia.equals(login.getContrasenia())){
					user.setSesion(true);

					try {
						cuentaService.save(user);
					}catch (Exception e) {
						e.printStackTrace();
					}

					return true;
				}

				return false;

			}else{
				return false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}
