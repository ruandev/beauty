package repository;

import model.ServicoModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicosRepository extends BaseRepository {


    public ServicoModel save(ServicoModel servico) throws SQLException {
        String sql = "insert into SERVICO (descricao, valor, obs) values (?,?,?)";

        preparaComandoSql(sql);

        stmt.setString(1, servico.getDescricao());
        stmt.setDouble(2, servico.getValor());
        stmt.setString(3, servico.getObs());

        executaComandoSql();

        servico.setId(retornaUltimoCodigo());

        finalizaConexao();

        return servico;
    }

    public void update(ServicoModel servico) throws SQLException {
        String sql = "update SERVICO set descricao = ?, valor = ?, obs = ? where id = ?";
        preparaComandoSql(sql);

        stmt.setString(1, servico.getDescricao());
        stmt.setDouble(2, servico.getValor());
        stmt.setString(3, servico.getObs());
        stmt.setLong(4, servico.getId());

        executaFinalizandoConexao();
    }

    public void delete(ServicoModel servicos) throws SQLException {
        preparaComandoSql("delete from SERVICO where id = ?");

        stmt.setLong(1, servicos.getId());
        executaFinalizandoConexao();
    }

    public List<ServicoModel> findAll() throws SQLException {
        List<ServicoModel> listServicos = new ArrayList<>();

        preparaComandoSql("select * from SERVICO order by descricao");
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ServicoModel servico = ServicoModel.builder()
                        .id(rs.getLong("id"))
                        .descricao(rs.getString("descricao"))
                        .valor(rs.getDouble("valor"))
                        .obs(rs.getString("obs"))
                        .build();
                
                listServicos.add(servico);
            }
        }
        finalizaConexao();

        return listServicos;
    }

    public ServicoModel findOne(ServicoModel servico)throws SQLException {
        preparaComandoSql("select * from SERVICO where ID = ?");

        stmt.setLong(1, servico.getId());

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                servico = ServicoModel.builder()
                        .id(rs.getLong("id"))
                        .descricao(rs.getString("descricao"))
                        .valor(rs.getDouble("valor"))
                        .obs(rs.getString("obs"))
                        .build();
            }
        }
        finalizaConexao();

        return servico;
    }
}