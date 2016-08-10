package com.algaworks.wine.dto;

/**
 * DTO data transfer objects entre camadas
 * @author carledwin
 *
 */
public class Foto {

	private String nome;

	public Foto(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
