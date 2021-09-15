package br.com.eduardo.loja.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.eduardo.loja.daos.LivroDao;
import br.com.eduardo.loja.models.Livro;

@Model //a anotação model substitui o "named + requestScoped"
public class AdminListaLivrosBean {

	@Inject
	private LivroDao dao;

	private List<Livro> livros = new ArrayList<>();
	
	public List<Livro> getLivros() {
		this.livros = dao.listar();
		return livros;
	}

	
}
