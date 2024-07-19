package com.edu.sena.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.edu.sena.models.entity.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}

