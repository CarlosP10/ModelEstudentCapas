package com.uca.mestudiantes.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uca.mestudiantes.domain.Materias;

public interface MateriasRepository extends JpaRepository<Materias, Integer>{
	
	@Query(value = "SELECT * from public.materias", nativeQuery = true)
    public List<Materias> findAllCuentas();
	
	@Query(value = "SELECT cu.id_materia, cu.descripcion, cu.estado from public.materias cu", nativeQuery = true)
    public List<Materias> findAllCatalogoMateria();
	
	@Query(value = "SELECT * FROM public.materias WHERE id_materia = ?1", nativeQuery = true)
    public List<Materias> findMateriaById(Integer id_materia);

	public List<Materias> findAll(Sort sort);

}
