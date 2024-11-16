package com.dtlsilva.mhglavacar.repositories;

import com.dtlsilva.mhglavacar.entidades.pessoas.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}