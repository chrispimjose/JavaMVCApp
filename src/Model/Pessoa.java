// Autor: José Padilha
// Classe: Pessoa
// Descrição: Classe base que representa uma pessoa no sistema, contendo atributos comuns
// a clientes e funcionários. Utilizada como superclasse para promover herança e polimorfismo.

package Model;

public class Pessoa {

    // Atributo público nome (permitindo acesso direto, pois os alunos ainda não estudaram encapsulamento)
    public String nome;

    // Atributo protegido idade (permite acesso nas subclasses)
    protected int idade;

    // Construtor que inicializa o nome e a idade da pessoa
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Método para exibir os dados básicos da pessoa (nome e idade)
    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
    }

    // Sobrecarga do método exibirDados para incluir um prefixo antes do nome
    public void exibirDados(String prefixo) {
        System.out.println(prefixo + " " + nome + ", idade: " + idade);
    }
}
