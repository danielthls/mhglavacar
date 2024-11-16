package com.dtlsilva.mhglavacar.entidades.pagamentos;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.dtlsilva.mhglavacar.entidades.pessoas.Endereco;
import com.dtlsilva.mhglavacar.entidades.pessoas.Usuario;
import com.dtlsilva.mhglavacar.entidades.servicos.OrdemServico;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pagamentos")
public class Pagamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
			
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant momento;
	private Integer numeroParcelas;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_pagamento")
	private TipoPagamento tipo;

	@OneToMany(mappedBy = "pagamento")
	private List<ParcelaPagamento> parcelas = new ArrayList();
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "id_ordem")
	private OrdemServico ordemServico;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataCadastro;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataUltimaModificacao;

	private String usuarioUltimaModificacao;
	
	public Pagamento() {}

	public Pagamento(Long id, Instant momento, Integer numeroParcelas, TipoPagamento tipo,
			OrdemServico ordemServico) {
		super();
		this.id = id;
		this.momento = momento;
		this.numeroParcelas = numeroParcelas;
		this.tipo = tipo;
		this.ordemServico = ordemServico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}

	public TipoPagamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoPagamento tipo) {
		this.tipo = tipo;
	}

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public List<ParcelaPagamento> getParcelas() {
		return parcelas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, ordemServico);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		return Objects.equals(id, other.id) && Objects.equals(ordemServico, other.ordemServico);
	}
	
	
	
	
	
}
