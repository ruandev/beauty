package repository;

import model.CaixaModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import utils.VariaveisEstaticas;

public class CaixaRepository extends BaseRepository {

    public CaixaModel abrirCaixa(CaixaModel caixa) throws SQLException {
        String sql = "insert into CAIXA (abertura, valor_inicial, aberto, obs) values (now(),?,true,?)";
        preparaComandoSql(sql);

        stmt.setDouble(1, caixa.getValorInicial());
        stmt.setString(2, caixa.getObs());

        executaComandoSql();

        caixa.setId(retornaUltimoCodigo());

        finalizaConexao();

        return caixa;
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

    public Boolean verificaEstadoCaixaDia() throws SQLException {

        Boolean estado = null;

        preparaComandoSql("select aberto from CAIXA where DATE(abertura) >= DATE(now())");

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                estado = rs.getBoolean("aberto");
            }
        }
        finalizaConexao();

        return estado;
    }
    
    public Long recuperaCodigoCaixaDia() throws SQLException {

        Long codigo = new Long(0);

        preparaComandoSql("select id from CAIXA where DATE(abertura) >= DATE(now()) and aberto = true");

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                codigo = rs.getLong("id");
            }
        }
        finalizaConexao();

        return codigo;
    }
    
    public Double recuperaValorInicial() throws SQLException {
        Double valor = new Double(0);
        preparaComandoSql("select valor_inicial from CAIXA where ID = ?");

        stmt.setDouble(1, VariaveisEstaticas.codigoCaixa);
        
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                valor = rs.getDouble("valor_inicial");
            }
        }
        finalizaConexao();

        return valor;
    }
}
