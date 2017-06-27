package br.com.blackmarket.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.blackmarket.model.Computador;

@RequestScoped
public class ComputadorDao {

	private final EntityManager em;

	@Inject
	public ComputadorDao(EntityManager em) {
		this.em = em;
	}
	
	public ComputadorDao(){
		this(null);
		
	}

	public void adiciona(Computador computador) {
		em.getTransaction().begin();
		em.persist(computador);
		em.getTransaction().commit();
	}

	public void remove(Long id) {
		em.getTransaction().begin();
		em.remove(busca(id));
		em.getTransaction().commit();
	}
	
	public Computador carrega(Computador computador) {
		return em.find(Computador.class, computador.getId());
	}
	
	public Computador atualiza(Computador computador) {
		em.getTransaction().begin();
		Computador c = em.merge(computador);
		em.getTransaction().commit();
		return c;
	}
	
	public Computador busca(Computador computador) {
		return em.find(Computador.class, computador.getId());
	}
	
	public Computador busca(Long id) {
		return em.find(Computador.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Computador> lista() {
		return em.createQuery("select c from Computador c").getResultList();
	}
}