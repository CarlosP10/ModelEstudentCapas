package com.uca.mestudiantes.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.uca.mestudiantes.dao.TipoUsuarioDAO;
import com.uca.mestudiantes.domain.TipoUsuario;

@Repository
public class TipoUsuarioDAOImpl implements TipoUsuarioDAO{

	@PersistenceContext(unitName = "mestudiantes")
	private EntityManager entityManager;

	@Override
	public List<TipoUsuario> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.tipo_usuario");
		Query query = entityManager.createNativeQuery(sb.toString(),TipoUsuario.class);
		List<TipoUsuario> resulset= query.getResultList();
		
		return resulset;
	}

	@Override
	public TipoUsuario findOne(Integer code) throws DataAccessException {
		TipoUsuario tipoUsuario = entityManager.find(TipoUsuario.class, code);
		return tipoUsuario;
	}

}
