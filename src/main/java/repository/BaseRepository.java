package repository;

import utils.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BaseRepository {

    Connection connection = null;
    PreparedStatement stmt = null;

    protected void preparaComandoSql(String sql) throws SQLException {
        connection = new Conexao().conectar();
        stmt = connection.prepareStatement(sql);
    }

    protected void executaFinalizandoConexao() throws SQLException {
        stmt.execute();
        finalizaConexao();
    }

    protected void finalizaConexao() throws SQLException {
        stmt.close();
        connection.close();
    }
}
