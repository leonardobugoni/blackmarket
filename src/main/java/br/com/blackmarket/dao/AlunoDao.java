package br.com.blackmarket.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.blackmarket.model.Aluno;


@RequestScoped
public class AlunoDao {

	private final EntityManager em;

	@Inject
	public AlunoDao(EntityManager em) {
		this.em = em;
	}
	
	public AlunoDao(){
		this(null);
		
	}

	public void adiciona(Aluno aluno) {
		em.getTransaction().begin();
		em.persist(aluno);
		em.getTransaction().commit();
	}

	public void remove(Long id) {
		em.getTransaction().begin();
		em.remove(busca(id));
		em.getTransaction().commit();
	}
	
	public Aluno carrega(Aluno aluno) {
		return em.find(Aluno.class, aluno.getId());
	}
	
	public Aluno atualiza(Aluno aluno) {
		em.getTransaction().begin();
		Aluno a = em.merge(aluno);
		em.getTransaction().commit();
		return a;
	}
	
	public Aluno busca(Aluno aluno) {
		return em.find(Aluno.class, aluno.getId());
	}
	
	public Aluno busca(Long id) {
		return em.find(Aluno.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Aluno> lista() {
		return em.createQuery("select a from Aluno a").getResultList();
	}
}