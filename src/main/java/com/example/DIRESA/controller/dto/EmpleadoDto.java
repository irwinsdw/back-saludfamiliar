package com.example.DIRESA.controller.dto;

import com.example.DIRESA.entity.empleado.Empleado;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class EmpleadoDto implements Serializable {
    private Integer id;
    private String dni;
   
	private String nombre;
	
	
	 public EmpleadoDto(Empleado empleado) {
			BeanUtils.copyProperties(empleado,this);
		}
  
	 
	 
}
