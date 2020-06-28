package com.uca.mestudiantes.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.uca.mestudiantes.domain.Expediente;

public interface ExpedienteRepository extends JpaRepository<Expediente, Integer>{
	
	@Query(value = "SELECT * from public.expediente", nativeQuery = true)
    public List<Expediente> findAllCuentas();

	public List<Expediente> findAll(Sort sort);
	

}
