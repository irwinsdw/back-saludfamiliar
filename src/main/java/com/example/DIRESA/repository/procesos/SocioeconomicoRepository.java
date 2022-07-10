package com.example.DIRESA.repository.procesos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.DIRESA.entity.empleado.Empleado;
import com.example.DIRESA.entity.empleado.FamiliaItem;
import com.example.DIRESA.entity.empleado.Provincia;


import com.example.DIRESA.entity.empleado.Item;

import com.example.DIRESA.entity.empleado.Caracteristica;

@Repository
public interface SocioeconomicoRepository extends JpaRepository<Caracteristica, Long>{

	@Query("FROM Caracteristica ")
	List<Caracteristica> listarCaracteristicas();
	@Query("FROM Item ")
	List<Item> listaritem();
	
}

