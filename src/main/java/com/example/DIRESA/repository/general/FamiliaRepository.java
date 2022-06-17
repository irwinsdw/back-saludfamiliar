package com.example.DIRESA.repository.general;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.DIRESA.entity.general.Familia;
@Repository
public interface FamiliaRepository extends JpaRepository<Familia, Long> {
	@Query("select c from Familia c where UPPER(c.nombre) like UPPER(:nombre)")
	Page<Familia> findByLikeFamilia(@Param("nombre") String familia , Pageable pageable);  //JPQL
	
}
