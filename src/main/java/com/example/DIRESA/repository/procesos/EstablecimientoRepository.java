package com.example.DIRESA.repository.procesos;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.DIRESA.entity.empleado.Establecimiento;
@Repository
public interface EstablecimientoRepository extends JpaRepository<Establecimiento, Long> {
	
	
	@Query("select e from Establecimiento  e where UPPER(e.nombre) like UPPER(:nombreEstablecimiento)")
	Page<Establecimiento>FindbylikeEstable(@Param("nombreEstablecimiento") String nombreEstablecimiento, Pageable pageable);

	@Query("select e from Establecimiento e")
Page<Establecimiento>findAllCustom(Pageable pageable);


}
