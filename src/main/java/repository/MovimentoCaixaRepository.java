package repository;

import model.CaixaModel;
import model.FuncionarioModel;
import model.MovimentoCaixaModel;
import utils.Utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MovimentoCaixaRepository extends BaseRepository {

    public void inserirMovimentoCaixa(MovimentoCaixaModel movimento) throws SQLException {
        String sql = "insert into MOVIMENTO_CAIXA (id_caixa, data_hora, valor, entrada, id_func_mov, obs) values (?,now(),?,?,?,?)";

        preparaComandoSql(sql);

        stmt.setLong(1, movimento.getCaixa().getId());
        stmt.setDouble(2, movimento.getValor());
        stmt.setBoolean(3, movimento.getEntrada());
        stmt.setLong(4, movimento.getFuncionario().getId());
        stmt.setString(5, movimento.getObs());

        executaFinalizandoConexao();
    }

    public List<MovimentoCaixaModel> listarMovimentoPorCaixa(CaixaModel caixa) throws SQLException {
        List<MovimentoCaixaModel> listMovimento = null;

        String sql = "select mov.id, mov.data_hora, mov.valor, mov.entrada, func.nome, mov.obs from movimento_caixa mov inner join funcionario func on func.id=mov.id_func_mov where mov.id_caixa = ?";

        preparaComandoSql(sql);

        stmt.setLong(1, caixa.getId());

        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            MovimentoCaixaModel.builder()
                    .id(rs.getLong("mov.id"))
                    .dataHoraMovimento(Utils.convetTimestampToLocalDateTime(rs.getTimestamp("mov.data_hora")))
                    .caixa(caixa)
                    .entrada(rs.getBoolean("mov.entrada"))
                    .valor(rs.getDouble("mov.valor"))
                    .funcionario(FuncionarioModel.builder().nome(rs.getString("func.nome")).build())
                    .obs(rs.getString("mov.obs"))
                    .build();
        }

        rs.close();
        finalizaConexao();

        return listMovimento;
    }
}
