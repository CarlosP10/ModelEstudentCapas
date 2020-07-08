package com.uca.modele.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uca.modele.domain.MateriasxAlumno;

public interface MateriasxAlumnoRepository extends JpaRepository<MateriasxAlumno, Integer>{
	
	@Query(value = "SELECT * from public.materiaxalumno", nativeQuery = true)
    public List<MateriasxAlumno> findAllMateriasxAlumno();
	
	@Query(value = "SELECT * FROM public.materiaxalumno WHERE id_materia = ?1", nativeQuery = true)
    public List<MateriasxAlumno> findMateriasxAlumnoByIdMateria(Integer id_materia);
	
	@Query(value = "SELECT * FROM public.materiaxalumno WHERE id_expediente = ?1", nativeQuery = true)
    public List<MateriasxAlumno> findMateriasxAlumnoByIdExpediente(Integer id_expediente);
	
	@Query(value = "SELECT * FROM public.materiaxalumno WHERE id_ciclo = ?1", nativeQuery = true)
    public List<MateriasxAlumno> findMateriasxAlumnoByIdCiclo(Integer id_ciclo);

	@Query(value = "select count(id_materia) from public.materiaxalumno where nota >=6 and id_expediente = ?1", nativeQuery = true)
	public Integer getAprobadas(Integer id) throws DataAccessException;
	
	@Query(value = "select count(id_materia) from public.materiaxalumno where nota <6 and id_expediente = ?1", nativeQuery = true)
	public Integer getReprobadas(Integer id) throws DataAccessException;
	
	@Query(value = "select avg(nota) from public.materiaxalumno where id_expediente = ?1", nativeQuery = true)
	public Float getPromedio(Integer id) throws DataAccessException;
	
	public List<MateriasxAlumno> findAll(Sort sort);	

}
