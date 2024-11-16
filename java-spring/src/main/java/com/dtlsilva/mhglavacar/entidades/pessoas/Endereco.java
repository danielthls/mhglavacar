package com.dtlsilva.mhglavacar.entidades.pessoas;

import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_enderecos")
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEndereco;
	private String logradouro;
	private String numero;
	private Integer cep;
	private String complemento;
	private String referencia;

	private String descricao;

	@ManyToOne
	@JoinColumn(name = "id_municipio")
	private Municipio municipio;

	@ManyToOne
	@JoinColumn(name = "id_pessoa")
	private Pessoa residente;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataCadastro;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataUltimaModificacao;

	private String usuarioUltimaModificacao;

	public Endereco() {

	}

	public Endereco(Long idEndereco, String logradouro, String numero, Integer cep, String complemento, String referencia, String descricao,
					Municipio municipio, Pessoa residente) {
		this.idEndereco = idEndereco;
		this.logradouro = logradouro;
		this.numero = numero;
		this.cep = cep;
		this.complemento = complemento;
		this.referencia = referencia;
		this.municipio = municipio;
		this.residente = residente;
		this.descricao = descricao;
	}

	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public Pessoa getResidente() {
		return residente;
	}

	public void setResidente(Pessoa residente) {
		this.residente = residente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEndereco, residente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(idEndereco, other.idEndereco) && Objects.equals(residente, other.residente);
	}

}
