// Autor: José Padilha
// Classe: Funcionario
// Descrição: Classe que representa um funcionário no sistema.
// Herda de Pessoa e adiciona o atributo específico "cargo".

package Model;

public class Funcionario extends Pessoa {

    // Atributo específico do Funcionário
    private String cargo;

    // Construtor que inicializa nome, idade e cargo
    public Funcionario(String nome, int idade, String cargo) {
        // Chama o construtor da classe base (Pessoa)
        super(nome, idade);
        this.cargo = cargo;
    }

    // Sobrescreve o método exibirDados para incluir o cargo
    @Override
    public void exibirDados() {
        super.exibirDados(); // Exibe nome e idade (da Pessoa)
        System.out.println("Cargo: " + cargo); // Exibe o cargo (específico do Funcionário)
    }
}
