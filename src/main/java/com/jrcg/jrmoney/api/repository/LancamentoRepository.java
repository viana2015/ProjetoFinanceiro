package com.jrcg.jrmoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jrcg.jrmoney.api.model.Lancamento;
import com.jrcg.jrmoney.api.repository.lancamento.LancamentoRepositoryQuery;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {

}
