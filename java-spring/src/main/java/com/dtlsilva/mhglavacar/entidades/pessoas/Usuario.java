package com.dtlsilva.mhglavacar.entidades.pessoas;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@Column(unique = true)
	public String usuario;
	public String senha;

	@ManyToOne
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataCadastro;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataUltimaModificacao;


	private String usuarioUltimaModificacao;

	public Usuario() {
	}

	public Usuario(Long id, String usuario, String senha, Pessoa pessoa) {
		this.id = id;
		this.usuario = usuario;
		this.senha = senha;
		this.pessoa = pessoa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Instant getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Instant dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Instant getDataUltimaModificacao() {
		return dataUltimaModificacao;
	}

	public void setDataUltimaModificacao(Instant dataUltimaModificacao) {
		this.dataUltimaModificacao = dataUltimaModificacao;
	}
}
