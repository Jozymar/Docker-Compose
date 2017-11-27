package br.edu.ifpb.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            try {

                
                String url = "jdbc:postgresql://host-banco:5432/album-banda";
                String usuario = "postgres";
                String senha = "deus";
//                String url = "jdbc:postgresql://localhost:5432/album-banda";
//                String usuario = "postgres";
//                String senha = "deus";

                Class.forName("org.postgresql.Driver");

                connection = DriverManager.getConnection(url, usuario, senha);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return connection;
        }

    }
}
