package com.uca.mestudiantes.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.uca.mestudiantes.dao.DepartamentoDAO;
import com.uca.mestudiantes.domain.Departamento;

@Repository
public class DepartamentoDAOImpl implements DepartamentoDAO{
	
	@PersistenceContext(unitName = "mestudiantes")
	private EntityManager entityManager;

	@Override
	public List<Departamento> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.departamento");
		Query query = entityManager.createNativeQuery(sb.toString(),Departamento.class);
		List<Departamento> resulset= query.getResultList();		
		return resulset;
	}

	@Override
	public Departamento findOne(Integer code) throws DataAccessException {
		Departamento departamento = entityManager.find(Departamento.class, code);
		return departamento;
	}

}
