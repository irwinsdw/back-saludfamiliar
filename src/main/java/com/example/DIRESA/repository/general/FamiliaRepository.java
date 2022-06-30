package com.example.DIRESA.repository.general;

import com.example.DIRESA.entity.empleado.Encuesta;
import com.example.DIRESA.entity.general.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.DIRESA.entity.general.Familia;

import java.util.List;

@Repository
public interface FamiliaRepository extends JpaRepository<Familia, Long> {
	@Query("select c from Familia c where UPPER(c.nombre) like UPPER(:nombre)")
	Page<Familia> findByLikeFamilia(@Param("nombre") String familia , Pageable pageable);  //JPQL

	@Query("FROM Persona p WHERE p.familia.id = ?1")
	List<Persona> buscarMiembrosFamiliaPorFamiliaId(Long id);

	@Query("FROM Encuesta e WHERE e.familia.id = ?1")
	List<Encuesta> buscarEncuestasPorFamiliaId(Long idFamilia);
}
