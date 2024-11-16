package com.dtlsilva.mhglavacar.entidades.servicos;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.dtlsilva.mhglavacar.entidades.pagamentos.Preco;
import com.dtlsilva.mhglavacar.entidades.pessoas.Usuario;
import com.dtlsilva.mhglavacar.entidades.veiculos.Categoria;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_servicos")
public class Servico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@Column(columnDefinition = "TEXT")
	private String descricao;
	
	@OneToMany(mappedBy = "id.servico")
	private Set<ItemOrdemServico> itens = new HashSet<>();
	
	@OneToMany(mappedBy = "id.servico")
	private Set<Preco> precos = new HashSet<>();

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataCadastro;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataUltimaModificacao;

	private String usuarioUltimaModificacao;
	
	public Servico() {}

	public Servico(Long id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<ItemOrdemServico> getItens() {
		return itens;
	}

	public Set<Preco> getPrecos() {
		return precos;
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

	public String getUsuarioUltimaModificacao() {
		return usuarioUltimaModificacao;
	}

	public void setUsuarioUltimaModificacao(String usuarioUltimaModificacao) {
		this.usuarioUltimaModificacao = usuarioUltimaModificacao;
	}

	public List<Categoria> getCategoria() {
		return precos
				.stream()
				.map(x -> x.getCategoria())
				.toList();
	}
	
	public List<OrdemServico> getOrdemServico() {
		return itens
				.stream()
				.map(x -> x.getOrdem())
				.toList();
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
		Servico other = (Servico) obj;
		return Objects.equals(id, other.id);
	}	
	
}
