package com.example;

import java.util.Scanner;

public class GerenciadorTarefas {
    private Scanner scanner = new Scanner(System.in);

    private TarefaDAO tarefaDAO;

    public GerenciadorTarefas() {
        this.tarefaDAO = new TarefaDAO();
    }
    public void start() {
        exibirMenu();
    }

    public void exibirMenu() {
        boolean sair = false;
        while (!sair) {
            System.out.println("=== Menu ===");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Visualizar Tarefas");
            System.out.println("3. Marcar Tarefa como Concluída");
            System.out.println("4. Excluir Tarefa");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner
            
            switch (opcao) {
                case 1:
                    adicionarTarefa();
                    break;
                case 2:
                    visualizarTarefas();
                    break;
                case 3:
                    marcarTarefaComoConcluida();
                    break;
                case 4:
                    excluirTarefa();
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void adicionarTarefa() {
        System.out.print("Digite a descrição da tarefa: ");
        String descricao = scanner.nextLine();
        Tarefa novaTarefa = new Tarefa(descricao);
        tarefaDAO.adicionarTarefa(novaTarefa);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    private void visualizarTarefas() {
        System.out.println("=== Lista de Tarefas ===");
        for (Tarefa tarefa : tarefaDAO.listarTarefas()) {
            System.out.println(tarefa);
        }
    }

    private void marcarTarefaComoConcluida() {
        System.out.print("Digite o ID da tarefa que deseja marcar como concluída: ");
        int id = scanner.nextInt();
        tarefaDAO.marcarTarefaComoConcluida(id);
        System.out.println("Tarefa marcada como concluída com sucesso!");
    }

    private void excluirTarefa() {
        System.out.print("Digite o ID da tarefa que deseja excluir: ");
        int id = scanner.nextInt();
        tarefaDAO.excluirTarefa(id);
        System.out.println("Tarefa excluída com sucesso!");
    }
    
}
