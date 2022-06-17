package com.example.DIRESA.service.general.interf;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.DIRESA.entity.empleado.Empleado;
import com.example.DIRESA.entity.empleado.vo.EmpleadoVOListado;
import com.example.DIRESA.service.exception.ServiceException;
import com.example.DIRESA.service.generic.GenericService;

public interface EmpleadoVOservice extends GenericService<EmpleadoVOListado>{
	
	
	List <EmpleadoVOListado>getEmpleadoVO()throws ServiceException;
	Page<EmpleadoVOListado>findAllCustom(Pageable pageable) throws ServiceException;
	List<EmpleadoVOListado> findAll();
	
}
