package br.com.blackmarket.controller;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.blackmarket.dao.ProdutoDao;
import br.com.blackmarket.model.Produto;
import br.com.blackmarket.util.JPAUtil;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;

@Controller
public class ProdutoController {

	@Path("/")
	public void inicio(){} 
	
	@Path("/produto/lista")
	public List<Produto> lista(){
		EntityManager em = JPAUtil.criaEntityManager();
		ProdutoDao dao = new ProdutoDao(em);
		return dao.lista();
	}
	
}
