package model;

import java.time.LocalDateTime;

public class Livro {

    private static int contadorId = 1;
    private int id;
    private String titulo;
    private String autor;
    private int ano;
    private boolean disponivel;
    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucao;

    public Livro(String titulo, String autor, int ano) {
        this.id = contadorId++;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.disponivel = true;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }
}
