package repository;

import model.ServicosModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicosRepository extends BaseRepository {

    public void save(ServicosModel servico) throws SQLException {
        String sql = "insert into SERVICOS (descricao, valor, obs) values (?,?,?)";
        preparaComandoSql(sql);

        stmt.setString(1, servico.getDescricao());
        stmt.setDouble(2, servico.getValor());
        stmt.setString(3, servico.getObs());

        executaFinalizandoConexao();
    }

    public void update(ServicosModel servico) throws SQLException {
        String sql = "update SERVICOS set descricao = ?, valor = ?, obs = ? where id = ?";
        preparaComandoSql(sql);

        stmt.setString(1, servico.getDescricao());
        stmt.setDouble(2, servico.getValor());
        stmt.setString(3, servico.getObs());
        stmt.setLong(4, servico.getId());

        executaFinalizandoConexao();
    }

    public void delete(ServicosModel servicos) throws SQLException {
        preparaComandoSql("select * from SERVICOS where id = ?");
        stmt.setLong(1, servicos.getId());
        executaFinalizandoConexao();
    }

    public List<ServicosModel> findAll() throws SQLException {
        List<ServicosModel> listServicos = new ArrayList<>();

        preparaComandoSql("select * from SERVICOS");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            ServicosModel servicos = ServicosModel.builder()
                    .id(rs.getLong("id"))
                    .descricao(rs.getString("descricao"))
                    .valor(rs.getDouble("valor"))
                    .obs(rs.getString("obs"))
                    .build();

            listServicos.add(servicos);
        }

        rs.close();
        finalizaConexao();

        return listServicos;
    }

    public ServicosModel findOne(ServicosModel filter)throws SQLException {
        ServicosModel servicos = null;

        preparaComandoSql("select * from SERVICOS where ID = ?");

        stmt.setLong(1, filter.getId());

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            servicos = ServicosModel.builder()
                    .id(rs.getLong("id"))
                    .descricao(rs.getString("descricao"))
                    .valor(rs.getDouble("valor"))
                    .obs(rs.getString("obs"))
                    .build();
        }

        rs.close();
        finalizaConexao();

        return servicos;
    }
}
