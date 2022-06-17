package com.example.DIRESA.entity.empleado.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.DIRESA.entity.empleado.Empleado;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name="empleadoVoListado")
@Table(name="VIEW_Empleado_Listado")
@EqualsAndHashCode
public class EmpleadoVOListado {
	
	@Id
	@Column(name="ID_EMPLEADOS")
	private Long  id ;
	
	
	//PERSONASFAM ES UN NOMBRE CUALQUIERA QUE ENGLOBA A 2 ATRIBUTOS DE POSTGREQ
	// QUE SON FAMILIA Y CELULAR
	@Column(name="PERSONASFAM")
	
	   private String PERSONASFAM;
	
	
	@Column(name="DNIEMPLEADO")
	   private String dniempleado;
	@Column(name="NOMBREEMPLEADO")
	   private String nombreempleado;
	
	//@Column(name="NOMBREESTABLECIMIENTO")
		//private String nombreestablecimiento;
	
	
		

}
