package com.example.DIRESA.service.general.implemen;

import static com.example.DIRESA.util.QueryUtil.getLike;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.loader.plan.exec.process.internal.AbstractRowReader;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.DIRESA.entity.empleado.Empleado;
import com.example.DIRESA.entity.empleado.vo.EmpleadoVOListado;
import com.example.DIRESA.repository.procesos.EmpleadosRepository;
import com.example.DIRESA.repository.procesos.vo.EmpleadosVOListadoRepository;
import com.example.DIRESA.service.exception.ServiceException;
import com.example.DIRESA.service.general.interf.EmpleadoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmpleadoImplements implements EmpleadoService{

	@Autowired
	private EmpleadosRepository empleadoReposi;
	
	
	
	
	
	@Override
	public Optional<Empleado> findById(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		
		try {
			return empleadoReposi.findById(id);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
		
	}

	@Override
	public Empleado add(Empleado empleados) throws ServiceException {
		// TODO Auto-generated method stub
	
	
	
	
		try {
			
			
			
			
			
			return empleadoReposi.save(empleados);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Empleado update(Empleado empleado) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			Optional<Empleado> optCliente= empleadoReposi.findById(empleado.getId());
			if (optCliente.isPresent()) {
				Empleado tmpCliente= optCliente.get();
				BeanUtils.copyProperties(empleado,tmpCliente);
				return empleadoReposi.save(tmpCliente);	
			}
			throw new ServiceException("No existe cliente con el id "+empleado.getId());
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}
	

	@Override
	public Boolean delete(Empleado t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Page<Empleado> findByLikeObject(Empleado t, Pageable pageable) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}


	


	@Override
	public Page<Empleado> findAllCustom(Pageable pageable) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			return this.empleadoReposi.findAllCustom(pageable);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	
	}
	


	@Override
	public List<Empleado> findByLikeObject(Empleado dniempleado) throws ServiceException {
		return null;
	}

	@Override
	public Optional<Empleado> findByDni(String dniempleado) throws ServiceException {
		try {
			return empleadoReposi.findByDniempleado(dniempleado);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Empleado> listarEmpleados() {
		return empleadoReposi.findAll();
	}

}


	


	



	
	


	


	



