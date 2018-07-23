package repository;

import model.ClienteModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClienteRepository extends BaseRepository {

    public void save(ClienteModel object) throws SQLException {
        String sql = "insert tabela (campo) values (?)";
        preparaComandoSql(sql);

        stmt.setString(1, "bla");


        executaFinalizandoConexao();
    }

    public void update(ClienteModel object) throws SQLException {

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String nome = rs.getString("nome");
            String email = rs.getString("email");

            System.out.println(nome + " _ " + email);
        }

        rs.close();
        finalizaConexao();
    }

    public void delete(ClienteModel object) throws SQLException {

    }

    public List<ClienteModel> findAll() throws SQLException {
        return null;
    }

    public ClienteModel findOne(ClienteModel filter)throws SQLException {
        return null;
    }

}
