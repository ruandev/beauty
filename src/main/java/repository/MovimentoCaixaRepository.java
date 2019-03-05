package repository;

import model.CaixaModel;
import model.MovimentoCaixaModel;
import utils.Utils;
import utils.VariaveisEstaticas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovimentoCaixaRepository extends BaseRepository {

    public void inserirMovimentoCaixa(MovimentoCaixaModel movimento) throws SQLException {
        String sql = "insert into MOVIMENTO_CAIXA (id_caixa, data_hora, descricao, valor, entrada, obs, forma_entrada) values (?,now(),?,?,?,?,?)";

        preparaComandoSql(sql);

        stmt.setLong(1, movimento.getCaixa().getId());
        stmt.setString(2, movimento.getDescricao());
        stmt.setDouble(3, movimento.getValor());
        stmt.setBoolean(4, movimento.getEntrada());
        stmt.setString(5, movimento.getObs());
        stmt.setString(6, movimento.getFormaEntrada());

        executaFinalizandoConexao();
    }

    public List<MovimentoCaixaModel> listarMovimentoPorCaixa(CaixaModel caixa, Boolean entrada) throws SQLException {
        List<MovimentoCaixaModel> listMovimento = new ArrayList<>();

        String sql = "select mov.id, mov.data_hora, mov.valor, mov.entrada, mov.descricao,mov.forma_entrada from movimento_caixa mov where mov.id_caixa = ? and entrada = ?";

        preparaComandoSql(sql);

        stmt.setLong(1, caixa.getId());
        stmt.setBoolean(2, entrada);

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()){
                listMovimento.add(MovimentoCaixaModel.builder()
                        .id(rs.getLong("mov.id"))
                        .dataHoraMovimento(Utils.convetTimestampToLocalDateTime(rs.getTimestamp("mov.data_hora")))
                        .caixa(caixa)
                        .entrada(rs.getBoolean("mov.entrada"))
                        .valor(rs.getDouble("mov.valor"))
                        .descricao(rs.getString("mov.descricao"))
                        .formaEntrada(rs.getString("mov.forma_entrada"))
                        .build());
            }
        }
        finalizaConexao();

        return listMovimento;
    }
    
    public Double somaEntradasByCaixa() throws SQLException{
        Double soma = 0d;
        
        String sql = "select SUM(valor) as soma from movimento_caixa where id_caixa = ? and entrada = true";
        
        preparaComandoSql(sql);

        stmt.setLong(1, VariaveisEstaticas.codigoCaixa);

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()){
                soma = rs.getDouble("soma");
            }
        }
        finalizaConexao();

        return soma;
    }
    
    public Double somaSaidasByCaixa() throws SQLException{
        Double soma = 0d;
        
        String sql = "select SUM(valor) as soma from movimento_caixa where id_caixa = ? and entrada = false";
        
        preparaComandoSql(sql);

        stmt.setLong(1, VariaveisEstaticas.codigoCaixa);

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()){
                soma = rs.getDouble("soma");
            }
        }
        finalizaConexao();

        return soma;
    }
    
}
