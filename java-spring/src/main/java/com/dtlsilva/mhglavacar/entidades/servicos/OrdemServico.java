package com.dtlsilva.mhglavacar.entidades.servicos;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.dtlsilva.mhglavacar.entidades.pagamentos.Pagamento;
import com.dtlsilva.mhglavacar.entidades.pessoas.Usuario;
import com.dtlsilva.mhglavacar.entidades.veiculos.Veiculo;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_ordens_servico")
public class OrdemServico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant horaEntrada;
	private Instant horaSaida;
	private StatusOrdemServico status;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataCadastro;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataUltimaModificacao;

	private String usuarioUltimaModificacao;
	
	@ManyToOne
	@JoinColumn(name = "id_veiculo")
	private Veiculo veiculo;
	
	@OneToOne(mappedBy = "ordemServico", cascade = CascadeType.ALL)
	private Pagamento pagamento;
	
	@OneToMany(mappedBy = "id.ordem")
	private Set<ItemOrdemServico> itens = new HashSet<>();		
	
	public OrdemServico() {}

	public OrdemServico(Long id, Instant horaEntrada, Instant horaSaida, StatusOrdemServico status, Veiculo veiculo,
			Pagamento pagamento) {
		super();
		this.id = id;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
		this.status = status;
		this.pagamento = pagamento;
		this.veiculo = veiculo;
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
	
	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<Servico> getServico() {
		return itens
				.stream()
				.map(x -> x.getServico())
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
		OrdemServico other = (OrdemServico) obj;
		return Objects.equals(id, other.id);
	}

	public double getTotal() {
		return itens
				.stream()
				.map(x -> x.getPreco())
				.reduce(0.0,(x,y) -> x + y);
	}
	
}
