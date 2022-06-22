package com.example.DIRESA.repository.procesos;


import com.example.DIRESA.entity.empleado.Microred;
import com.example.DIRESA.entity.empleado.Provincia;
import com.example.DIRESA.entity.empleado.RedSalud;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.DIRESA.entity.empleado.Establecimiento;

import java.util.List;

@Repository
public interface EstablecimientoRepository extends JpaRepository<Establecimiento, Long> {
	
	
	@Query("select e from Establecimiento  e where UPPER(e.nombre) like UPPER(:nombreEstablecimiento)")
	Page<Establecimiento>FindbylikeEstable(@Param("nombreEstablecimiento") String nombreEstablecimiento, Pageable pageable);

	@Query("select e from Establecimiento e")
	Page<Establecimiento>findAllCustom(Pageable pageable);

	@Query("FROM RedSalud")
	List<RedSalud> listarRedesSalud();

	@Query("FROM Provincia ")
	List<Provincia> listarProvincias();
}
