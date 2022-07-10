package com.example.DIRESA.service.general.implemen;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.DIRESA.entity.empleado.Caracteristica;
import com.example.DIRESA.entity.empleado.Establecimiento;
import com.example.DIRESA.entity.empleado.FamiliaItem;
import com.example.DIRESA.entity.empleado.Item;
import com.example.DIRESA.repository.procesos.EstablecimientoRepository;
import com.example.DIRESA.repository.procesos.FamiliaItemRepository;
import com.example.DIRESA.repository.procesos.SocioeconomicoRepository;
import com.example.DIRESA.service.exception.ServiceException;
import com.example.DIRESA.service.general.interf.SocioeconomicoService;

@Service
public class SocioeconomicoImplements implements SocioeconomicoService{
	@Autowired
	private SocioeconomicoRepository socioeconomicorepository;
	@Autowired FamiliaItemRepository familiaitemrepository;
	@Override
	public Page<Caracteristica> findByLikeObject(Caracteristica t, Pageable pageable) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Caracteristica> findByLikeObject(Caracteristica t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Caracteristica> findById(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Caracteristica add(Caracteristica t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Caracteristica update(Caracteristica t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Caracteristica t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Caracteristica> listar() {
		// TODO Auto-generated method stub
		return socioeconomicorepository.findAll();
	}

	@Override
	public List<Item> listaritem() {
		// TODO Auto-generated method stub
		return socioeconomicorepository.listaritem();
	}

	

	

	
	



}

