package com.example.DIRESA.controller.procesos;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.DIRESA.controller.commons.CodEnum;
import com.example.DIRESA.controller.generic.GenericControllner;
import com.example.DIRESA.controller.generic.ResourceNotFoundException;
import com.example.DIRESA.dto.response.CustomResponse;
import com.example.DIRESA.entity.empleado.Empleado;
import com.example.DIRESA.entity.empleado.vo.EmpleadoVOListado;
import com.example.DIRESA.service.general.interf.EmpleadoService;
import com.example.DIRESA.service.general.interf.EmpleadoVOservice;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@RestController
@RequestMapping("/v1/Empleado")

public class EmpleadosController  extends GenericControllner {

	@Autowired
	private EmpleadoService empleadoServices;
	@Autowired
	private EmpleadoVOservice empleadoVoService;
	private String api = "EMPLEADO";

	@GetMapping("/listaEmpleados")
	public List<Empleado> listarEmpleados() {
		return empleadoServices.listarEmpleados();
	}

	@GetMapping("/vo")
	@ResponseBody
	public ResponseEntity<?> findBEmpleadoVOListado(@RequestParam(name = "PERSONASFAM", defaultValue = "1") String PERSONASFAM, @RequestParam(name = "pagina", defaultValue = "1") Integer pagina,
			@RequestParam(name = "limite", defaultValue = "5") Integer  limite) { // http://localhost:8080/api-pedidos/v1/familias/by-nombre?familia=jaramillo
		//en la parte de(@RequestParam(name = "familia",esto ira en el endpoint http://localhost:8080/api-pedidos/v1/familias/by-nombre?familia 
				// y no iria v1/familias/by-nombre?nombre  
				
		try {
			Pageable pageable=PageRequest.of(pagina-1,limite);
			Page<EmpleadoVOListado> lst = empleadoVoService.findByLikeObject(EmpleadoVOListado.builder().PERSONASFAM(PERSONASFAM).build(),pageable);
			log.debug("listado", lst);
			if (lst.isEmpty()) {
				return super.getNotContent();
			}
					return ResponseEntity.ok(lst);
				} catch (Exception e) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
				}
	}
	
@GetMapping("/vo-by")
@ResponseBody
public ResponseEntity<?> findAllCustom(@RequestParam(name = "pagina", defaultValue = "1") Integer pagina,
		@RequestParam(name = "limite", defaultValue = "1") Integer  limite) {
	try {
		Pageable pageable=PageRequest.of(pagina-1,limite);
		Page<EmpleadoVOListado> lst = empleadoVoService.findAllCustom(pageable);
		log.debug("listado", lst);
		if (lst.isEmpty()) {
			return super.getNotContent();
		}
		return ResponseEntity.ok(lst);
	} catch (Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}

	


@GetMapping("/by-empleado/{dni}")
@ResponseBody
public ResponseEntity<?> findByRuc(@PathVariable("dni") String dniempleado) {
	try {
		Optional<Empleado> optCliente = empleadoServices.findByDni(dniempleado);
		if (!optCliente.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(CustomResponse.builder().code(CodEnum.WARNING)
					.message("No existe empleado").build());
		}

		return ResponseEntity.ok(
				CustomResponse.builder().code(CodEnum.SUCCESS).message("usuario encontrado")
						.data(optCliente.get()).build());
	} catch (Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}


@GetMapping("/empleados")
@ResponseBody
public ResponseEntity<?> findAllCustoms(@RequestParam(name = "pagina", defaultValue = "1") Integer pagina,
		@RequestParam(name = "limite", defaultValue = "5") Integer  limite) {
	try {
		Pageable pageable=PageRequest.of(pagina-1,limite);
		Page<Empleado> lst = empleadoServices.findAllCustom(pageable);
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
	@ResponseBody
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		try {
			Optional<Empleado> opt = empleadoServices.findById(id);
			return super.getNotFount(opt);
		} catch (Exception e) {
		System.out.println(e.getLocalizedMessage());
			return super.getError(api);
		}
	}
	/*
	@GetMapping("/by-Empleado/{Empleado}")
	public ResponseEntity<?> findByFam(@PathVariable("Empleado") String Empleado) {
		try {
			Optional<Empleado> optCliente = empleadoServices.findByFam(Empleado);
			if (optCliente.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
						CustomResponse.builder().code(CodEnum.WARNING).message("no existe dicha Empleado").build());
			}
			return ResponseEntity.ok(CustomResponse.builder().code(CodEnum.SUCCESS).message("Empleado si existe")
					.data(empleadoServices.findByFam(Empleado).get()).build());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
*/
	@PostMapping
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> add(@RequestBody  @Validated Empleado Empleado, BindingResult result ) {
		if (result.hasErrors()) {
			return super.getErrors(result);
			//return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result.getAllErrors());
		}
		try {
			Empleado resEmpleado = empleadoServices.add(Empleado);
			if (Objects.isNull(resEmpleado)) {
				super.getBad(api);
			}
			return super.getCreated(resEmpleado, api);
		} catch (Exception e) {
			//e.printStackTrace();
			log.error(e.getMessage(),e);
			return super.getError(api);
	

		}
	
	 
	  
	}
	
	/*
	  @PutMapping("/empleados/{id}")
	  public Empleado update(@RequestBody Empleado empleado, @PathVariable Long id ) {
	    
		Empleado empleadoactual = empleadoServices.findById(id);
		 
		 empleadoactual.setApellidoempleado(empleado.getApellidoempleado());
	  
	  return empleadoServices.save(empleadoactual);
			  }
	  
*/	 
}