package com.uca.modele.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.uca.modele.domain.Departamento;

public interface DepertamentoRepository extends JpaRepository<Departamento, Integer>{
	
	@Query(value = "SELECT * from public.departamento", nativeQuery = true)
    public List<Departamento> findAllDptos();

	public List<Departamento> findAll(Sort sort);
	

}
