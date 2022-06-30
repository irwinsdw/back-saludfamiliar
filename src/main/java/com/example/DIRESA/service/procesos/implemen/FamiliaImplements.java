package com.example.DIRESA.service.procesos.implemen;


import static com.example.DIRESA.util.QueryUtil.getLike;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.example.DIRESA.entity.empleado.Encuesta;
import com.example.DIRESA.entity.general.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.DIRESA.entity.general.Familia;
import com.example.DIRESA.entity.general.Familia;
import com.example.DIRESA.repository.general.FamiliaRepository;
import com.example.DIRESA.repository.procesos.EmpleadosRepository;
import com.example.DIRESA.service.exception.ServiceException;
import com.example.DIRESA.service.procesos.interf.FamiliaService;
import com.example.DIRESA.util.QueryUtil;

import lombok.extern.slf4j.Slf4j;








@Slf4j
@Service
public class FamiliaImplements implements FamiliaService{
	@Autowired
	private FamiliaRepository familiarepository;
	@Autowired
	private EmpleadosRepository empleados;
	

	@Override
	public Page<Familia> findByLikeObject(Familia familia , Pageable pageable) throws ServiceException {
		try {
			return this.familiarepository.findByLikeFamilia(getLike(familia.getNombre()), pageable);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Optional<Familia> findById(Long id) throws ServiceException {
		try {
			return familiarepository.findById(id);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Transactional
	@Override
	public Familia add(Familia familia) throws ServiceException {
		
		//Familia aux = familiarepository.save(familia);
		//List<Familia> personaFamilia = empleados.findByIdIn(familia.gete))
			
			
			return familiarepository.save(familia);
		
			
		
	}
	

	@Override
	public Familia update(Familia familia) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Familia familia) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Familia> findByFam(String familia) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Persona> buscarMiembrosFamiliaPorFamiliaId(Long id) {
		return familiarepository.buscarMiembrosFamiliaPorFamiliaId(id);
	}

	@Override
	public List<Encuesta> buscarEncuestasPorFamiliaId(Long idFamilia) {
		return familiarepository.buscarEncuestasPorFamiliaId(idFamilia);
	}

	@Override
	public List<Familia> findByLikeObject(Familia t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
