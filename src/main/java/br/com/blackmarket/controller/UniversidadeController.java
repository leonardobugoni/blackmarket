package br.com.blackmarket.controller;

import br.com.blackmarket.annotations.Public;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;

@Controller
public class UniversidadeController {

	
	
	@Public
	@Get("/")
	public void inicio(){}
}
