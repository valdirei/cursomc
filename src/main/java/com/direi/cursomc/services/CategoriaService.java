package com.direi.cursomc.services;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.direi.cursomc.domain.Categoria;
import com.direi.cursomc.domain.dto.CategoriaDTO;
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
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	public Categoria atualizar(Categoria obj) {
		buscar(obj.getId());
		return repo.save(obj);
	}
	
	public List<Categoria> buscarTodos() {
	
		return repo.findAll();
	}
	
	public Page<Categoria> findPage(Integer page, Integer linesPage, String orderBy,String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPage, Direction.valueOf(direction),	orderBy);
		return repo.findAll(pageRequest);

	}
	
	public Categoria fromDTO(CategoriaDTO categoriaDTO) {
		return new Categoria(categoriaDTO.getId(),categoriaDTO.getNome());
	}
}
