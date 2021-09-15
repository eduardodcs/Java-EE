package br.com.eduardo.loja.beans;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.eduardo.loja.daos.LivroDao;
import br.com.eduardo.loja.models.Livro;

@Model
public class LivroDetalheBean {

	@Inject
	private LivroDao dao;
	private Livro livro;
	
	private Integer id;
	
	public void carregarDetalhe() {
		this.setLivro(dao.buscaPorId(id));
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
}
