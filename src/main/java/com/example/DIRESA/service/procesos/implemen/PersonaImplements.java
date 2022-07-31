package com.example.DIRESA.service.procesos.implemen;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.example.DIRESA.entity.empleado.Clasificacionriesgo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.DIRESA.entity.general.Persona;
import com.example.DIRESA.repository.general.FamiliaRepository;
import com.example.DIRESA.repository.general.PersonaRepository;
import com.example.DIRESA.service.exception.ServiceException;
import com.example.DIRESA.service.procesos.interf.FamiliaService;
import com.example.DIRESA.service.procesos.interf.PersonaService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class PersonaImplements implements PersonaService {
	@Autowired
	private PersonaRepository personarepository;
	@Override
	public Page<Persona> findByLikeObject(Persona t, Pageable pageable) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Persona> findByLikeObject(Persona t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Persona> findById(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			return personarepository.findById(id);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Transactional
	@Override
	public Persona add(Persona persona) throws ServiceException {
		// TODO Auto-generated method stub
		return personarepository.save(persona);
	}

	@Override
	public Persona update(Persona t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Persona t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Persona> findByFam(String persona) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Persona> buscarPersonaPorDni(String dni) {
		return personarepository.findPersonaByDni(dni);
	}

	@Override
	public List<Clasificacionriesgo> listaClasificacionRiesgo() {
		return personarepository.listaClasificacionRiesgo();
	}


}
