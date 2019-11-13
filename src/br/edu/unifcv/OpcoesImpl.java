package br.edu.unifcv;

import java.util.Comparator;
import java.util.Scanner;

public class OpcoesImpl extends Biblioteca implements Opcoes {

	@Override
	public void cadastrar() {

		System.out.println("========================================");
		System.out.println("========        CADASTRAR       ========");
		System.out.println("========================================");
		System.out.println("Digite o nome do Livro:");
		Scanner scan = new Scanner(System.in);
		String nome = scan.nextLine();

		for (Livro livro : this.getLivros()) {
			if (livro.getNome().equalsIgnoreCase(nome)) {
				System.out.println("Erro: livro ja cadastrado.");
				this.cadastrar();
				return;
			}
		}

		Livro novoLivro = new Livro();
		novoLivro.setNome(nome);
		System.out.println("Digite o autor do Livro:");
		Scanner autor = new Scanner(System.in);
		String nomeAutor = autor.nextLine();
		novoLivro.setAutor(nomeAutor);
		System.out.println("Digite a descrição do Livro:");
		Scanner descricao = new Scanner(System.in);
		String descricaoLivro = descricao.nextLine();
		novoLivro.setDescricao(descricaoLivro);
		System.out.println("Digite a data de lançamento do Livro:");
		Scanner dataLancamento = new Scanner(System.in);
		String dataLancamentoLivro = dataLancamento.nextLine();
		novoLivro.setDataLancamento(dataLancamentoLivro);

		this.getLivros().add(novoLivro);

		this.showMenu();
	}

	@Override
	public void excluir() {

		System.out.println("========================================");
		System.out.println("========         EXCLUIR        ========");
		System.out.println("========================================");
		System.out.println("Digite o nome do Livro:");
		Scanner scanner = new Scanner(System.in);
		String nome = scanner.nextLine();

		for (Livro livro : this.getLivros()) {
			if (livro.getNome().equalsIgnoreCase(nome) && livro.isAlugado()) {
				System.out.println("Erro: livro alugado.");
				this.excluir();
			}
		}

		this.getLivros().removeIf(livro -> livro.getNome().equals(nome) && !livro.isAlugado());
		this.showMenu();
	}

	@Override
	public void alugar() {

		System.out.println("========================================");
		System.out.println("========          ALUGAR        ========");
		System.out.println("========================================");
		System.out.println("Digite o nome do Livro:");
		Scanner scanner = new Scanner(System.in);
		String nome = scanner.nextLine();

		for (Livro livro : this.getLivros()) {
			if (livro.getNome().equalsIgnoreCase(nome)) {
				if (!livro.isAlugado()) {
					livro.setAlugado(true);
				} else {
					System.out.println("Erro: o livro está alugado.");
				}
			}
		}
		this.showMenu();
	}

	@Override
	public void devolver() {

		System.out.println("========================================");
		System.out.println("========        DEVOLVER        ========");
		System.out.println("========================================");
		System.out.println("Digite o nome do Livro:");
		Scanner scanner = new Scanner(System.in);
		String nome = scanner.nextLine();
		boolean isExists = false;
		for (Livro livro : this.getLivros()) {
			if (livro.getNome().equalsIgnoreCase(nome) && (livro.isAlugado())) {
				livro.setAlugado(false);
				isExists = true;
				break;
			}
		}

		if (!isExists) {
			System.out.println("Erro: o livro não encontrado.");
		}

		this.showMenu();
	}

	@Override
	public void livrosDisponiveis() {
		System.out.println("========================================");
		System.out.println("========  LIVROS DISPONIVEIS    ========");
		System.out.println("========================================");
		for (Livro livro : this.getLivros()) {
			if (!livro.isAlugado()) {
				System.out.println(livro.toString());
			}
		}
		this.showMenu();
	}

	@Override
	public void livrosAlugados() {
		System.out.println("========================================");
		System.out.println("========    LIVROS ALUGADOS     ========");
		System.out.println("========================================");
		for (Livro livro : this.getLivros()) {
			if (livro.isAlugado()) {
				System.out.println(livro.toString());
			}
		}

		this.showMenu();
	}

	@Override
	public void livrosOrdenados() {

		System.out.println("========================================");
		System.out.println("========    LIVROS ORDENADOS    ========");
		System.out.println("========================================");
		Comparator<Livro> comparador = (Livro o1, Livro o2) -> o1.getNome().compareTo(o2.getNome());
		this.getLivros().sort(comparador);

		for (Livro livro : this.getLivros()) {
			System.out.println(livro.getNome());
		}
		this.showMenu();
	}

	@Override
	public void sair() {
		System.out.println("Sistema finalizado.");
	}

	@Override
	public void showMenu() {

		System.out.println("========================================");
		System.out.println("======== CONTROLE DE BIBLIOTECA ========");
		System.out.println("========================================");
		System.out.println("1 - Cadastrar Livro");
		System.out.println("2 - Excluir Livro");
		System.out.println("3 - Alugar Livro");
		System.out.println("4 - Devolver Livro");
		System.out.println("5 - Exibir todos os livros disponíveis");
		System.out.println("6 - Exibir todos os livros alugados");
		System.out.println("7 - Exibir os livros de forma ordenada");
		System.out.println("8 - Sair do sistema");
		System.out.println("========================================");

		System.out.println("Escolha uma opção: ");

		Scanner scanner = new Scanner(System.in);
		String menuEscolhido = scanner.nextLine();
		switch (menuEscolhido) {

		case "1":
			this.cadastrar();
		case "2":
			this.excluir();
		case "3":
			this.alugar();
		case "4":
			this.devolver();
		case "5":
			this.livrosDisponiveis();
		case "6":
			this.livrosAlugados();
		case "7":
			this.livrosOrdenados();
		case "8":
			this.sair();
			break;
		default:
			System.out.println("Erro: essa opcao eh invalida.");
			this.showMenu();
		}

	}

}
