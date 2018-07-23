package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    private static final String IP_BANCO_DADOS = "localhost";
    private static final String NAME_BANCO_DADOS = "mysql";
    private static final String USER_BANCO_DADOS = "root";
    private static final String PASSWORD_BANCO_DADOS = "root";

    public Connection conectar() {
        StringBuilder urlConexaoBd = new StringBuilder("jdbc:mysql://")
                .append(IP_BANCO_DADOS)
                .append("/")
                .append(NAME_BANCO_DADOS);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(urlConexaoBd.toString(),USER_BANCO_DADOS,PASSWORD_BANCO_DADOS);

        } catch (ClassNotFoundException ex) {
            System.out.println("Classe não encontrada, adicione o driver nas bibliotecas.");
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }

    }
}