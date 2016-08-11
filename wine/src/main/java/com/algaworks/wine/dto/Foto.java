package com.algaworks.wine.dto;

/**
 * DTO data transfer objects entre camadas
 * @author carledwin
 *
 */
public class Foto {

	private String url;

	public Foto(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
