package br.edu.unifcv;

import java.util.ArrayList;
import java.util.List;

public abstract class Biblioteca {

	private List<Livro> livros = new ArrayList<>();

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
	
}
