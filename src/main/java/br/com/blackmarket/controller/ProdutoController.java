package br.com.blackmarket.controller;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.Valid;

import br.com.blackmarket.annotations.Public;
import br.com.blackmarket.dao.ProdutoDao;
import br.com.blackmarket.model.Produto;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.eti.clairton.repository.Repository;

@Controller
public class ProdutoController {
	
	private final Result result;
	private final ProdutoDao dao;
	private final Validator validator;
	private final Repository repository;
	private final EntityManager em;
	
	@Inject
	public ProdutoController(Result result, ProdutoDao dao, Validator validator, Repository repository, EntityManager em){
		this.result = result;
		this.dao = dao;
		this.validator = validator;
		this.repository = repository;
		this.em = em;
	}
	
	public ProdutoController(){
		this(null, null, null, null, null);
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
		em.getTransaction().begin();
		repository.persist(produto);
		em.getTransaction().commit();
		result.include("message", "PRODUTO ADICIONADO");
		result.redirectTo(this).lista();
	}

	@Delete
	public void remove(@Valid Long id){
		validator.onErrorForwardTo(this).formulario();
		Produto produto = repository.byId(Produto.class, id);
		em.getTransaction().begin();
	    repository.remove(produto);
	    em.getTransaction().commit();
	    result.include("message", "PRODUTO REMOVIDO");
		result.redirectTo(this).lista();
	}
	
	@Post
	public Produto editar(Long id){
		return dao.busca(id);
	}
	
	@Put
	public void altera(@Valid Produto produto) {
		validator.onErrorForwardTo(this).lista();
		
		em.getTransaction().begin();
	    em.merge(produto);
	    em.getTransaction().commit();
	    
		result.include("message", "PRODUTO ALTERADO");
		result.redirectTo(this).lista();
	 }
}
