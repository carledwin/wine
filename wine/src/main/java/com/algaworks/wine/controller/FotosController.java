package com.algaworks.wine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.algaworks.wine.dto.Foto;
import com.algaworks.wine.service.CadastroVinhoService;

/**
 * Para trabalhar com json e javascript
 * utilizando o recurso /fotos
 * @author carledwin
 *
 */
@RestController
@RequestMapping("/fotos")
public class FotosController {
	
	
	@Autowired
	private CadastroVinhoService cadastroVinhoService;
	
	//nome da variavel files[]
	@RequestMapping(value="/{codigo}", method=RequestMethod.POST)
	public Foto upload(@PathVariable Long codigo, @RequestParam("files[]") MultipartFile[] files){
		cadastroVinhoService.adicionarFoto(codigo, files[0].getOriginalFilename());
		return new Foto(files[0].getOriginalFilename());
	}
}
