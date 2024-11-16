package com.dtlsilva.mhglavacar.entidades.veiculos;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.dtlsilva.mhglavacar.entidades.pessoas.Pessoa;
import com.dtlsilva.mhglavacar.entidades.pessoas.Usuario;
import com.dtlsilva.mhglavacar.entidades.servicos.OrdemServico;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_veiculos")
public class Veiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataCadastro;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataUltimaModificacao;

	private String usuarioUltimaModificacao;
	
	private String modelo;
	private String placa;
	private String cor;
	private Integer ano;
	
	@ManyToOne
	@JoinColumn(name = "id_pessoa")
	private Pessoa cliente;
	
	@ManyToOne
	@JoinColumn(name = "id_marca")
	private Marca marca;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	
	@OneToMany(mappedBy = "veiculo")
	private List<OrdemServico> ordens = new ArrayList<>();
	
	public Veiculo() {}

	public Veiculo(Long id, String modelo, String placa, String cor, Integer ano, Pessoa proprietario, Marca marca, Categoria categoria) {
		this.id = id;
		this.modelo = modelo;
		this.placa = placa;
		this.cor = cor;
		this.ano = ano;
		this.cliente = proprietario;
		this.marca = marca;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public List<OrdemServico> getOrdens() {
		return ordens;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, placa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		return Objects.equals(id, other.id) && Objects.equals(placa, other.placa);
	}
	
	
}
