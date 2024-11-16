package com.dtlsilva.mhglavacar.services;

import com.dtlsilva.mhglavacar.dto.PessoaDTO;
import com.dtlsilva.mhglavacar.entidades.pessoas.Pessoa;
import com.dtlsilva.mhglavacar.repositories.PessoaRepository;
import com.dtlsilva.mhglavacar.services.exceptions.DatabaseException;
import com.dtlsilva.mhglavacar.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    @Transactional(readOnly = true)
    public Page<PessoaDTO> findAll(Pageable pageable) {
        Page<Pessoa> pessoas = repository.findAll(pageable);
        return pessoas.map(x -> new PessoaDTO(x));
    }

    @Transactional(readOnly = true)
    public PessoaDTO findById(Long id) {
        Optional<Pessoa> result = repository.findById(id);
        Pessoa pessoa = result.orElseThrow(
                () -> new ResourceNotFoundException("Pessoa não encontrada"));
        PessoaDTO dto = new PessoaDTO(pessoa);
        return dto;
    }

    @Transactional
    public PessoaDTO insert(PessoaDTO dto) {
        Pessoa entity = new Pessoa();
        dtoToEntity(dto, entity);
        entity = repository.save(entity);
        entity.setDataCadastro(Instant.now());
        return new PessoaDTO(entity);
    }

    @Transactional
    public PessoaDTO update(Long id, PessoaDTO dto) {
        try {
            Pessoa entity = repository.getReferenceById(id);
            dtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new PessoaDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Serviço não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        try {
            if (!repository.existsById(id)) {
                throw new ResourceNotFoundException("Serviço não encontrado");
            }
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private void dtoToEntity(PessoaDTO dto, Pessoa entity) {
        entity.setNomePessoa(dto.getNomePessoa());
        entity.setTelefone(dto.getTelefone());
        entity.setEmail(dto.getEmail());
    }

}
