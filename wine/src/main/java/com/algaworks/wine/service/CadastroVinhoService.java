package com.algaworks.wine.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.algaworks.wine.model.Vinho;
import com.algaworks.wine.repository.Vinhos;
import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;

@Service
public class CadastroVinhoService {

	@Autowired
	private Vinhos vinhos;
	
	@Autowired
	private AmazonS3 s3Client;
	
	
	public void salvar(Vinho vinho){
		//Escrever regras de negócio aqui
		vinhos.save(vinho);
	}
	
	public String salvarFoto(Long codigo, MultipartFile foto){
		Vinho vinho = vinhos.findOne(codigo);
		String nomeFoto = foto.getOriginalFilename();
		vinho.setFoto(nomeFoto);
		vinhos.save(vinho);
		
		try {

			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentType(foto.getContentType());
			metadata.setContentLength(foto.getSize());
		
			s3Client.putObject("wine", nomeFoto, foto.getInputStream(), metadata);
		} catch (AmazonClientException | IOException e) {
			throw new RuntimeException("Erro salvando foto no S3.", e);
		}
		return "http://localhost:9444/s3/wine/"+ nomeFoto +"?noAuth=true";
	}
}
