package com.example.DIRESA.controller.procesos;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DIRESA.controller.generic.GenericControllner;
import com.example.DIRESA.entity.empleado.Caracteristica;
import com.example.DIRESA.entity.empleado.Establecimiento;
import com.example.DIRESA.entity.empleado.FamiliaItem;
import com.example.DIRESA.entity.empleado.Provincia;
import com.example.DIRESA.entity.empleado.RedSalud;
import com.example.DIRESA.entity.empleado.Item;
import com.example.DIRESA.service.general.interf.EstablecimientoService;
import com.example.DIRESA.service.general.interf.FamiliaItemService;
import com.example.DIRESA.service.general.interf.SocioeconomicoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/caracteristica")
public class SocioeconomicoController extends GenericControllner{

	
	
	@Autowired
	private SocioeconomicoService socioeconomicoservice;
	@Autowired
	private FamiliaItemService familiaitemservice;
	private String api = "socioeconomico";


	@GetMapping("/valores/{id}")
	public List<FamiliaItem> listarcombinada(@PathVariable("id") Long id){
		return familiaitemservice.listarcombinada(id);
	}
	@GetMapping("/listar")
	public List<Caracteristica> findAll(){
		return socioeconomicoservice.listar();
	}	
	
	@GetMapping("/item")
	public List<Item> listaritem(){
		return socioeconomicoservice.listaritem();
	}
	
	@PostMapping
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> add(@RequestBody  @Validated FamiliaItem FamiliaItem, BindingResult result ) {
		if (result.hasErrors()) {
			return super.getErrors(result);
			//return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result.getAllErrors());
		}
		try {
			FamiliaItem resFamilia = familiaitemservice.add(FamiliaItem);
			if (Objects.isNull(resFamilia)) {
				super.getBad(api);
			}
			return super.getCreated(resFamilia, api);
		} catch (Exception e) {
			//e.printStackTrace();
			log.error(e.getMessage(),e);
			return super.getError(api);
	

		}}}

