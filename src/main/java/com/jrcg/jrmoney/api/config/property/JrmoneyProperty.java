package com.jrcg.jrmoney.api.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("jrmoney")
public class JrmoneyProperty {

	private String oringenPermitida = "http://localhost:8000";
	
	
	public String getOringenPermitida() {
		return oringenPermitida;
	}

	public void setOringenPermitida(String oringenPermitida) {
		this.oringenPermitida = oringenPermitida;
	}

	private final Seguranca seguranca = new Seguranca();
	
	public Seguranca getSeguranca() {
		return seguranca;
	}

	public static class Seguranca {
		
		private boolean enableHttps;

		public boolean isEnableHttps() {
			return enableHttps;
		}

		public void setEnableHttps(boolean enableHttps) {
			this.enableHttps = enableHttps;
		}
		
		
	}
}
