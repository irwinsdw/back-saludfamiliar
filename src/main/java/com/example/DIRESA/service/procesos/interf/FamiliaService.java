package com.example.DIRESA.service.procesos.interf;

import java.util.Optional;

import com.example.DIRESA.entity.general.Familia;
import com.example.DIRESA.service.exception.ServiceException;
import com.example.DIRESA.service.generic.GenericService;




public interface FamiliaService extends GenericService<Familia>{

	Optional<Familia> findByFam(String familia) throws ServiceException;
	
	

	

}

