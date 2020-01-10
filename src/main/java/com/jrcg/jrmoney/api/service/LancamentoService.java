package com.jrcg.jrmoney.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrcg.jrmoney.api.model.Lancamento;
import com.jrcg.jrmoney.api.model.Pessoa;
import com.jrcg.jrmoney.api.repository.LancamentoRepository;
import com.jrcg.jrmoney.api.repository.PessoaRepository;
import com.jrcg.jrmoney.api.service.exception.PessoaInexistenteOuInativaException;

@Service
public class LancamentoService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	public Lancamento salvar(Lancamento lancamento) {
		Optional<Pessoa>  pessoaSalva = pessoaRepository.findById(Optional.ofNullable(lancamento.getPessoa().getCodigo()).orElse(0L));	
		if(!pessoaSalva.isPresent() || !pessoaSalva.get().getAtivo()){
			throw new PessoaInexistenteOuInativaException();
			
		}
				
				return lancamentoRepository.save(lancamento);
	}

	
	
}
