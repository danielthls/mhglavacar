package com.dtlsilva.mhglavacar.controllers;

import com.dtlsilva.mhglavacar.dto.PessoaDTO;
import com.dtlsilva.mhglavacar.services.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;


@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @GetMapping()
    public ResponseEntity<Page<PessoaDTO>> findAll(Pageable pageable) {
        Page<PessoaDTO> result = service.findAll(pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaDTO> findById(@PathVariable Long id) {
        PessoaDTO result = service.findById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> insert(@Valid @RequestBody PessoaDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getIdPessoa()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PessoaDTO> update(@PathVariable Long id, @RequestBody PessoaDTO dto) {
        PessoaDTO result = service.update(id, dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}