package com.jrcg.jrmoney.api.repository.filter;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class LancamentoFilter {

	private String descricao;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate datavencimentoDe;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate datavencimentoAte;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getDatavencimentoDe() {
		return datavencimentoDe;
	}
	public void setDatavencimentoDe(LocalDate datavencimentoDe) {
		this.datavencimentoDe = datavencimentoDe;
	}
	public LocalDate getDatavencimentoAte() {
		return datavencimentoAte;
	}
	public void setDatavencimentoAte(LocalDate datavencimentoAte) {
		this.datavencimentoAte = datavencimentoAte;
	}
	
	
}
