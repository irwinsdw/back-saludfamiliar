package com.example.DIRESA.service.general.interf;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.DIRESA.entity.empleado.Empleado;
import com.example.DIRESA.entity.empleado.vo.EmpleadoVOListado;
import com.example.DIRESA.service.exception.ServiceException;
import com.example.DIRESA.service.generic.GenericService;





public interface EmpleadoService extends GenericService<Empleado>{

	Page<Empleado> findAllCustom(Pageable pageable) throws ServiceException;
	
	Optional<Empleado> findByDni(String dniempleado) throws ServiceException;


	List<Empleado> listarEmpleados();
}
