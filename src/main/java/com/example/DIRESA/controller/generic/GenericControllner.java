package com.example.DIRESA.controller.generic;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import static com.example.DIRESA.controller.commons.CodEnum.*;

import com.example.DIRESA.controller.commons.CodEnum;
import static com.example.DIRESA.controller.commons.MessageConstants.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.DIRESA.dto.response.CustomResponse;

public class GenericControllner {

	protected ResponseEntity<?> getNotContent() {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	protected ResponseEntity<List<Map<String, String>>> getErrors(BindingResult result) {

		List<Map<String, String>> errors = result.getFieldErrors().stream().map(err -> {
			
			Map<String, String> error = new HashMap<>();
			
			error.put(err.getField(), err.getDefaultMessage());
			return error;
		}
		).collect(Collectors.toList());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}	
	
	
	


protected ResponseEntity<?> getNotFount(Optional opt) {
	if (opt.isEmpty()) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				CustomResponse.builder().code(CodEnum.WARNING).message("No existe registro").build());
	}

	return ResponseEntity.ok(CustomResponse.builder().code(CodEnum.SUCCESS).message("Exito al recupera registro")
			.data(opt.get()).build());
}

	protected ResponseEntity getError(String ms) {
	
	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(CustomResponse
			.builder()
			.code(ERROR)
			.message(MSG_ERROR_INTERNO +ms)
			.build()) ;
	}
	protected ResponseEntity getCreated(Object obj , String ms) {   // PARA EL METODO CREAR
	return ResponseEntity.status(HttpStatus.CREATED).body(
			CustomResponse
			.builder()
			.code(CodEnum.SUCCESS)
			.message(Registro_Exitoso +ms)
			.data(obj)
			.build() 
			);
}  
	
	protected ResponseEntity getBad( String ms) {
	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
			CustomResponse
			.builder()
			.code(WARNING)
			.message(error_al_crear+ms)
			.build() 
			);
	
	
}}  