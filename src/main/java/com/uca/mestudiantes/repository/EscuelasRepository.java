package com.uca.mestudiantes.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.uca.mestudiantes.domain.Escuelas;

public interface EscuelasRepository extends JpaRepository<Escuelas, Integer>{
	
	@Query(value = "SELECT * from public.escuelas", nativeQuery = true)
    public List<Escuelas> findAllEscuelas();
	
	@Query(value = "SELECT cu.id_escuela, cu.descripcion, cu.estado from public.escuelas cu", nativeQuery = true)
    public List<Escuelas> findAllCatalogoEscuela();
	
	@Query(value = "SELECT * FROM public.escuelas WHERE id_dpto = ?1", nativeQuery = true)
    public List<Escuelas> findEscuelaByDepartamento(Integer id_dpto);
	
	@Query(value = "SELECT * FROM public.escuelas WHERE id_escuela = ?1", nativeQuery = true)
    public Escuelas findEscuelaById(Integer id_dpto);

	public List<Escuelas> findAll(Sort sort);

}
