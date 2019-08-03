package com.direi.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.direi.cursomc.domain.Cliente;
import com.direi.cursomc.repositories.ClienteRepository;
import com.direi.cursomc.services.exceptions.NotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo; 
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(()-> new NotFoundException("Objeto não encontrado!" + id + ", tipo: "+ Cliente.class.getName()));
}
}
