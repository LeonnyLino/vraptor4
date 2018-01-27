package br.com.caelum.livraria.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;




@Entity
public class Autor {

	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	
	private List<Livro> livros = new ArrayList<Livro>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Autor [nome=" + nome + "]";
	}

	public List<Livro> getLivros() {
		return livros;
	}
	
	

}