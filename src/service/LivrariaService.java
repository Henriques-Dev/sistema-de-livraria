package service;

import model.Livro;
import utils.Menu;

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
                    break;
                case 4:
                    break;
                case 5:
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
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Não há livros cadastrados.");
        } else {
            System.out.println("\n=== Lista de Livros ===");
            livros.forEach(System.out::println);
        }
    }
}
