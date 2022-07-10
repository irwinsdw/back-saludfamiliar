package com.example.DIRESA.service.general.implemen;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.DIRESA.entity.empleado.FamiliaItem;
import com.example.DIRESA.repository.procesos.FamiliaItemRepository;
import com.example.DIRESA.service.exception.ServiceException;
import com.example.DIRESA.service.general.interf.FamiliaItemService;
import com.example.DIRESA.service.procesos.interf.FamiliaService;
@Service
public class FamiliaItemsImplements implements FamiliaItemService{
	@Autowired
	private FamiliaItemRepository familiaitemrepository;
	@Override
	public Page<FamiliaItem> findByLikeObject(FamiliaItem t, Pageable pageable) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FamiliaItem> findByLikeObject(FamiliaItem t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<FamiliaItem> findById(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FamiliaItem add(FamiliaItem Familia) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			return familiaitemrepository.save(Familia);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public FamiliaItem update(FamiliaItem t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(FamiliaItem t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FamiliaItem> listarcombinada(Long familiaId) {
		// TODO Auto-generated method stub
		return familiaitemrepository.findByFamiliaItemUpkFamiliaId(familiaId);
	}

}
