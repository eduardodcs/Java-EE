package br.com.eduardo.loja.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.eduardo.loja.daos.AutorDao;
import br.com.eduardo.loja.daos.LivroDao;
import br.com.eduardo.loja.models.Autor;
import br.com.eduardo.loja.models.Livro;

@Named(value="adminLivrosBean")
@RequestScoped
public class AdminLivrosBean {
	
	private Livro livro = new Livro();
	
	@Inject
	private LivroDao dao;
	@Inject
	private AutorDao autorDao;
	@Inject
	private FacesContext context;
	
	private List<Integer> autoresId = new ArrayList<>();

	@Transactional
	public String salvar() {
		for(Integer autorId : getAutoresId()) {
			livro.getAutores().add(new Autor(autorId));
		}
		
		dao.salvar(livro);
		
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("Livro cadastrado com sucesso!"));
		
		return "/livros/lista?faces-redirect=true";
	}
	
	public List<Autor> getAutores(){
		return autorDao.listar();
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Integer> getAutoresId() {
		return autoresId;
	}

	public void setAutoresId(List<Integer> autoresId) {
		this.autoresId = autoresId;
	}

}
