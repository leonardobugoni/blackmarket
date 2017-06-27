package br.com.blackmarket.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.blackmarket.model.Professor;


@RequestScoped
public class ProfessorDao {

	private final EntityManager em;

	@Inject
	public ProfessorDao(EntityManager em) {
		this.em = em;
	}
	
	public ProfessorDao(){
		this(null);
		
	}

	public void adiciona(Professor professor) {
		em.getTransaction().begin();
		em.persist(professor);
		em.getTransaction().commit();
	}

	public void remove(Long id) {
		em.getTransaction().begin();
		em.remove(busca(id));
		em.getTransaction().commit();
	}
	
	public Professor carrega(Professor professor) {
		return em.find(Professor.class, professor.getId());
	}
	
	public Professor atualiza(Professor professor) {
		em.getTransaction().begin();
		Professor p = em.merge(professor);
		em.getTransaction().commit();
		return p;
	}
	
	public Professor busca(Professor professor) {
		return em.find(Professor.class, professor.getId());
	}
	
	public Professor busca(Long id) {
		return em.find(Professor.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Professor> lista() {
		return em.createQuery("select p from Professor p").getResultList();
	}
}