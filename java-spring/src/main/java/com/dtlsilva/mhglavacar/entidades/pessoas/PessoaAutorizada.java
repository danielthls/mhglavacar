package com.dtlsilva.mhglavacar.entidades.pessoas;

import com.dtlsilva.mhglavacar.entidades.servicos.ItemOrdemServicoPK;
import com.dtlsilva.mhglavacar.entidades.veiculos.Veiculo;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_pessoas_autorizadas")
public class PessoaAutorizada {

    @EmbeddedId
    private PessoaAutorizadaPK id = new PessoaAutorizadaPK();

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dataCadastro;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dataUltimaModificacao;

    private String usuarioUltimaModificacao;

    public PessoaAutorizada(){}

    public PessoaAutorizada(Pessoa pessoa, Veiculo veiculo) {
        this.id.setPessoa(pessoa);
        this.id.setVeiculo(veiculo);
    }

    public Pessoa getPessoa() {
        return id.getPessoa();
    }

    public Veiculo getVeiculo() {
        return id.getVeiculo();
    }

    public void setPessoa(Pessoa pessoa) {
        id.setPessoa(pessoa);
    }

    public void setVeiculo(Veiculo veiculo) {
        id.setVeiculo(veiculo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PessoaAutorizada that = (PessoaAutorizada) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
