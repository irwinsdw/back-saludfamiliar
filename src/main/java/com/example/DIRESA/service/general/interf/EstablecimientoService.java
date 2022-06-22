package com.example.DIRESA.service.general.interf;

import java.util.List;
import java.util.Optional;

import com.example.DIRESA.entity.empleado.Microred;
import com.example.DIRESA.entity.empleado.Provincia;
import com.example.DIRESA.entity.empleado.RedSalud;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.DIRESA.entity.empleado.Establecimiento;
import com.example.DIRESA.entity.empleado.vo.EmpleadoVOListado;
import com.example.DIRESA.service.exception.ServiceException;
import com.example.DIRESA.service.generic.GenericService;




public interface EstablecimientoService extends GenericService<Establecimiento>{

	//Optional<establecimientos> findByFam(String familia) throws ServiceException;
	List <Establecimiento>getEstble()throws ServiceException;
	Page<Establecimiento>findAllCustom(Pageable pageable) throws ServiceException;
	List<Establecimiento> findAll();
	List<RedSalud> listarRedesSalud();
	List<Provincia> listarProvincias();
		
}

