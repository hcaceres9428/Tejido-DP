package com.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import com.edu.sena.models.entity.Pedido;

public interface PedidoService {

	public Optional<Pedido> findById(Integer id);
	public List<Pedido> findAll();
	public Pedido save(Pedido p);
	public void deleteById(Integer id);
}
