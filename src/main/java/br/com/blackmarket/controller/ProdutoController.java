package br.com.blackmarket.controller;

import javax.inject.Inject;
import javax.validation.Valid;
import br.com.blackmarket.annotations.Public;
import br.com.blackmarket.dao.ProdutoDao;
import br.com.blackmarket.model.Produto;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
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
	
	@Public
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

	@Delete
	public void remove(@Valid Long id){
		validator.onErrorForwardTo(this).formulario();
	    dao.remove(id);
	    result.include("message", "PRODUTO REMOVIDO");
		result.redirectTo(this).lista();
	}
	
	@Post
	public Produto editar(Long id){
		return dao.busca(id);
		
	}
	
	@Post
	public void altera(@Valid Produto produto) {
		validator.onErrorForwardTo(this).lista();
		result.include("message", "ERRO! PRODUTO NÃO ALTERADO");
	    produto = dao.atualiza(produto);
		result.include("message", "PRODUTO ALTERADO");
		result.redirectTo(this).lista();
	 }
	

}
