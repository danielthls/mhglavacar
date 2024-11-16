package com.dtlsilva.mhglavacar.services;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dtlsilva.mhglavacar.dto.ServicoDTO;
import com.dtlsilva.mhglavacar.entidades.servicos.Servico;
import com.dtlsilva.mhglavacar.repositories.ServicoRepository;
import com.dtlsilva.mhglavacar.services.exceptions.DatabaseException;
import com.dtlsilva.mhglavacar.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ServicoService {
	@Autowired
	private ServicoRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ServicoDTO> findAll(Pageable pageable) { 
		Page<Servico> servicos = repository.findAll(pageable);
		return servicos.map(x -> new ServicoDTO(x));
	}
	
	@Transactional(readOnly = true)
	public ServicoDTO findById(Long id) {
		Optional<Servico> result = repository.findById(id);
		Servico servico = result.orElseThrow(
				() -> new ResourceNotFoundException("Serviço não encontrado"));
		ServicoDTO dto = new ServicoDTO(servico);
		return dto;
	}
	
	@Transactional
	public ServicoDTO insert(ServicoDTO dto) {
		Servico entity = new Servico();
		dtoToEntity(dto, entity);
		entity.setDataCadastro(Instant.now());
		entity = repository.save(entity);
		return new ServicoDTO(entity);
	}
	
	@Transactional
	public ServicoDTO update(Long id, ServicoDTO dto) {
		try {
			Servico entity = repository.getReferenceById(id);
			dtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new ServicoDTO(entity);
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
	
	private void dtoToEntity(ServicoDTO dto, Servico entity) {
		entity.setNome(dto.getNome());
		entity.setDescricao(dto.getDescricao());
	}
}
