package com.example.DIRESA.service.general.implemen;

import static com.example.DIRESA.util.QueryUtil.getLike;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.example.DIRESA.entity.empleado.vo.EmpleadoVOListado;
import com.example.DIRESA.repository.procesos.vo.EmpleadosVOListadoRepository;
import com.example.DIRESA.service.exception.ServiceException;
import com.example.DIRESA.service.general.interf.EmpleadoService;
import com.example.DIRESA.service.general.interf.EmpleadoVOservice;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class EmpleadoVoImplemen implements EmpleadoVOservice{
	@Autowired
	private EmpleadosVOListadoRepository empleadosVOListadoRepository;

	@Override
	public List<EmpleadoVOListado> findAll() {
		
		return empleadosVOListadoRepository.findAll();
	}
	

	@Override
	public Optional<EmpleadoVOListado> findById(Long id) throws ServiceException {
		try {
			return empleadosVOListadoRepository.findById(id);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public EmpleadoVOListado add(EmpleadoVOListado empleadovolistado) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			return empleadosVOListadoRepository.save(empleadovolistado);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public EmpleadoVOListado update(EmpleadoVOListado t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(EmpleadoVOListado t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpleadoVOListado> getEmpleadoVO() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Page<EmpleadoVOListado> findAllCustom(Pageable pageable) throws ServiceException {
		// TODO Auto-generated method stub
try {
			
			return this.empleadosVOListadoRepository.findAllCustom(pageable);
			
		} catch (Exception e) {
		throw new ServiceException(e);
		
	}

}

	@Override
	public Page<EmpleadoVOListado> findByLikeObject(EmpleadoVOListado empleadovolistado, Pageable pageable) throws ServiceException {
			// TODO Auto-generated method stub
			try {
				return this.empleadosVOListadoRepository.FindbylikeFamilia(getLike(empleadovolistado.getPERSONASFAM()), pageable);
			} catch (Exception e) {
				throw new ServiceException(e);
			}
		
	}


	@Override
	public List<EmpleadoVOListado> findByLikeObject(EmpleadoVOListado t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}
	}
