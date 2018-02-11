package br.com.caelum.vraptor.producers;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.util.JPAUtil;

public class CriaEntityManagerProducer {
	
	@Produces @RequestScoped
	public EntityManager criaEM() {
		return JPAUtil.criaEntityManager();
	}
}
