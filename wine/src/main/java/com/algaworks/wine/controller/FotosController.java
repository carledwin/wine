package com.algaworks.wine.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.algaworks.wine.dto.Foto;

/**
 * Para trabalhar com json e javascript
 * utilizando o recurso /fotos
 * @author carledwin
 *
 */
@RestController
@RequestMapping("/fotos")
public class FotosController {
	
	
	//nome da variavel files[]
	@RequestMapping(value="/{codigo}", method=RequestMethod.POST)
	public Foto upload(@PathVariable Long codigo, @RequestParam("files[]") MultipartFile[] files){
		return new Foto(files[0].getOriginalFilename());
	}
}
