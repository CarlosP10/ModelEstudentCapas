package com.uca.modele.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.modele.domain.Escuelas;
import com.uca.modele.domain.Municipio;
import com.uca.modele.service.DepartamentoService;
import com.uca.modele.service.EscuelasService;
import com.uca.modele.service.MunicipioService;

@Controller
public class CentroEstudioController {
	
	@Autowired
	private MunicipioService municipioService; 
	
	@Autowired
	private DepartamentoService departamentoService; 
	
	@Autowired
	private EscuelasService escuelasService; 
	
	@RequestMapping("/listaEscuelas")
    public ModelAndView listaEscuelas() {
        ModelAndView mav = new ModelAndView();
        Escuelas escuelita = new Escuelas();
        List<Municipio> municipios = null;
        List<Escuelas> escuelitas = null;
        try {
            municipios = municipioService.findAll();
            escuelitas = escuelasService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        mav.addObject("error", "");
        mav.addObject("municipios", municipios);
        mav.addObject("escuelitas", escuelitas);
        mav.addObject("escuelas", escuelita);
        mav.setViewName("catalogoCE");

        return mav;
    }
	
	@RequestMapping("/ingresarEscuela")
    public ModelAndView pantallaIngresarEscuela() {
        ModelAndView mav = new ModelAndView();
        Escuelas escuelita = new Escuelas();
        List<Municipio> municipios = null;
        List<Escuelas> escuelitas = null;
        try {
            municipios = municipioService.findAll();
            escuelitas = escuelasService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        mav.addObject("error", "");
        mav.addObject("municipios", municipios);
        mav.addObject("escuelitas", escuelitas);
        mav.addObject("escuelas", escuelita);
        mav.setViewName("agregarCE");

        return mav;
    }
	
	@RequestMapping("/editarEscuela")
    public ModelAndView PantallaEditarEscuela(@ModelAttribute Escuelas escuelas) {
        ModelAndView mav = new ModelAndView();
        List<Municipio> municipios = municipioService.findAll();
        try {
            escuelas = escuelasService.findOne(escuelas.getcDpto());
            mav.addObject("escuelas", escuelas);

        } catch (Exception e) {
            e.printStackTrace();
        }
        mav.addObject("municipios", municipios);
        mav.setViewName("modificarCE");
        return mav;
    }
	
	
	//PARA CAMBIAR EL ESTADO DE LA ESCUELITA
	 @RequestMapping(value = "/ingresarEscuelaEstado", method = RequestMethod.POST, produces = "application/json")
	    public @ResponseBody boolean IngresarCentroEd(@RequestBody Escuelas escuelas) {
	        boolean estado;
	        try {
	            escuelasService.save(escuelas);
	            estado = true;
	        } catch (Exception e) {
	            System.out.println("malo");
	            estado = false;
	        }
	                return estado;
	    }
	 
	 @RequestMapping(value = "/cambiarEstadoEscuela", method = RequestMethod.POST, produces = "application/json")
	    public @ResponseBody
	    boolean CambiarEscuela(@RequestBody Escuelas escuelas) {

	        try {

	            Escuelas escuelitas = escuelasService.findOne(escuelas.getIdEscuela());


	            escuelitas.setEstado(!escuelitas.getEstado());
	            escuelasService.update(escuelitas);
	            System.out.println("Estado cambiado");
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("Error");
	            return false;
	        }

	    }
	 
	 @RequestMapping(value = "/modificarEscuela", method = RequestMethod.POST)
	    public ModelAndView modificar(@Valid @ModelAttribute Escuelas escuelas, BindingResult result) {
	        ModelAndView mav = new ModelAndView();
	        List<Municipio> municipios = municipioService.findAll();
	        List<Escuelas> escuelitas = escuelasService.findAll();
	        mav.addObject("municipios", municipios);
	        Escuelas updatear = escuelasService.findOne(escuelas.getIdEscuela());
	        escuelas.setMunicipio(municipioService.findOne(escuelas.getcDpto()));
	        escuelas.setEstado(updatear.getEstado());

	        if(result.hasErrors()){
	            //mav.addObject("escuelas", escuelas);
	            mav.setViewName("modificarCE");
	            return mav;
	        }
	        Escuelas escuela = new Escuelas();
	        try {

	            escuelasService.save(escuelas);
	            mav.setViewName("catalogoCE");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        mav.addObject("error", "");

	        mav.addObject("escuelas", escuelas);
	        mav.addObject("escuelitas", escuelitas);

	        return mav;
	    }
	
	

}
