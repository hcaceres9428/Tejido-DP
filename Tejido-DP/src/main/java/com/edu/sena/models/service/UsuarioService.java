package com.edu.sena.models.service;

import com.edu.sena.models.entity.Usuario;

public interface UsuarioService {

	public Usuario Save(Usuario u);
	public String login(String user, String ctr);
}
