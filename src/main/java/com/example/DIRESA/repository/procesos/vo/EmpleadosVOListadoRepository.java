package com.example.DIRESA.repository.procesos.vo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.DIRESA.entity.empleado.Empleado;
import com.example.DIRESA.entity.empleado.vo.EmpleadoVOListado;


@Repository
public interface EmpleadosVOListadoRepository extends JpaRepository<EmpleadoVOListado, Long>{
	@Query("select e from empleadoVoListado  e where UPPER(e.PERSONASFAM) like UPPER(:PERSONASFAM)")
	Page<EmpleadoVOListado>FindbylikeFamilia(@Param("PERSONASFAM") String PERSONASFAM, Pageable pageable);
	
	@Query("select e from empleadoVoListado e")
	Page<EmpleadoVOListado>findAllCustom(Pageable pageable);
}
