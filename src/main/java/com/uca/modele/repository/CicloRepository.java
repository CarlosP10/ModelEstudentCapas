package com.uca.modele.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.uca.modele.domain.Ciclo;

public interface CicloRepository extends JpaRepository<Ciclo, Integer>{

	@Query(value = "SELECT * from public.ciclo", nativeQuery = true)
    public List<Ciclo> findAllCiclos();
	
}
