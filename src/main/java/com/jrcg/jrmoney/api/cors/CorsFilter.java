package com.jrcg.jrmoney.api.cors;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.jrcg.jrmoney.api.config.property.JrmoneyProperty;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter{

	@Autowired
	private JrmoneyProperty jrmoneyProperty; 	
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		// Estes dois Headers esta fora do if pois eles sempre sao requiridos.
		response.setHeader("Access-Control-Allow-Origin", jrmoneyProperty.getOringenPermitida());
		response.setHeader("Access-Control-Allow-Credentials", "true");
		
			// Se a origen permitida for igual ao do Browser e for uma requisicao OPTIONS  permiti.
		if ("OPTIONS".equals(request.getMethod()) && jrmoneyProperty.getOringenPermitida().equals(request.getHeader("Origin"))) {
			response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, OPTIONS");
			response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
			response.setHeader("Access-Control-Allow-Max-Age", "3600");
			
			response.setStatus(HttpServletResponse.SC_OK);
		} else { // Senao for um OPTIONS segue a rotina normal 
			chain.doFilter(req, resp);
		}
		
		
	}

}
