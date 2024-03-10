package com.dtlsilva.mhglavacar.entidades.servicos;

import java.time.Instant;
import java.util.Objects;

import com.dtlsilva.mhglavacar.entidades.pagamentos.Pagamento;
import com.dtlsilva.mhglavacar.entidades.veiculos.Veiculo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_ordens_servico")
public class OrdemServico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant horaEntrada;
	private Instant horaSaida;
	private StatusOrdemServico status;
	
	@OneToOne(mappedBy = "ordemServico", cascade = CascadeType.ALL)
	private Pagamento pagamento;
	
	public OrdemServico() {}

	public OrdemServico(Long id, Instant horaEntrada, Instant horaSaida, StatusOrdemServico status, Veiculo veiculo,
			Pagamento pagamento) {
		super();
		this.id = id;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
		this.status = status;
		this.pagamento = pagamento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(Instant horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public Instant getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(Instant horaSaida) {
		this.horaSaida = horaSaida;
	}

	public StatusOrdemServico getStatus() {
		return status;
	}

	public void setStatus(StatusOrdemServico status) {
		this.status = status;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
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
		OrdemServico other = (OrdemServico) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
