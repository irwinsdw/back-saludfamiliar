package com.example.DIRESA.service.generic;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.DIRESA.entity.empleado.Establecimiento;
import com.example.DIRESA.entity.empleado.vo.EmpleadoVOListado;
import com.example.DIRESA.service.exception.ServiceException;

public interface GenericService<T> {

	Page<T> findByLikeObject(T t, Pageable pageable) throws ServiceException;
	List<T> findByLikeObject(T t) throws ServiceException;
	Optional<T> findById(Long id) throws ServiceException;
	
	T add(T t) throws ServiceException;
	
	T update(T t)throws ServiceException;
	
	Boolean delete(T t)throws ServiceException;
	
	
	
	
}

