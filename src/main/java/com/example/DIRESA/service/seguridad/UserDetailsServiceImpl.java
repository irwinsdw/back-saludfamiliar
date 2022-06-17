package com.example.DIRESA.service.seguridad;
import static java.util.Objects.*;
import static java.util.Collections.emptyList;

import org.springframework.beans.factory.annotation.Autowired;

 

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import com.example.DIRESA.entity.seguridad.UsuarioEntity;
import com.example.DIRESA.repository.seguridad.UsuarioRepository;



@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UsuarioEntity usuarioEntity= this.usuarioRepository.findByUsuario(username);
		
		if (isNull(usuarioEntity)) {
			throw new UsernameNotFoundException("Usuario no existe");
		}
		
		return new UserDetailsImpl(usuarioEntity);
		
		//return new User(usuarioEntity.getUsuario(),usuarioEntity.getClave(),emptyList());
	}

} 
