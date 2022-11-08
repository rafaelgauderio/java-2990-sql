package com.rafaeldeluca.uri2990.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rafaeldeluca.uri2990.entities.Empregado;
import com.rafaeldeluca.uri2990.projections.EmpregadoDeptProjection;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {
	
	
	@Query(nativeQuery= true, value = "SELECT empregados.cpf, empregados.enome, departamentos.dnome "
			+ "FROM empregados "
			+ "INNER JOIN departamentos "
			+ "ON empregados.dnumero = departamentos.dnumero "
			+ "WHERE empregados.cpf NOT IN ( "
			+ "SELECT empregados.cpf "
			+ "FROM empregados "
			+ "INNER JOIN trabalha "
			+ "ON trabalha.cpf_emp = empregados.cpf ) "
			+ "ORDER BY empregados.cpf")
	List<EmpregadoDeptProjection> search01 ();
	
	@Query(nativeQuery= true, value = "SELECT empregados.cpf, empregados.Enome, departamentos.dnome "
			+ "	FROM empregados "
			+ "	INNER JOIN departamentos "
			+ "	ON departamentos.dnumero = empregados.dnumero "
			+ "	LEFT JOIN trabalha ON trabalha.cpf_emp = empregados.cpf "
			+ "	WHERE trabalha.cpf_emp IS NULL "
			+ "	ORDER BY empregados.cpf")
	List<EmpregadoDeptProjection> search02 ();

}
