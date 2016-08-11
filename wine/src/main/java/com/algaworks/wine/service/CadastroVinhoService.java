package com.algaworks.wine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.wine.model.Vinho;
import com.algaworks.wine.repository.Vinhos;

@Service
public class CadastroVinhoService {

	@Autowired
	private Vinhos vinhos;
	
	public void salvar(Vinho vinho){
		//Escrever regras de negócio aqui
		vinhos.save(vinho);
	}
	
	public void adicionarFoto(Long codigo, String nome){
		Vinho vinho = vinhos.findOne(codigo);
		vinho.setFoto(nome);
		vinhos.save(vinho);
	}
}
