package com.example.DIRESA.repository.procesos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.DIRESA.entity.empleado.Caracteristica;
import com.example.DIRESA.entity.empleado.FamiliaItem;
import com.example.DIRESA.entity.empleado.FamiliaItemUpk;
import com.example.DIRESA.entity.general.Familia;

@Repository
public interface FamiliaItemRepository extends JpaRepository<FamiliaItem, FamiliaItemUpk>{
	
	
	List<FamiliaItem> findByFamiliaItemUpkFamiliaId(Long familiaId);
	
	

	
}
