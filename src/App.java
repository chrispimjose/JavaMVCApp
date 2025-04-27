// Autor: José Padilha
// Classe: App
// Descrição: Classe principal da aplicação que inicializa a interface de usuário (View)
// e chama o método para exibir o menu de opções.

import View.SistemaView;

public class App {

    // Método principal que inicia a execução do programa
    public static void main(String[] args) throws Exception {
        // Cria uma instância da View (tela de console)
        SistemaView view = new SistemaView();

        // Exibe o menu principal da aplicação
        view.exibirMenu();
    }
}

