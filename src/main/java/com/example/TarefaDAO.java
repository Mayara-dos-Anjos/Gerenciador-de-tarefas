package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;




public class TarefaDAO {
    private static final String INSERIR_TAREFA_SQL = "INSERT INTO tarefas (descricao) VALUES (?)";
    private static final String LISTAR_TAREFAS_SQL = "SELECT * FROM tarefas";
    private static final String MARCAR_TAREFA_COMO_CONCLUIDA_SQL = "UPDATE tarefas SET concluida = true WHERE id = ?";
    private static final String EXCLUIR_TAREFA_SQL = "DELETE FROM tarefas WHERE id = ?";

    public void adicionarTarefa(Tarefa tarefa) {
        try (Connection conexao = ConexaoBancoDados.conectar();
             PreparedStatement preparedStatement = conexao.prepareStatement(INSERIR_TAREFA_SQL)) {
            preparedStatement.setString(1, tarefa.getDescricao());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar tarefa: " + e.getMessage());
        }
    }
    public List<Tarefa> listarTarefas() {
        List<Tarefa> tarefas = new ArrayList<>();
        try (Connection conexao = ConexaoBancoDados.conectar();
             Statement statement = conexao.createStatement();
             ResultSet resultSet = statement.executeQuery(LISTAR_TAREFAS_SQL)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String descricao = resultSet.getString("descricao");
                LocalDateTime dataCriacao = resultSet.getTimestamp("data_criacao").toLocalDateTime();
                boolean concluida = resultSet.getBoolean("concluida");
                Tarefa tarefa = new Tarefa(id, descricao, dataCriacao, concluida);
                tarefas.add(tarefa);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar tarefas: " + e.getMessage());
        }
        return tarefas;
    }
    public void marcarTarefaComoConcluida(int id) {
        try (Connection conexao = ConexaoBancoDados.conectar();
             PreparedStatement preparedStatement = conexao.prepareStatement(MARCAR_TAREFA_COMO_CONCLUIDA_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao marcar tarefa como concluída: " + e.getMessage());
        }
    }

    public void excluirTarefa(int id) {
        try (Connection conexao = ConexaoBancoDados.conectar();
             PreparedStatement preparedStatement = conexao.prepareStatement(EXCLUIR_TAREFA_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir tarefa: " + e.getMessage());
        }
    }
}
