// Autor: José Padilha
// Classe: SistemaView
// Descrição: Classe responsável pela interação com o usuário no console, exibindo o menu
// e capturando as opções para acionar o controller. Faz parte da camada View da arquitetura MVC.

package View;

import Controller.SistemaController;
import Model.Cliente;
import Model.Funcionario;
import Model.Pessoa;

import java.util.Scanner;

public class SistemaView {
    // Instância do controller para intermediar as ações do usuário
    private SistemaController controller = new SistemaController();
    // Scanner para capturar entrada do teclado
    private Scanner scanner = new Scanner(System.in);

    // Método principal que exibe o menu de opções ao usuário
    public void exibirMenu() {
        int opcao;
        // Limpa o console no início
        System.out.print("\033[H\033[2J");
        do {
            // Exibe as opções disponíveis no menu
            System.out.println("\n--- MENU ---");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Funcionário");
            System.out.println("3. Adicionar Cliente à Fila");
            System.out.println("4. Mostrar Fila");
            System.out.println("5. Atender Cliente");
            System.out.println("6. Listar Pessoas");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            // Encaminha a opção escolhida para a ação correspondente
            switch (opcao) {
                case 1 -> cadastrarCliente();
                case 2 -> cadastrarFuncionario();
                case 3 -> adicionarClienteFila();
                case 4 -> controller.mostrarFila();
                case 5 -> controller.atenderProximoCliente();
                case 6 -> controller.listarPessoas();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    // Método para cadastrar um novo Cliente
    private void cadastrarCliente() {
        System.out.print("\033[H\033[2J"); // Limpa o console
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = Integer.parseInt(scanner.nextLine());
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        // Cria um novo objeto Cliente e envia para o controller
        Cliente cliente = new Cliente(nome, idade, cpf);
        controller.cadastrarPessoa(cliente);
        System.out.println("Cliente cadastrado.");
    }

    // Método para cadastrar um novo Funcionário
    private void cadastrarFuncionario() {
        System.out.print("\033[H\033[2J"); // Limpa o console
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = Integer.parseInt(scanner.nextLine());
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();

        // Cria um novo objeto Funcionário e envia para o controller
        Funcionario funcionario = new Funcionario(nome, idade, cargo);
        controller.cadastrarPessoa(funcionario);
        System.out.println("Funcionário cadastrado.");
    }

    // Método para adicionar um cliente existente à fila de atendimento
    private void adicionarClienteFila() {
        System.out.print("\033[H\033[2J"); // Limpa o console
        System.out.print("Nome do cliente para atendimento: ");
        String nomeBusca = scanner.nextLine();

        // Percorre a lista de pessoas cadastradas procurando um Cliente com o nome informado
        for (Pessoa p : controller.pessoas) {
            if (p instanceof Cliente && p.nome.equalsIgnoreCase(nomeBusca)) { // Acesso direto ao nome
                controller.adicionarAFila((Cliente) p);
                System.out.println("Cliente adicionado à fila.");
                return; // Sai do método após adicionar
            }
        }
        // Se não encontrou o cliente
        System.out.println("Cliente não encontrado.");
    }
}
