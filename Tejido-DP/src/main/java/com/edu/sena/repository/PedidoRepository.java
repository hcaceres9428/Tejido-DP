package com.edu.sena.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.edu.sena.models.entity.Pedido;

public interface PedidoRepository extends JpaRepositoryImplementation<Pedido, Integer> {

}
