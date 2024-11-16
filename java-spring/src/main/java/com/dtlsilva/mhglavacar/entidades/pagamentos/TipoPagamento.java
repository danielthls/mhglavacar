package com.dtlsilva.mhglavacar.entidades.pagamentos;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.dtlsilva.mhglavacar.entidades.pessoas.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tipos_pagamento")
public class TipoPagamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@Column(columnDefinition = "TEXT")
	private String observacao;
	
	@OneToMany(mappedBy = "tipo")
	private List<Pagamento> pagamentos = new ArrayList<Pagamento>();

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataCadastro;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataUltimaModificacao;

	private String usuarioUltimaModificacao;

	public TipoPagamento() {}

	public TipoPagamento(Long id, String nome, String observacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.observacao = observacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoPagamento other = (TipoPagamento) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
