package br.edu.unifcv;

public class Livro {

	private String nome;
	private String descricao;
	private String autor;
	private String dataLancamento;
	private boolean alugado;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	public boolean isAlugado() {
		return alugado;
	}
	public void setAlugado(boolean alugado) {
		this.alugado = alugado;
	}
	@Override
	public String toString() {
		return "Nome: " + nome + "\n"+ "Descrição: " + descricao + "\n" + "Autor: " + autor + "\n" + "Data Lançamento: " + dataLancamento +"\n" + "----------------";
	}
	
	
	
}
