# 📚 Sistema de Livraria - Java CLI

### 🔧 Tecnologias Utilizadas

<p align="left"> 
<img src="https://img.shields.io/badge/Java-24-007396?style=for-the-badge&logo=java&logoColor=white" title="Java 24"/> 
<img src="https://img.shields.io/badge/CLI-Java%20Console-4B0082?style=for-the-badge" title="Java CLI"/> 
<img src="https://img.shields.io/badge/Estrutura%20de%20Dados-Básico-FF8C00?style=for-the-badge" title="Estrutura de Dados"/> 
</p>

---

## 📖 Descrição

Este projeto é um **sistema de gerenciamento de livros via terminal (CLI)**, desenvolvido com **Java 24** como parte do **primeiro módulo da formação Java da Rocketseat**.

O objetivo principal é **praticar estruturas de dados** e conceitos fundamentais da linguagem, como `ArrayList`, `Scanner`, `Streams`, condicionais, datas e formatação de saída.

Todo o código foi **desenvolvido 100% por mim** como parte do processo de **aprovação da formação**, com foco em aplicar boas práticas, organização e experiência de uso no terminal.

---

## ✅ Funcionalidades

- Menu interativo no terminal
- Cadastrar livros (com opção de múltiplos cadastros em sequência)
- Listar todos os livros cadastrados
- Pegar um livro emprestado
- Devolver um livro emprestado
- Deletar um livro (somente se estiver disponível)
- Validações para garantir se o livro está disponível ou emprestado
- Datas de empréstimo e devolução formatadas com `DateTimeFormatter`
- Saídas formatadas com expressões regulares para alinhamento no console

---

## 🚀 Como rodar o projeto localmente

### ✅ Pré-requisitos

* Java 24 instalado
* Editor de código ou terminal com suporte a execução de arquivos `.java`

### 📦 Etapas

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/sistema-livraria-cli.git

# Navegue até o diretório do projeto
cd sistema-livraria-cli

# Compile o código
javac src/Main.java

# Execute o programa
java src/Main
```

---

## 🌐 Como usar

Ao executar o programa no terminal, será exibido um **menu interativo** com as opções disponíveis:

```text
==== MENU LIVRARIA ====
[1] - Cadastrar Livro
[2] - Listar Livros
[3] - Pegar Livro Emprestado
[4] - Devolver Livro
[5] - Deletar Livro
[6] - Sair (Encerrar Programa)
```

A partir desse menu, o usuário pode interagir com o sistema utilizando apenas o teclado.

---

## 🧠 Conceitos Aplicados

* Programação estruturada com orientação a objetos
* Manipulação de datas com `LocalDateTime` e `DateTimeFormatter`
* Validações com condicionais (`if/else`)
* Uso de `ArrayList` para armazenar objetos dinamicamente
* Uso de `Stream` para filtragem e buscas inteligentes
* Entrada de dados com `Scanner`
* Boas práticas de organização de pacotes (`model`, `service`, `utils`)
* Padronização da saída no terminal com alinhamento de colunas usando `String.format()` e expressões

---

## 📄 Licença

Este projeto é disponibilizado apenas para **fins educacionais** como parte da **formação Java da Rocketseat**.
Não deve ser utilizado em produção sem adaptações e melhorias específicas.

---
