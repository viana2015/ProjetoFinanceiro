package com.jrcg.jrmoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jrcg.jrmoney.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
