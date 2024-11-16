package com.dtlsilva.mhglavacar.entidades.veiculos;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.dtlsilva.mhglavacar.entidades.pessoas.Usuario;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_marcas")
public class Marca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataCadastro;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataUltimaModificacao;

	private String usuarioUltimaModificacao;

	@OneToMany(mappedBy = "marca")
	private List<Veiculo> veiculos = new ArrayList<>();
	
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
		Marca other = (Marca) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

	public Marca() {}

	public Marca(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}
	
	
	
	
}
