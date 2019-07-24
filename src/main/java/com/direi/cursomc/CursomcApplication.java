package com.direi.cursomc;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.direi.cursomc.domain.Categoria;
import com.direi.cursomc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Escritório");
		Categoria cat2 = new Categoria(null,"Informática");
		Categoria cat3 = new Categoria(null,"Cozinha");
		
		repo.saveAll(Arrays.asList(cat1,cat2,cat3));
		
	}

}