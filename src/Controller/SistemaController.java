// Autor: José Padilha
// Classe: SistemaController
// Descrição: Classe responsável por controlar a lógica do sistema.
// Gerencia o cadastro de pessoas, fila de atendimento de clientes,
// e coordena as operações entre o modelo e a visualização (View).

package Controller;

import Model.Cliente;
import Model.Pessoa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SistemaController {

    // Lista pública de pessoas cadastradas (clientes e funcionários)
    public ArrayList<Pessoa> pessoas = new ArrayList<>();

    // Fila privada de atendimento apenas para clientes
    private Queue<Cliente> filaAtendimento = new LinkedList<>();

    // Método para cadastrar uma nova pessoa (cliente ou funcionário)
    public void cadastrarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    // Método para adicionar um cliente à fila de atendimento
    public void adicionarAFila(Cliente cliente) {
        filaAtendimento.add(cliente);
    }

    // Método para listar todas as pessoas cadastradas
    public void listarPessoas() {
        System.out.print("\033[H\033[2J");
        for (Pessoa p : pessoas) {
            p.exibirDados();
            System.out.println("---");
        }
    }

    // Método para atender o próximo cliente na fila
    public void atenderProximoCliente() {
        Cliente proximo = filaAtendimento.poll(); // Remove o cliente da fila
        if (proximo != null) {
            System.out.println("Atendendo cliente:");
            proximo.exibirDados();
        } else {
            System.out.println("Fila vazia."); // Caso a fila esteja vazia
        }
    }

    // Método para mostrar todos os clientes atualmente na fila
    public void mostrarFila() {
        System.out.print("\033[H\033[2J");
        if (filaAtendimento.isEmpty()) {
            System.out.println("Fila de atendimento está vazia.");
        } else {
            System.out.println("--- Fila de Atendimento ---");
            for (Pessoa cliente : filaAtendimento) {
                cliente.exibirDados();
                System.out.println("---");
            }
        }
    }

    // Método para verificar se a fila está vazia (usado em outras partes do sistema)
    public boolean filaVazia() {
        return filaAtendimento.isEmpty();
    }
}
