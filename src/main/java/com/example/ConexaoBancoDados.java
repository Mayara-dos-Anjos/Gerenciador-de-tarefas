package com.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConexaoBancoDados {
    private static final String URL = "jdbc:mysql://localhost:3306/g_tarefas";
    private static final String USUARIO = "root";
    private static final String SENHA = "May@2005";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
