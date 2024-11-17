package com.dtlsilva.mhglavacar.entidades.pessoas;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

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

	@ManyToMany
	@JoinTable(name = "tb_usuarios_roles",
			joinColumns = @JoinColumn(name = "id_usuario"),
			inverseJoinColumns = @JoinColumn(name = "id_role"))
	private Set<Role> roles = new HashSet<>();


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

	public void addRole(Role role) {
		roles.add(role);
	}

	public boolean hasRole(String roleName) {
		return roles.stream()
				.anyMatch(x -> x.getAuthority().equals(roleName));
	}

	public void setDataUltimaModificacao(Instant dataUltimaModificacao) {
		this.dataUltimaModificacao = dataUltimaModificacao;
	}
}
