package com.uca.mestudiantes.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uca.mestudiantes.domain.MateriasxAlumno;

public interface MateriasxAlumnoRepository extends JpaRepository<MateriasxAlumno, Integer>{
	
	@Query(value = "SELECT * from public.materiaxalumno", nativeQuery = true)
    public List<MateriasxAlumno> findAllMateriasxAlumno();
	
	@Query(value = "SELECT * FROM public.materiaxalumno WHERE id_materia = ?1", nativeQuery = true)
    public List<MateriasxAlumno> findMateriasxAlumnoByIdMateria(Integer id_materia);
	
	@Query(value = "SELECT * FROM public.materiaxalumno WHERE id_expediente = ?1", nativeQuery = true)
    public MateriasxAlumno findMateriasxAlumnoByIdExpediente(Integer id_expediente);
	
	@Query(value = "SELECT * FROM public.materiaxalumno WHERE id_ciclo = ?1", nativeQuery = true)
    public List<MateriasxAlumno> findMateriasxAlumnoByIdCiclo(Integer id_ciclo);

	public List<MateriasxAlumno> findAll(Sort sort);

}
