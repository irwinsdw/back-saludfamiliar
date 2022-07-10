package com.example.DIRESA.service.general.interf;

import java.util.List;
import java.util.Optional;

import com.example.DIRESA.entity.empleado.Provincia;
import com.example.DIRESA.entity.empleado.Caracteristica;
import com.example.DIRESA.entity.empleado.Establecimiento;
import com.example.DIRESA.entity.empleado.Item;
import com.example.DIRESA.entity.empleado.FamiliaItem;
import com.example.DIRESA.service.generic.GenericService;


public interface SocioeconomicoService extends GenericService<Caracteristica> {
	List<Caracteristica> listar();
	List<Item> listaritem();
	
	
}
