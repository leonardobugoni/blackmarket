package br.com.blackmarket.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.blackmarket.model.Produto;

@RequestScoped
public class ProdutoDao {

	private final EntityManager em;

	@Inject
	public ProdutoDao(EntityManager em) {
		this.em = em;
	}
	
	public ProdutoDao(){
		this(null);
		
	}

	public void adiciona(Produto produto) {
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
	}

	public void remove(Long id) {
		em.getTransaction().begin();
		em.remove(busca(id));
		em.getTransaction().commit();
	}
	
	public Produto carrega(Produto produto) {
		return em.find(Produto.class, produto.getId());
	}
	
	public Produto atualiza(Produto produto) {
		em.getTransaction().begin();
		Produto p = em.merge(produto);
		em.getTransaction().commit();
		return p;
	}
	
	public Produto busca(Produto produto) {
		return em.find(Produto.class, produto.getId());
	}
	
	public Produto busca(Long id) {
		return em.find(Produto.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Produto> lista() {
		return em.createQuery("select p from Produto p").getResultList();
	}
}