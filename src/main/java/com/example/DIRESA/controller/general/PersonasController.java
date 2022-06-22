package com.example.DIRESA.controller.general;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.DIRESA.controller.generic.GenericControllner;
import com.example.DIRESA.controller.procesos.EmpleadosController;
import com.example.DIRESA.entity.empleado.Empleado;
import com.example.DIRESA.entity.general.Familia;
import com.example.DIRESA.entity.general.Persona;
import com.example.DIRESA.service.general.interf.EmpleadoService;
import com.example.DIRESA.service.general.interf.EmpleadoVOservice;
import com.example.DIRESA.service.procesos.interf.PersonaService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/persona")

public class PersonasController extends GenericControllner{

	@Autowired
	private PersonaService personaservice;
	private String api = "personas";

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		try {
			Optional<Persona> opt = personaservice.findById(id);
			return super.getNotFount(opt);
		} catch (Exception e) {
		System.out.println(e.getLocalizedMessage());
			return super.getError(api);
		}
	}

	@GetMapping("/burcar_por_dni/{dni}")
	@ResponseBody
	public ResponseEntity<?> buscarPorDni(@PathVariable String dni) {
		try {
			Optional<Persona> opt = personaservice.buscarPersonaPorDni(dni);
			return super.getNotFount(opt);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return super.getError(api);
		}
	}
	
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody @Validated Persona persona, BindingResult result) {
		if (result.hasErrors()) {
			return super.getErrors(result);
		}
		try {
			Persona resPersona = personaservice.add(persona);
			if (Objects.isNull(resPersona)) {
				super.getBad(api);
			}
			return super.getCreated(resPersona, api);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return super.getError(api);
		}
	}
	
	
	
	
}
