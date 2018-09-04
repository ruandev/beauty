package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    private static final String IP_BANCO_DADOS = "localhost";
    private static final String NAME_BANCO_DADOS = "beauty";
    private static final String USER_BANCO_DADOS = "root";
    private static final String PASSWORD_BANCO_DADOS = "";

    public Connection conectar() {
        String urlConexaoBd = "jdbc:mysql://localhost/"+NAME_BANCO_DADOS+"?useTimezone=true&serverTimezone=UTC";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(urlConexaoBd,USER_BANCO_DADOS,PASSWORD_BANCO_DADOS);
        } catch (ClassNotFoundException ex) {
            System.out.println("Classe não encontrada, adicione o driver nas bibliotecas.");
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }

    }
}