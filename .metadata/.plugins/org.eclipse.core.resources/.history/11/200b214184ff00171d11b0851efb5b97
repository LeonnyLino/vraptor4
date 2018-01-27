package br.com.caelum.livraria.bean;

import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;
import br.com.caelum.livraria.util.RedirectView;

@ManagedBean
@ViewScoped
public class AutorBean {

	private Autor autor = new Autor();

	public Autor getAutor() {
		return autor;
	}
	
	public List<Livro> livrosDoAutor(){
		return this.autor.getLivros();
	}
	
	public List<Autor> getAutores(){
		return new DAO<Autor>(Autor.class).listaTodos();
	}
	
	public void remover(Autor autor) {
		System.out.println("Removendo Autor: " + autor.getNome());
		new DAO<Autor>(Autor.class).remove(autor);
	}
	
	public void alterar(Autor autor) {
		System.out.println("Alterando Autor: " + autor.getNome());
		this.autor = autor;
	}

	public RedirectView gravar() {
		System.out.println("Gravando autor " + this.autor.getNome());
		if(this.autor.getId().equals(null)) {
			new DAO<Autor>(Autor.class).adiciona(this.autor);		
		}else {
			new DAO<Autor>(Autor.class).atualiza(this.autor);
		}
		
		this.autor = new Autor();
		
		return new RedirectView("livro");
	}
}