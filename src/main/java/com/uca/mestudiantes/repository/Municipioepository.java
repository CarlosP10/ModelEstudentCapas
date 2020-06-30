package com.uca.mestudiantes.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uca.mestudiantes.domain.Municipio;

public interface Municipioepository extends JpaRepository<Municipio, Integer>{
	
	@Query(value = "SELECT * from public.municipio", nativeQuery = true)
    public List<Municipio> findAllMuni();
	
	@Query(value = "SELECT * FROM public.municipio WHERE id_dpto = ?1", nativeQuery = true)
    public List<Municipio> findMuniByIdDpto(Integer id_dpto);

	public List<Municipio> findAll(Sort sort);
}
