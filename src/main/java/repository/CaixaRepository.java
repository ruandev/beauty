package repository;

import model.CaixaModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CaixaRepository extends BaseRepository {

    public void abrirCaixa(CaixaModel caixa) throws SQLException {
        String sql = "insert into CAIXA (abertura, valor_inicial, aberto, id_func_abert, obs) values (now(),?,true,?,?)";
        preparaComandoSql(sql);

        stmt.setDouble(1, caixa.getValorInicial());
        stmt.setLong(2, caixa.getFuncionarioAbertura().getId());
        stmt.setString(3, caixa.getObs());

        executaFinalizandoConexao();
    }

    public void fecharCaixa(CaixaModel caixa) throws SQLException {
        String sql = "update CAIXA set fechamento = now(), valor_final = ?, aberto = false, id_func_fecha = ?, obs =? where id = ?";
        preparaComandoSql(sql);

        stmt.setDouble(1, caixa.getValorFinal());
        stmt.setLong(2, caixa.getFuncionarioFechamento().getId());
        stmt.setString(3, caixa.getObs());
        stmt.setLong(4, caixa.getId());

        executaFinalizandoConexao();
    }

    public Boolean verificaEstadoCaixa(CaixaModel caixa) throws SQLException {

        Boolean estado = null;

        preparaComandoSql("select aberto from CAIXA where ID = ?");

        stmt.setLong(1, caixa.getId());

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            estado = rs.getBoolean("aberto");
        }

        rs.close();
        finalizaConexao();

        return estado;
    }
}
