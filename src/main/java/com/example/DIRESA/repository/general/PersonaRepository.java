package com.example.DIRESA.repository.general;

import com.example.DIRESA.entity.empleado.Clasificacionriesgo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.DIRESA.entity.general.Familia;
import com.example.DIRESA.entity.general.Persona;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
	@Query("select c from Persona c where UPPER(c.nombreCompleto) like UPPER(:persona)")
	Page<Familia> findByLikeFamilia(@Param("persona") String personas , Pageable pageable);  //JPQL

	//Busco a una persona por su DNI
	Optional<Persona> findPersonaByDni(String dni);

	@Query("FROM Clasificacionriesgo")
	List<Clasificacionriesgo> listaClasificacionRiesgo();
}

