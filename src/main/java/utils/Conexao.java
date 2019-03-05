package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    private static final String IP_PORT_BANCO_DADOS = "localhost:3308";
    private static final String MEU_IP_PORT_BANCO_DADOS = "localhost:3306";
    private static final String NAME_BANCO_DADOS = "beauty";
    private static final String USER_BANCO_DADOS = "root";
    private static final String PASSWORD_BANCO_DADOS = "root";
    private static final String MEU_PASSWORD_BANCO_DADOS = "";

    public Connection conectar() {
        String urlConexaoBd = "jdbc:mysql://" + IP_PORT_BANCO_DADOS + "/" + NAME_BANCO_DADOS + "?useTimezone=true&serverTimezone=GMT-3&autoReconnect=true&useSSL=false";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
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