package com.dtlsilva.mhglavacar.entidades.veiculos;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.dtlsilva.mhglavacar.entidades.pagamentos.Preco;
import com.dtlsilva.mhglavacar.entidades.pessoas.Usuario;
import com.dtlsilva.mhglavacar.entidades.servicos.Servico;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_categorias")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@Column(columnDefinition = "TEXT")
	private String descricao;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataCadastro;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataUltimaModificacao;

	private String usuarioUltimaModificacao;

	@OneToMany(mappedBy = "categoria")
	private List<Veiculo> veiculos = new ArrayList();
	
	@OneToMany(mappedBy = "id.categoria")
	private Set<Preco> precos = new HashSet<>();
	
	public Categoria() {}

	public Categoria(Long id, String nome, String descricao) {
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

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}
	
	public List<Servico> getServicos() {
		return precos
				.stream()
				.map(x -> x.getServico())
				.toList();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}
	
	
	
}
