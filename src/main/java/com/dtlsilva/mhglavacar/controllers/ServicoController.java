package com.dtlsilva.mhglavacar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dtlsilva.mhglavacar.dto.ServicoDTO;
import com.dtlsilva.mhglavacar.services.ServicoService;

@RestController
@RequestMapping(value = "/servicos")
public class ServicoController {
	
	@Autowired
	private ServicoService service;
	
	@GetMapping()
	public Page<ServicoDTO> findAll(Pageable pageable) {
		Page<ServicoDTO> result = service.findAll(pageable);
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public ServicoDTO findById(@PathVariable Long id) {
		ServicoDTO result = service.findById(id);
		return result;
	}
}
