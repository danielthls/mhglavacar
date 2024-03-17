package com.dtlsilva.mhglavacar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dtlsilva.mhglavacar.dto.ServicoDTO;
import com.dtlsilva.mhglavacar.entidades.servicos.Servico;
import com.dtlsilva.mhglavacar.repositories.ServicoRepository;

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
		Servico servico = result.get();
		ServicoDTO dto = new ServicoDTO(servico);
		return dto;
	}
	
	@Transactional
	public ServicoDTO insert(ServicoDTO dto) {
		Servico entity = new Servico();
		dtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ServicoDTO(entity);
	}
	
	@Transactional
	public ServicoDTO update(Long id, ServicoDTO dto) {
		Servico entity = repository.getReferenceById(id);
		dtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ServicoDTO(entity);
	}
	
	private void dtoToEntity(ServicoDTO dto, Servico entity) {
		entity.setNome(dto.getNome());
		entity.setDescricao(dto.getDescricao());
	}
}
