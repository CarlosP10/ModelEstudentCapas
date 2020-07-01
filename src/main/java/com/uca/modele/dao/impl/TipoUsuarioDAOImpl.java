package com.uca.modele.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.uca.modele.dao.TipoUsuarioDAO;
import com.uca.modele.domain.TipoUsuario;

@Repository
public class TipoUsuarioDAOImpl implements TipoUsuarioDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private static final String sql = "UPDATE public.tipo_usuario SET nombre = ?";


	@PersistenceContext(unitName = "modele")
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

	@Override
	public void insertar(TipoUsuario c) throws DataAccessException {
		if(c.getId_tipo() == null) { 
			entityManager.persist(c);
		}
		else { 
			entityManager.merge(c); 
		}
		
	}

	@Override
	public void save(TipoUsuario c) throws DataAccessException {
		if(c.getId_tipo() == null) { 
			entityManager.persist(c); 
		}
		else { 
			entityManager.merge(c); 
		}
		
	}

	@Override
	public void updateTipoUsuario(TipoUsuario c) {
		Object[] parametros = new Object[] {c.getNombre()};
		jdbcTemplate.update(sql, parametros);
		
	}

}
