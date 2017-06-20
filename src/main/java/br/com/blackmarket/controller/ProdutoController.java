package br.com.blackmarket.controller;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import br.com.blackmarket.dao.ProdutoDao;
import br.com.blackmarket.model.Produto;
import br.com.blackmarket.util.JPAUtil;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;

@Controller
public class ProdutoController {
	
	private final Result result;
	
	@Inject
	public ProdutoController(Result result){
		this.result = result;
	}
	
	public ProdutoController(){
		this(null);
	}
	
	@Get("/")
	public void inicio(){}
	
	@Get
	public void lista(){
		EntityManager em = JPAUtil.criaEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		List<Produto> lista = produtoDao.lista();
		result.include(lista);
	}
	
	@Get
	public void formulario(){}

	@Post
	public void adiciona(Produto produto){
		EntityManager em = JPAUtil.criaEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		em.getTransaction().begin();
		produtoDao.adiciona(produto);
		em.getTransaction().commit();
		result.include("message", "PRODUTO ADICIONADO");
		result.redirectTo(this).lista();
	}
}
