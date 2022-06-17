package com.example.DIRESA.repository.seguridad;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DIRESA.entity.seguridad.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{
	UsuarioEntity findByUsuario(String usuario);
}
