package com.dtlsilva.mhglavacar.dto;

import com.dtlsilva.mhglavacar.entidades.pessoas.Pessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PessoaDTO {
    private Long idPessoa;

    @Size(min = 3, max = 40, message = "Nome precisa ter entre 3 e 80 caracteres")
    @NotBlank(message = "Campo requerido")
    private String nomePessoa;

    private String telefone;
    private String email;

    public PessoaDTO(Long idPessoa, String nomePessoa, String telefone, String email) {
        this.idPessoa = idPessoa;
        this.nomePessoa = nomePessoa;
        this.telefone = telefone;
        this.email = email;
    }

    public PessoaDTO(Pessoa obj) {
        this.idPessoa = obj.getIdPessoa();
        this.nomePessoa = obj.getNomePessoa();
        this.telefone = obj.getTelefone();
        this.email = obj.getEmail();
    }


    public long getIdPessoa() {
        return idPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
}
