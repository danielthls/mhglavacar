package com.dtlsilva.mhglavacar.entidades.pessoas;

import com.dtlsilva.mhglavacar.entidades.servicos.OrdemServico;
import com.dtlsilva.mhglavacar.entidades.servicos.Servico;
import com.dtlsilva.mhglavacar.entidades.veiculos.Veiculo;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class PessoaAutorizadaPK {

    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "id_veiculo")
    private Veiculo veiculo;

    public PessoaAutorizadaPK() {}

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}
