package com.dtlsilva.mhglavacar.entidades.pessoas;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.dtlsilva.mhglavacar.entidades.veiculos.Veiculo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pessoas")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPessoa;

	private String nomePessoa;
	private String telefone;
	private String email;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataCadastro;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataUltimaModificacao;

	private String usuarioUltimaModificacao;

	@OneToMany(mappedBy = "residente")
	private List<Endereco> enderecos = new ArrayList();

	@OneToMany(mappedBy = "pessoa")
	private List<Usuario> usuarios = new ArrayList();
	
	@OneToMany(mappedBy = "cliente")
	private List<Veiculo> veiculos = new ArrayList();

	public Pessoa() {
	}

	public Pessoa(Long idPessoa, String nomePessoa, String telefone, String email) {
		super();
		this.idPessoa = idPessoa;
		this.nomePessoa = nomePessoa;
		this.telefone = telefone;
		this.email = email;
	}

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Instant getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Instant dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPessoa, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(idPessoa, other.idPessoa) && Objects.equals(telefone, other.telefone);
	}

}
