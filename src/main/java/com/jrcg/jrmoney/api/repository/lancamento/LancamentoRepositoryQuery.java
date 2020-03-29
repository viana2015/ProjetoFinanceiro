package com.jrcg.jrmoney.api.repository.lancamento;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jrcg.jrmoney.api.dto.LancamentoEstatisticaCategoria;
import com.jrcg.jrmoney.api.dto.LancamentoEstatisticaDia;
import com.jrcg.jrmoney.api.dto.LancamentoEstatisticaPessoa;
import com.jrcg.jrmoney.api.model.Lancamento;
import com.jrcg.jrmoney.api.repository.filter.LancamentoFilter;
import com.jrcg.jrmoney.api.repository.projection.ResumoLancamento;

public interface LancamentoRepositoryQuery {
	
	public List<LancamentoEstatisticaPessoa> porPessoa(LocalDate inicio, LocalDate fim);
	public List<LancamentoEstatisticaCategoria> porCategoria(LocalDate mesReferencia);
	public List<LancamentoEstatisticaDia> porDia(LocalDate mesReferencia);

	public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
	public Page<ResumoLancamento> resumir(LancamentoFilter lancamentoFilter, Pageable pageable);
}
