package com.uca.modele.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.uca.modele.domain.Expediente;

public interface ExpedienteRepository extends JpaRepository<Expediente, Integer>{
	
	@Query(value = "SELECT * from public.expediente", nativeQuery = true)
    public List<Expediente> findAllExpedientes();

	public List<Expediente> findAll(Sort sort);
	
	@Query(nativeQuery=true, value="SELECT * FROM public.expediente WHERE nombres = ?1")
	public List<Expediente> mostrarPorNombre(String cadena) throws DataAccessException;
	
	@Query(nativeQuery=true, value="SELECT * FROM public.expediente WHERE apellidos = ?1")
	public List<Expediente> mostrarPorApellido(String cadena) throws DataAccessException;
	
	@Query(nativeQuery=true, value="SELECT * FROM public.expediente WHERE nombres = ?1 and apellidos = ?2")
	public List<Expediente> mostrarPorNombreyApellido(String nombre, String apellido) throws DataAccessException;
	
	@Query(nativeQuery=true, value="SELECT * FROM public.expediente WHERE id_expediente = ?1")
	public Expediente findByIdExp(Integer codigo) throws DataAccessException;


}
