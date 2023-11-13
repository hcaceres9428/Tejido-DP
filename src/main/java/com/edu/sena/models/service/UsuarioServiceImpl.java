package com.edu.sena.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.sena.models.entity.Usuario;
import com.edu.sena.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario Save(Usuario u) {
		
		return usuarioRepository.save(u);
	}

	@Override
	public String login(String user, String ctr) {
		Usuario usuario= usuarioRepository.findByUsername(user);
		
		if (usuario == null) {
			
			return "Usuario no valido";
		}
		if (!usuario.getPassword().equals(ctr)) {
			return "Contraseña no valida";
		}
		return "Registro Exitoso";
	}

}
