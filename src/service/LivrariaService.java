package service;

import model.Livro;
import utils.Menu;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LivrariaService {
    private List<Livro> livros = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);

    public void iniciar() {
        int opcao;

        do {
            Menu.mostrarMenu();
            try {
                opcao = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Digite um número válido.");
                continue;
            }

            switch (opcao) {
                case 1:
                    cadastrarLivro();
                    break;
                case 2:
                    listarLivros();
                    break;
                case 3:
                    pegarLivroEmprestado();
                    break;
                case 4:
                    devolverLivroEmprestado();
                    break;
                case 5:
                    deletarLivro();
                    break;
                case 6:
                    System.out.println();
                    System.out.println("Encerrando o programa...");
                    return;
                default:
                    System.out.println("Opção inválida. Digite um número válido.");
            }
        } while (true);
    }

    public void cadastrarLivro() {
        char continuar;
        do {
            System.out.println();
            System.out.println("=== Cadastro de Livro ===");
            System.out.print("Digite o título do livro: ");
            String titulo = scan.nextLine();
            System.out.print("Digite o autor do livro: ");
            String autor = scan.nextLine();
            System.out.print("Digite o ano de publicação do livro: ");
            int ano = Integer.parseInt(scan.nextLine());
            System.out.println();

            livros.add(new Livro(titulo, autor, ano));
            System.out.println("✅ Livro cadastrado com sucesso!");

            while (true) {
                System.out.print("Deseja cadastrar outro livro? (s/n): ");
                String resposta = scan.nextLine().trim().toLowerCase();

                if (resposta.equalsIgnoreCase("s")) {
                    continuar = 's';
                    break;
                } else if (resposta.equalsIgnoreCase("n")) {
                    continuar = 'n';
                    break;
                } else {
                    System.out.println("❌ Resposta inválida. Digite 's' para sim ou 'n' para não.");
                    System.out.println();
                }
            }
        } while (continuar == 's');

    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Não há livros cadastrados.");
        } else {
            System.out.println("\n=== Lista de Livros ===");
            livros.forEach(System.out::println);
        }
    }

    public void pegarLivroEmprestado() {
        listarLivros();
        System.out.print("\nDigite o ID do livro que deseja pegar emprestado: ");
        int id = Integer.parseInt(scan.nextLine());

        Livro livroEscolhido = livros.stream()
                .filter(livro -> livro.getId() == id)
                .findFirst()
                .orElse(null);

        if (livroEscolhido == null) {
            System.out.println("❌ Livro não encontrado.");
        } else if (livroEscolhido.isDisponivel()) {
            livroEscolhido.emprestar();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm");
            String dataEmprestimoFormatada = livroEscolhido.getDataEmprestimo().format(formatter);
            String dataDevolucaoFormatada = livroEscolhido.getDataDevolucao().format(formatter);

            System.out.println("✅ Livro emprestado com sucesso!");
            System.out.println("📅 Data de empréstimo: " + dataEmprestimoFormatada);
            System.out.println("📅 Data de devolução: " + dataDevolucaoFormatada);
        } else {
            System.out.println("⚠️ Livro já está emprestado.");
        }
    }

    public void devolverLivroEmprestado() {
        List<Livro> livrosEmprestados = livros.stream()
                .filter(livro -> !livro.isDisponivel())
                .toList();

        if (livrosEmprestados.isEmpty()) {
            System.out.println("⚠️ Não há livros emprestados.");
            return;
        }

        System.out.println("\n=== Livros emprestados ===");
        livrosEmprestados.forEach(System.out::println);

        System.out.print("\nDigite o ID do livro que deseja devolver: ");
        int id = Integer.parseInt(scan.nextLine());

        Livro livroEscolhido = livrosEmprestados.stream()
                .filter(livro -> livro.getId() == id)
                .findFirst()
                .orElse(null);

        if (livroEscolhido == null) {
            System.out.println("❌ Livro não encontrado.");
        } else {
            LocalDateTime dataEmprestimo = livroEscolhido.getDataEmprestimo();
            LocalDateTime dataDevolucaoAtual = LocalDateTime.now();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm");

            livroEscolhido.devolver();

            System.out.println("✅ Livro devolvido com sucesso!");
            System.out.println("📅 Data de empréstimo: " + dataEmprestimo.format(formatter));
            System.out.println("📅 Data de devolução: " + dataDevolucaoAtual.format(formatter));
        }
    }

    public void deletarLivro() {
        listarLivros();
        System.out.print("\nDigite o ID do livro que deseja deletar: ");
        int id = Integer.parseInt(scan.nextLine());

        Livro livroEscolhido = livros.stream()
                .filter(livro -> livro.getId() == id)
                .findFirst()
                .orElse(null);

        if (livroEscolhido == null) {
            System.out.println("❌ Livro não encontrado.");
        } else if (livroEscolhido.isDisponivel()){
            System.out.println("✅ Livro deletado com sucesso!");
            livros.remove(livroEscolhido);
        } else {
            System.out.println("⚠️ Livro não pode ser deletado pois está emprestado.");
        }
    }
}
