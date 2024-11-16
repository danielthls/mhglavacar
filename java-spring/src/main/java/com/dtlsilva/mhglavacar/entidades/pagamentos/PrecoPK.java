package com.dtlsilva.mhglavacar.entidades.pagamentos;

import com.dtlsilva.mhglavacar.entidades.servicos.Servico;
import com.dtlsilva.mhglavacar.entidades.veiculos.Categoria;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class PrecoPK {
	@ManyToOne
	@JoinColumn(name = "id_servico")
	private Servico servico;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
}
