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
import com.example.DIRESA.entity.empleado.Encuesta;

@Repository
public interface EncuestasRepository extends JpaRepository<Encuesta, Long>{
	
	@Query("select c from Encuesta c where c.numeroVisita = :numero_visita")

	Page<Encuesta> findByLikeEncuesta(@Param("numero_visita") String encuestas , Pageable pageable);
	List<Encuesta> findByIdIn( List<Long>id );
	
}
