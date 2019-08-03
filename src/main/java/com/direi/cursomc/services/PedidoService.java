package com.direi.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.direi.cursomc.domain.Pedido;
import com.direi.cursomc.repositories.PedidoRepository;
import com.direi.cursomc.services.exceptions.NotFoundException;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository repo; 
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(()-> new NotFoundException("Objeto não encontrado!" + id + ", tipo: "+ Pedido.class.getName()));
}
}
