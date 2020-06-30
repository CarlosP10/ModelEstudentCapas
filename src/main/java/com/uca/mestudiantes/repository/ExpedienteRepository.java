package com.uca.mestudiantes.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.uca.mestudiantes.domain.Expediente;

public interface ExpedienteRepository extends JpaRepository<Expediente, Integer>{
	
	@Query(value = "SELECT * from public.expediente", nativeQuery = true)
    public List<Expediente> findAllExpedientes();

	public List<Expediente> findAll(Sort sort);
	
	@Query(nativeQuery=true, value="SELECT * FROM public.expediente WHERE nombre = ?1")
	public Expediente mostrarPorNombre(String cadena) throws DataAccessException;
	
	@Query(nativeQuery=true, value="SELECT * FROM public.expediente WHERE apellido = ?1")
	public Expediente mostrarPorApellido(String cadena) throws DataAccessException;
	
	@Query(nativeQuery=true, value="SELECT * FROM public.expediente WHERE id_expediente = ?1")
	public Expediente findByIdExp(Integer codigo) throws DataAccessException;
	

}
