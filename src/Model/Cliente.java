// Autor: José Padilha
// Classe: Cliente
// Descrição: Classe que representa um cliente no sistema.
// Herda de Pessoa e adiciona o atributo específico "cpf".

package Model;

public class Cliente extends Pessoa {

    // Atributo específico do Cliente
    private String cpf;

    // Construtor que inicializa nome, idade e CPF
    public Cliente(String nome, int idade, String cpf) {
        // Chama o construtor da classe base (Pessoa)
        super(nome, idade);
        this.cpf = cpf;
    }

    // Sobrescreve o método exibirDados para incluir o CPF
    @Override
    public void exibirDados() {
        super.exibirDados(); // Exibe nome e idade (da Pessoa)
        System.out.println("CPF: " + cpf); // Exibe o CPF (específico do Cliente)
    }
}
