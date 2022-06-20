package com.example.DIRESA.service.general.implemen;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.DIRESA.entity.empleado.Empleado;
import com.example.DIRESA.entity.empleado.Encuesta;
import com.example.DIRESA.repository.procesos.EmpleadosRepository;
import com.example.DIRESA.repository.procesos.EncuestasRepository;
import com.example.DIRESA.service.exception.ServiceException;
import com.example.DIRESA.service.general.interf.EncuestaService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EncuestaImplements implements EncuestaService{
	
	@Autowired
	private EncuestasRepository encuestaRepository;
	
	@Override
	public Page<Encuesta> findByLikeObject(Encuesta t, Pageable pageable) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Encuesta> findByLikeObject(Encuesta t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Encuesta> findById(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				try {
					return encuestaRepository.findById(id);
				} catch (Exception e) {
					throw new ServiceException(e);
				}
			}

	@Transactional
	@Override
	public Encuesta add(Encuesta persona) throws ServiceException {
		// TODO Auto-generated method stub
		return encuestaRepository.save(persona);
	}

	@Override
	public Encuesta update(Encuesta t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Encuesta t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	
	

	@Override
	public Optional<Encuesta> findByEncuesta(String encuesta) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
