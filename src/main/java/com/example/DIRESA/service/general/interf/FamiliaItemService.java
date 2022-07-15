package com.example.DIRESA.service.general.interf;

import java.util.List;

import com.example.DIRESA.entity.empleado.Caracteristica;
import com.example.DIRESA.entity.empleado.FamiliaItem;
import com.example.DIRESA.service.generic.GenericService;

public interface FamiliaItemService extends GenericService<FamiliaItem>
{
	List<FamiliaItem> listarcombinada(Long familiaId);

	public void guardarListaFamiliaItem(List<FamiliaItem> familiaItems);
}
