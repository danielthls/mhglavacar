package com.dtlsilva.mhglavacar.dto;

import com.dtlsilva.mhglavacar.entidades.servicos.Servico;

public class ServicoDTO {
	private Long id;
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
