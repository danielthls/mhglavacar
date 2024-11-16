package com.dtlsilva.mhglavacar.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dtlsilva.mhglavacar.dto.ServicoDTO;
import com.dtlsilva.mhglavacar.services.ServicoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/servicos")
public class ServicoController {
	
	@Autowired
	private ServicoService service;
	
	@GetMapping()
	public ResponseEntity<Page<ServicoDTO>> findAll(Pageable pageable) {
		Page<ServicoDTO> result = service.findAll(pageable);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ServicoDTO> findById(@PathVariable Long id) {
		ServicoDTO result = service.findById(id);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping
	public ResponseEntity<ServicoDTO> insert(@Valid @RequestBody ServicoDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ServicoDTO> update(@PathVariable Long id, @RequestBody ServicoDTO dto) {
		ServicoDTO result = service.update(id, dto);
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
