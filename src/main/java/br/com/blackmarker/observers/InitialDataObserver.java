package br.com.blackmarker.observers;

import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;

import br.com.blackmarket.model.Produto;
import br.com.blackmarket.model.Usuario;
import br.com.blackmarket.util.JPAUtil;
import br.com.caelum.vraptor.events.VRaptorInitialized;

public class InitialDataObserver {

	/**
	 * Esse é um exemplo simples de observer do CDI com VRaptor 4
	 * 
	 * Ele é utilizado para inserir um usuário e alguns produtos
	 * sempre que a app é startada, pois estamos usando um banco
	 * em memória. Você pode ler mais a respeito de observers em:
	 *  
	 * http://www.vraptor.org/pt/docs/eventos/
	 */
	public void insert(@Observes VRaptorInitialized event) {
		
		EntityManager em = JPAUtil.criaEntityManager();
		em.getTransaction().begin();

		em.persist(new Usuario("falcatruas", "123456"));

		em.persist(new Produto("IPHONE 6S", "64GB PRATA", 20, 2200.99, 25.00));
		em.persist(new Produto("SAMSUNG J5", "16GB DOURADO", 50, 1500.90, 20.00));
		em.persist(new Produto("MOTOROLA Z2 SNAPS", "64GB PRETO", 15, 2880.90, 30.00));
		
		em.getTransaction().commit();
		em.close();
	}	
}