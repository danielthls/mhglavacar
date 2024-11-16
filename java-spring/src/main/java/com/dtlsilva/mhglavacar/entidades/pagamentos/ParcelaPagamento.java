package com.dtlsilva.mhglavacar.entidades.pagamentos;

import java.time.Instant;
import java.util.Objects;

import com.dtlsilva.mhglavacar.entidades.pessoas.Pessoa;

import com.dtlsilva.mhglavacar.entidades.pessoas.Usuario;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_parcelas_pagamento")
public class ParcelaPagamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant dataVencimento;
	private Instant dataPagamento;
	private Integer numeroParcela;
	private Double valor;
	
	@ManyToOne
	@JoinColumn(name = "id_pagamento")
	private Pagamento pagamento;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataCadastro;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataUltimaModificacao;

	private String usuarioUltimaModificacao;
	
	public ParcelaPagamento() {}

	public ParcelaPagamento(Long id, Instant dataVencimento, Instant dataPagamento, Pagamento pagamento, Integer numeroParcela, Double valor) {
		super();
		this.id = id;
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
		this.pagamento = pagamento;
		this.numeroParcela = numeroParcela;
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Instant dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Instant getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Instant dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	
	public Integer getNumeroParcela() {
		return numeroParcela;
	}

	public void setNumeroParcela(Integer numeroParcela) {
		this.numeroParcela = numeroParcela;
	}
	
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
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
		ParcelaPagamento other = (ParcelaPagamento) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
