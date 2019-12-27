package com.jrcg.jrmoney.api.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

// meu evento para adcionar o rader locaions e que irá ser lançado pela classe RecusoCriadoListener
public class RecursoCriadoEvent extends ApplicationEvent {
	private static final long serialVersionUID = 1L;

	private HttpServletResponse response;
	private Long codigo;
	
	public RecursoCriadoEvent(Object source, HttpServletResponse response, Long codigo) {
		super(source);
		this.response = response;
		this.codigo = codigo;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public Long getCodigo() {
		return codigo;
	}
		
	
}
