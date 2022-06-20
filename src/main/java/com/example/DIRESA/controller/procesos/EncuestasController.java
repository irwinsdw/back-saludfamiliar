package com.example.DIRESA.controller.procesos;

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

import com.example.DIRESA.controller.general.FamiliasController;
import com.example.DIRESA.controller.generic.GenericControllner;
import com.example.DIRESA.entity.empleado.Encuesta;
import com.example.DIRESA.entity.general.Persona;
import com.example.DIRESA.service.general.interf.EncuestaService;
import com.example.DIRESA.service.procesos.interf.PersonaService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/encuestas")
public class EncuestasController extends GenericControllner{

	@Autowired
	private EncuestaService encuestaservice;
	private String api = "encuestas";

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		try {
			Optional<Encuesta> opt = encuestaservice.findById(id);
			return super.getNotFount(opt);
		} catch (Exception e) {
		System.out.println(e.getLocalizedMessage());
			return super.getError(api);
		}
	}
	
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody @Validated Encuesta encuesta, BindingResult result) {
		if (result.hasErrors()) {
			return super.getErrors(result);
		}
		try {
			Encuesta resPersona = encuestaservice.add(encuesta);
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
