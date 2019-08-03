package com.direi.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.direi.cursomc.domain.Cliente;
import com.direi.cursomc.services.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> listar(@PathVariable Integer id) {
		
		
		Cliente cliente = service.buscar(id);
		
		return ResponseEntity.ok().body(cliente);
		
	}

}
