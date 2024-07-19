package com.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.sena.models.entity.Pedido;
import com.edu.sena.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService{

	@Autowired
	PedidoRepository pedidoRepository;
	
	@Override
	public Optional<Pedido> findById(Integer id) {
		return pedidoRepository.findById(id);
	}

	@Override
	public List<Pedido> findAll() {
		return pedidoRepository.findAll();
	}

	@Override
	public Pedido save(Pedido p) {
		return pedidoRepository.save(p);
	}

	@Override
	public void deleteById(Integer id) {
		pedidoRepository.deleteById(id);
		
	}

}
