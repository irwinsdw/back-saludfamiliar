package com.example.DIRESA.controller.general;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.example.DIRESA.entity.empleado.Encuesta;
import com.example.DIRESA.entity.general.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.DIRESA.controller.commons.CodEnum;
import com.example.DIRESA.controller.generic.GenericControllner;
import com.example.DIRESA.dto.response.CustomResponse;
import com.example.DIRESA.entity.general.Familia;
import com.example.DIRESA.service.procesos.interf.FamiliaService;


import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/v1/familias")

public class FamiliasController  extends GenericControllner {

	@Autowired
	private FamiliaService familiaservice;

	private String api = "familia";

	
	@GetMapping("/by-nombre")
	public ResponseEntity<?> findByLikeFamilia(@RequestParam(name = "familia", defaultValue = "") String familia, @RequestParam(name = "pagina", defaultValue = "1") Integer pagina,
			@RequestParam(name = "limite", defaultValue = "1") Integer  limite) { // http://localhost:8080/api-pedidos/v1/familias/by-nombre?familia=jaramillo
//en la parte de(@RequestParam(name = "familia",esto ira en el endpoint http://localhost:8080/api-pedidos/v1/familias/by-nombre?familia 
		// y no iria v1/familias/by-nombre?nombre  
		
		try {
			Pageable pageable=PageRequest.of(pagina-1,limite);
			Page<Familia> lst = familiaservice.findByLikeObject(Familia.builder().nombre(familia).build(),pageable);
			log.debug("listado", lst);
			if (lst.isEmpty()) {
				return super.getNotContent();
			}
			return ResponseEntity.ok(lst);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		try {
			Optional<Familia> opt = familiaservice.findById(id);
			return super.getNotFount(opt);
		} catch (Exception e) {
			return super.getError(api);
		}
	}
	
	@GetMapping("/by-familia/{familia}")
	public ResponseEntity<?> findByFam(@PathVariable("familia") String familia) {
		try {
			Optional<Familia> optCliente = familiaservice.findByFam(familia);
			if (!optCliente.isPresent()) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
						CustomResponse.builder().code(CodEnum.WARNING).message("no existe dicha familia").build());
			}

			return ResponseEntity.ok(CustomResponse.builder().code(CodEnum.SUCCESS).message("familia si existe")
					.data(familiaservice.findByFam(familia).get()).build());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/{idFamilia}/miembros")
	public ResponseEntity<?> buscarMiembrosFamiliaPorFamiliaId(@PathVariable Long idFamilia) {
		try {
			List<Persona> miembosDeFamilia = familiaservice.buscarMiembrosFamiliaPorFamiliaId(idFamilia);

			return ResponseEntity.ok(CustomResponse.builder().code(CodEnum.SUCCESS).message("BÚSQUEDA EXITOSA")
					.data(miembosDeFamilia).build());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/{idFamilia}/encuestas")
	public ResponseEntity<?> buscarEncuestasPorFamiliaId(@PathVariable Long idFamilia) {
		try {
			List<Encuesta> encuestas = familiaservice.buscarEncuestasPorFamiliaId(idFamilia);

			return ResponseEntity.ok(CustomResponse.builder().code(CodEnum.SUCCESS).message("BÚSQUEDA EXITOSA")
					.data(encuestas).build());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping
	public ResponseEntity<?> add(@RequestBody @Validated Familia familia, BindingResult result) {
		if (result.hasErrors()) {
			return super.getErrors(result);
		}
		try {
			Familia resFamilia = familiaservice.add(familia);
			if (Objects.isNull(resFamilia)) {
				super.getBad(api);
			}
			return super.getCreated(resFamilia, api);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return super.getError(api);
		}
	}}