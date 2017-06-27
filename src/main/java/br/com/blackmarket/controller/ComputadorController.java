package br.com.blackmarket.controller;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.Valid;

import br.com.blackmarket.annotations.Public;
import br.com.blackmarket.dao.ProdutoDao;
import br.com.blackmarket.model.Computador;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class ComputadorController {
	
	private final Result result;
	private final ProdutoDao dao;
	private final Validator validator;
	private final EntityManager em;
	
	@Inject
	public ComputadorController(Result result, ProdutoDao dao, Validator validator, EntityManager em){
		this.result = result;
		this.dao = dao;
		this.validator = validator;
		this.em = em;
	}
	
	public ComputadorController(){
		this(null, null, null, null);
	}
	
	@Public
	@Get("/")
	public void inicio(){}
	
	@Get
	public void lista(){
		result.include("computadorList", dao.lista());
	}
	
	@Get
	public void formulario(){}

	@Post
	public void adiciona(@Valid Computador computador){
		validator.onErrorForwardTo(this).formulario();
		em.getTransaction().begin();
		em.persist(computador);
		em.getTransaction().commit();
		result.include("message", "PRODUTO ADICIONADO");
		result.redirectTo(this).lista();
	}

	@Delete
	public void remove(@Valid Computador computador){
		validator.onErrorForwardTo(this).formulario();
		em.getTransaction().begin();
	    em.remove(computador);
	    em.getTransaction().commit();
	    result.include("message", "COMPUTADOR REMOVIDO");
		result.redirectTo(this).lista();
	}
	
	@Post
	public Computador editar(Long id){
		return dao.busca(id);
	}
	
	@Put
	public void altera(@Valid Computador computador) {
		validator.onErrorForwardTo(this).lista();
		
		em.getTransaction().begin();
	    em.merge(computador);
	    em.getTransaction().commit();
	    
		result.include("message", "COMPUTADOR ALTERADO");
		result.redirectTo(this).lista();
	 }
}
