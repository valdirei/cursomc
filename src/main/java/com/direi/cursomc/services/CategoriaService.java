package com.direi.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.direi.cursomc.domain.Categoria;
import com.direi.cursomc.repositories.CategoriaRepository;
import com.direi.cursomc.services.exceptions.NotFoundException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo; 
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(()-> new NotFoundException("Objeto não encontrado!" + id + ", tipo: "+ Categoria.class.getName()));
}
}
