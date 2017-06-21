package br.com.blackmarket.producers;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;

import br.com.blackmarket.util.JPAUtil;

public class EntityManagerProducer {

	@RequestScoped
	@Produces 
	public EntityManager criaEntityEM(){
		return JPAUtil.criaEntityManager();
	}
	
}
