package com.dtlsilva.mhglavacar.entidades.servicos;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ItemOrdemServicoPK {
	@ManyToOne
	@JoinColumn(name = "id_ordem")
	private OrdemServico ordem;
	
	@ManyToOne
	@JoinColumn(name = "id_servico")
	private Servico servico;
	
	public ItemOrdemServicoPK() {}

	public OrdemServico getOrdem() {
		return ordem;
	}

	public void setOrdem(OrdemServico ordem) {
		this.ordem = ordem;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}
	
	
}
