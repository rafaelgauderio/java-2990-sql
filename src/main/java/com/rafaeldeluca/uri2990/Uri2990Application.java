package com.rafaeldeluca.uri2990;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rafaeldeluca.uri2990.dto.EmpregadoDeptDTO;
import com.rafaeldeluca.uri2990.projections.EmpregadoDeptProjection;
import com.rafaeldeluca.uri2990.repositories.EmpregadoRepository;

@SpringBootApplication
public class Uri2990Application implements CommandLineRunner {

	@Autowired
	private EmpregadoRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2990Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<EmpregadoDeptProjection> list01 = repository.search01();
		List<EmpregadoDeptDTO> resultDto01 = list01.stream().map(x -> new EmpregadoDeptDTO(x)).collect(Collectors.toList());
		
		System.out.println("\nConsulta SQL Raiz\n"
				+ "Consulta com Subconsulta\n");
		for(EmpregadoDeptDTO nickname : resultDto01) {
			System.out.println(nickname);
		}
		
		List<EmpregadoDeptProjection> list02 = repository.search02();
		List<EmpregadoDeptDTO> resultDto02 = list02.stream().map(x -> new EmpregadoDeptDTO(x)).collect(Collectors.toList());
		
		System.out.println("\nConsulta usando LEFT JOIN\n");
		for(EmpregadoDeptDTO nickname : resultDto02) {
			System.out.println(nickname);
		}
		
		List<EmpregadoDeptDTO> result03 = repository.search03();
		
		
		System.out.println("\nConsulta usando JPQL\n");
		for(EmpregadoDeptDTO nickname : result03) {
			System.out.println(nickname);
		}
		
	}
}
