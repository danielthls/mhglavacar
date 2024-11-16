package com.dtlsilva.mhglavacar.dto;

import com.dtlsilva.mhglavacar.entidades.servicos.Servico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ServicoDTO {
	private Long id;
	
	@Size(min = 3, max = 80, message = "Nome precisa ter entre 3 e 80 caracteres")
	@NotBlank(message = "Campo requerido")
	private String nome;
	
	private String descricao;

	public ServicoDTO(Long id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public ServicoDTO(Servico obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

}
