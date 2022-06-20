package com.example.DIRESA.service.general.interf;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.DIRESA.entity.empleado.Empleado;
import com.example.DIRESA.entity.empleado.Encuesta;
import com.example.DIRESA.entity.general.Persona;
import com.example.DIRESA.service.exception.ServiceException;
import com.example.DIRESA.service.generic.GenericService;

public interface EncuestaService extends GenericService<Encuesta>{

	

	
Optional<Encuesta> findByEncuesta(String encuesta) throws ServiceException;	
	
}
