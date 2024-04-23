package com.example;

import java.time.LocalDateTime;

public class Tarefa {
    private int id;
    private String descricao;
    private LocalDateTime dataCriacao;
    private boolean concluida;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.dataCriacao = LocalDateTime.now();
        this.concluida = false;
    }

    public Tarefa(int id, String descricao, LocalDateTime dataCriacao, boolean concluida) {
        this.id = id;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.concluida = concluida;
    }
    @Override
    public String toString() {
        return "ID: " + id + ", Descrição: " + descricao + ", Criada em: " + dataCriacao + ", Concluída: " + concluida;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    public boolean isConcluida() {
        return concluida;
    }
    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    

}