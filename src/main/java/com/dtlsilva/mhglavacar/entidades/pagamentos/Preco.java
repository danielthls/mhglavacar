package com.dtlsilva.mhglavacar.entidades.pagamentos;

import com.dtlsilva.mhglavacar.entidades.servicos.OrdemServico;
import com.dtlsilva.mhglavacar.entidades.servicos.Servico;
import com.dtlsilva.mhglavacar.entidades.veiculos.Categoria;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_precos")
public class Preco {
	@EmbeddedId
	private PrecoPK id = new PrecoPK();
	
	private Double preco;

	public Preco(Servico servico, Categoria categoria, Double preco) {
		this.id.setServico(servico);
		this.id.setCategoria(categoria);
		this.preco = preco;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public Categoria getCategoria() {
		return id.getCategoria();
	}
	
	public Servico getServico() {
		return id.getServico();
	}
	
	public void setCategoria(Categoria categoria) {
		id.setCategoria(categoria);
	}
	
	public void setServico(Servico servico) {
		id.setServico(servico);
	}
	
	
}
