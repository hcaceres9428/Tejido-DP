package com.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.sena.models.entity.Cliente;
import com.edu.sena.repository.ClienteRepository;

@Service	
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Override
	public Optional<Cliente> findById(Integer id) {
		
		return clienteRepository.findById(id);
	}

	@Override
	public List<Cliente> findAll() {
		
		return clienteRepository.findAll();
	}

	@Override
	public Cliente save(Cliente c) {
		
		return clienteRepository.save(c);
	}

	@Override
	public void deleteById(Integer id) {
		
		clienteRepository.deleteById(id);
	}
	
}
