package com.direi.cursomc.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.direi.cursomc.domain.Categoria;
import com.direi.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Categoria listar(@PathVariable Integer id) {
		
		
		Categoria cat1 = service.buscar(id);
		
		return cat1;
		
	}

}
