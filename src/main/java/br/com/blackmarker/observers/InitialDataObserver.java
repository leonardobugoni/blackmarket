package br.com.blackmarker.observers;

import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;

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
		/*em.persist(new Usuario("admin", "123456"));*/
		em.getTransaction().commit();
		em.close();
	}	
}