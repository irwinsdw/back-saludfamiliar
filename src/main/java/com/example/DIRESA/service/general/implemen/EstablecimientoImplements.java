package com.example.DIRESA.service.general.implemen;


import static com.example.DIRESA.util.QueryUtil.getLike;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.DIRESA.entity.empleado.Establecimiento;
import com.example.DIRESA.repository.procesos.EstablecimientoRepository;
import com.example.DIRESA.service.exception.ServiceException;
import com.example.DIRESA.service.general.interf.EstablecimientoService;
import com.example.DIRESA.util.QueryUtil;








@Service
public class EstablecimientoImplements implements EstablecimientoService{
	@Autowired
	private EstablecimientoRepository establecimientorepositorio;
	
	@Override
	public List<Establecimiento> findAll() {
		
		return establecimientorepositorio.findAll();
	}

	@Override
	public Page<Establecimiento> findByLikeObject(Establecimiento estableci , Pageable pageable) throws ServiceException {
		try {
			return this.establecimientorepositorio.FindbylikeEstable(getLike(estableci.getNombre()), pageable);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}
	@Override
	public Optional<Establecimiento> findById(Long id) throws ServiceException {
		try {
			return establecimientorepositorio.findById(id);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}


	@Override
	public Establecimiento add(Establecimiento Establecimiento) throws ServiceException {
		
		
		try {
			return establecimientorepositorio.save(Establecimiento);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}
	

	@Override
	public Establecimiento update(Establecimiento Establecimiento) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Establecimiento Establecimiento) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Establecimiento> getEstble() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Page<Establecimiento> findAllCustom(Pageable pageable) throws ServiceException {
		// TODO Auto-generated method stub
		
try {
			
			return this.establecimientorepositorio.findAllCustom(pageable);
			
		} catch (Exception e) {
		throw new ServiceException(e);
		
	}
	}

	@Override
	public List<Establecimiento> findByLikeObject(Establecimiento t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	
	

	

}
