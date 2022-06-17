package com.example.DIRESA.repository.procesos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.DIRESA.entity.empleado.Empleado;





@Repository
public interface EmpleadosRepository extends JpaRepository<Empleado, Long>{
	@Query("select c from Empleado c where c.dni = :dni")
	Optional<Empleado> findByDniempleado(@Param("dni") String dniempleado); 
	//@Query("select e from Empleado e where e.estado='1'")
	@Query("select e from Empleado e where e.dni = :dni ")
	Page<Empleado>findAllCustom(Pageable pageable);
	
	List<Empleado> findByIdIn( List<Long>id );
	
}
