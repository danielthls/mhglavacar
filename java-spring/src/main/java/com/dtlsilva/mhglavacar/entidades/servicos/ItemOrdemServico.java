package com.dtlsilva.mhglavacar.entidades.servicos;

import com.dtlsilva.mhglavacar.entidades.pessoas.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "tb_itens_ordem")
public class ItemOrdemServico {
	
	@EmbeddedId
	private ItemOrdemServicoPK id = new ItemOrdemServicoPK();
	
	private Double preco;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataCadastro;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataUltimaModificacao;

	private String usuarioUltimaModificacao;
	
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
