package br.com.blackmarket.controller;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.Valid;

import br.com.blackmarket.annotations.Public;
import br.com.blackmarket.dao.AlunoDao;
import br.com.blackmarket.model.Aluno;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class AlunoController {
	
	private final Result result;
	private final AlunoDao dao;
	private final Validator validator;
	private final EntityManager em;
	
	@Inject
	public AlunoController(Result result, AlunoDao dao, Validator validator, EntityManager em){
		this.result = result;
		this.dao = dao;
		this.validator = validator;
		this.em = em;
	}
	
	public AlunoController(){
		this(null, null, null, null);
	}
	
	@Public
	@Get
	public void lista(){
		result.include("alunoList", dao.lista());
	}
	
	@Get
	public void formulario(){}

	@Post
	public void adiciona(@Valid Aluno aluno){
		validator.onErrorForwardTo(ErroController.class).erro();
		em.getTransaction().begin();
		em.persist(aluno);
		em.getTransaction().commit();
		result.include("message", "ALUNO ADICIONADO");
		result.redirectTo(this).lista();
	}

	@Delete
	public void remove(@Valid Long id){
		validator.onErrorForwardTo(ErroController.class).erro();
	    dao.remove(id);
	    result.include("message", "ALUNO REMOVIDO");
	    result.redirectTo(this).lista();
	}
	
	@Post
	public Aluno editar(Long id){
		return dao.busca(id);
	}
	
	@Put
	public void altera(@Valid Aluno aluno) {
		validator.onErrorForwardTo(ErroController.class).erro();
		
		em.getTransaction().begin();
	    em.merge(aluno);
	    em.getTransaction().commit();
	    
		result.include("message", "ALUNO ALTERADO");
		result.redirectTo(this).lista();
	 }
}
