package br.com.caelum.vraptor.controller;

import javax.inject.Inject;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.ProdutoDao;
import br.com.caelum.vraptor.model.Produto;
import br.com.caelum.vraptor.simplemail.Mailer;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;

@Controller
public class ProdutoController {
	
	private final Result result;
	private final ProdutoDao dao;
	private final Validator validator;
	private final Mailer mailer;
	
	@Inject
	public ProdutoController(Result result, ProdutoDao dao, Validator validator, Mailer mailer) {
		this.result = result;
		this.dao = dao;
		this.validator = validator;
		this.mailer = mailer;
	}
	
	public ProdutoController() {
		this(null, null, null, null);
	}
	
	@Get
	public void sobre() {
		
	}
	
	@Get
	public void lista() {
		 result.include("produtoList", dao.lista());
	}
	
	@Get
	public void listaJson() {
		result.use(Results.json()).from(dao.lista()).serialize();
	}
	
	@Get
	public void listaXML() {
		result.use(Results.xml()).from(dao.lista()).serialize();
	}
	
	@Get
	public void formulario() {
		
	}
	
	@Post
	public void adiciona(Produto produto) {
		
		validator.check(produto.getQuantidade() > 0, new I18nMessage("erro", "produto.quantidade.negativa"));
		validator.onErrorUsePageOf(this).formulario();
		
		dao.adiciona(produto);
		result.include("mensagem", "Protudo Adicionado com sucesso!");
		result.redirectTo(this).lista();
		
	}
	
	@Get
	public void remove(Produto produto) {
		dao.remove(produto);
		result.include("mensagem", "Protudo Removido com sucesso!");
		result.redirectTo(this).lista();
		
	}
	
	@Get
	public void enviarPedidosDeNovosItens(Produto produto) throws EmailException {
		Email email = new SimpleEmail();
		email.setSubject("[vraptor-produto] Precisamos de mais estoque");
		email.addTo("leonny.1993@gmail.com");
		email.setMsg("Precisamos de mais itens do produto" + produto.getNome());
		mailer.send(email);
		result.redirectTo(this).lista();
		
	}
	
	
}
