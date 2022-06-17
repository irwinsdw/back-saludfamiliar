package com.example.DIRESA.controller.procesos;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
import com.example.DIRESA.entity.empleado.Establecimiento;
import com.example.DIRESA.entity.empleado.vo.EmpleadoVOListado;
import com.example.DIRESA.service.general.interf.EstablecimientoService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/v1/Establecimiento")

public class EstablecimientoController  extends GenericControllner {

	@Autowired
	private EstablecimientoService establecimientoservice;

	private String api = "Establecimiento Familias";

	/*
	@GetMapping("/by-establec")
	public ResponseEntity<?> findByLikeEstablecimiento(@RequestParam(name = "Establecimiento", defaultValue = "") String Establecimiento) { // http://localhost:8080/api-pedidos/v1/Establecimientos/by-nombre?Establecimiento=jaramillo
//en la parte de(@RequestParam(name = "Establecimiento",esto ira en el endpoint http://localhost:8080/api-pedidos/v1/Establecimientos/by-nombre?Establecimiento 
		// y no iria v1/Establecimientos/by-nombre?nombre  
		
		try {
			List<Establecimiento> lst = establecimientoservice.findByLikeObject(Establecimiento.builder().Establecimiento(Establecimiento).build());
			log.debug("listado", lst);
			if (lst.isEmpty()) {
				return super.getNotContent();
			}
			return ResponseEntity.ok(lst);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
*/
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		try {
			Optional<Establecimiento> opt = establecimientoservice.findById(id);
			return super.getNotFount(opt);
		} catch (Exception e) {
			return super.getError(api);
		}
	}
	
	@GetMapping
	public List<Establecimiento> findAll(){
		return establecimientoservice.findAll();
	}
	@GetMapping("/Establecimiento")
	
	
	public ResponseEntity<?> findBEmpleadoVOListado(@RequestParam(name = "esta", defaultValue = "") String PERSONASFAM, @RequestParam(name = "pagina", defaultValue = "1") Integer pagina,
			@RequestParam(name = "limite", defaultValue = "1") Integer  limite) { // http://localhost:8080/api-pedidos/v1/familias/by-nombre?familia=jaramillo
		//en la parte de(@RequestParam(name = "familia",esto ira en el endpoint http://localhost:8080/api-pedidos/v1/familias/by-nombre?familia 
				// y no iria v1/familias/by-nombre?nombre  
				
				try {
					
					Pageable pageable=PageRequest.of(pagina-1,limite);
					Page<Establecimiento> lst = establecimientoservice.findByLikeObject(Establecimiento.builder().nombre(PERSONASFAM).build(),pageable);
					log.debug("listado", lst);
					if (lst.isEmpty()) {
						return super.getNotContent();
					}
					return ResponseEntity.ok(lst);
				} catch (Exception e) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
				}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	@GetMapping("/by-Establecimiento/{Establecimiento}")
	public ResponseEntity<?> findByFam(@PathVariable("Establecimiento") String Establecimiento) {
		try {
			Optional<Establecimiento> optCliente = establecimientoservice.findByFam(Establecimiento);
			if (optCliente.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
						CustomResponse.builder().code(CodEnum.WARNING).message("no existe dicha Establecimiento").build());
			}

			return ResponseEntity.ok(CustomResponse.builder().code(CodEnum.SUCCESS).message("Establecimiento si existe")
					.data(establecimientoservice.findByFam(Establecimiento).get()).build());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
*/
	@PostMapping
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> add(@RequestBody  @Validated Establecimiento Establecimiento, BindingResult result ) {
		if (result.hasErrors()) {
			return super.getErrors(result);
			//return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result.getAllErrors());
		}
		try {
			Establecimiento resEstablecimiento = establecimientoservice.add(Establecimiento);
			if (Objects.isNull(resEstablecimiento)) {
				super.getBad(api);
			}
			return super.getCreated(resEstablecimiento, api);
		} catch (Exception e) {
			//e.printStackTrace();
			log.error(e.getMessage(),e);
			return super.getError(api);
	

		}}}