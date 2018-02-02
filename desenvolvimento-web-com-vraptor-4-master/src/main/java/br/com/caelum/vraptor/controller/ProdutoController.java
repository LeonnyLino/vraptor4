package br.com.caelum.vraptor.controller;

import java.util.List;

import javax.ejb.Remove;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.dao.ProdutoDao;
import br.com.caelum.vraptor.model.Produto;
import br.com.caelum.vraptor.util.JPAUtil;

@Controller
public class ProdutoController {
	
	@Get
	public void sobre() {
		
	}
	
	@Get
	public List<Produto> lista() {
		 EntityManager em = JPAUtil.criaEntityManager();
		 ProdutoDao produtoDao = new ProdutoDao(em);
		 return produtoDao.lista();
	}
	
	@Get
	public void formulario() {
		
	}
	
	@Post
	public void adiciona(Produto produto) {
		EntityManager em = JPAUtil.criaEntityManager();
		em.getTransaction().begin();
		ProdutoDao dao = new ProdutoDao(em);
		dao.adiciona(produto);
		em.getTransaction().commit();
		
	}
	
	@Remove
	public void remove(Produto produto) {
		EntityManager em = JPAUtil.criaEntityManager();
		em.getTransaction().begin();
		ProdutoDao dao = new ProdutoDao(em);
		dao.remove(produto);
		em.getTransaction().commit();
		
	}
	
	
}
