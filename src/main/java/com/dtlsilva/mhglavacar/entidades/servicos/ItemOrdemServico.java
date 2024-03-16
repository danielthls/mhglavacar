package com.dtlsilva.mhglavacar.entidades.servicos;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_itens_ordem")
public class ItemOrdemServico {
	
	@EmbeddedId
	private ItemOrdemServicoPK id = new ItemOrdemServicoPK();
	
	private Double preco;
	
	public ItemOrdemServico() {}

	public ItemOrdemServico(Servico servico, OrdemServico ordemServico, Double preco) {
		id.setOrdem(ordemServico);
		id.setServico(servico);
		this.preco = preco;
	}

	public OrdemServico getOrdem() {
		return id.getOrdem();
	}
	
	public Servico getServico() {
		return id.getServico();
	}
	
	public void setOrdem(OrdemServico ordem) {
		id.setOrdem(ordem);
	}
	
	public void setServico(Servico servico) {
		id.setServico(servico);
	}
	
	public Double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		preco = preco;
	}
	
	
	
	
}
