package com.uca.modele.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.uca.modele.domain.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer>{
	
	@Query(value = "SELECT * from public.cuenta", nativeQuery = true)
    public List<Cuenta> findAllCuentas();
	
	@Query(value = "SELECT cu.id_cuenta, cu.descripcion, cu.estado from public.cuenta cu", nativeQuery = true)
    public List<Cuenta> findAllCatalogoCuenta();
	
	@Query(value = "SELECT * from public.cuenta where id_cuenta = :cuenta", nativeQuery = true)
    public Cuenta findCuentateById(@Param("cuenta") Integer cuenta);

	public List<Cuenta> findAll(Sort sort);
}
