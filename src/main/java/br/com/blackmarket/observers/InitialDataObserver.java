package br.com.blackmarket.observers;

import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;

import br.com.blackmarket.util.JPAUtil;
import br.com.caelum.vraptor.events.VRaptorInitialized;

public class InitialDataObserver {

	public void insert(@Observes VRaptorInitialized event) {
		
		EntityManager em = JPAUtil.criaEntityManager();
		em.getTransaction().begin();
		/*em.persist(new Usuario("admin", "123456"));*/
		em.getTransaction().commit();
		em.close();
	}	
}