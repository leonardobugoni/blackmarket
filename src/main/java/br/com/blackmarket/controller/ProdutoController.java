package br.com.blackmarket.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.blackmarket.dao.ProdutoDao;
import br.com.blackmarket.model.Produto;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class ProdutoController {
	
	private final Result result;
	private final ProdutoDao dao;
	private final Validator validator; 
	
	@Inject
	public ProdutoController(Result result, ProdutoDao dao, Validator validator){
		this.result = result;
		this.dao = dao;
		this.validator = validator;
	}
	
	public ProdutoController(){
		this(null, null, null);
	}
	
	@Get("/")
	public void inicio(){}
	
	@Get
	public void lista(){
		result.include("produtoList", dao.lista());
	}
	
	@Get
	public void formulario(){}

	@Post
	public void adiciona(@Valid Produto produto){
		validator.onErrorForwardTo(this).formulario();
		dao.adiciona(produto);
		result.include("message", "PRODUTO ADICIONADO");
		result.redirectTo(this).lista();
	}
}
