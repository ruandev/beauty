package repository;

import java.sql.ResultSet;
import model.ServicosAgendamentoModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.AgendamentoModel;
import model.ServicoModel;

public class ServicosAgendamentoRepository extends BaseRepository {

    public ServicosAgendamentoModel save(ServicosAgendamentoModel servicosAgendamento) throws SQLException {

        String sql = "insert into SERVICO_AGENDAMENTO (id_servico, id_agendamento, obs) values (?,?,?)";

        preparaComandoSql(sql);

        stmt.setLong(1, servicosAgendamento.getServico().getId());
        stmt.setLong(2, servicosAgendamento.getAgendamento().getId());
        stmt.setString(3, servicosAgendamento.getObs());

        executaComandoSql();

        servicosAgendamento.setId(retornaUltimoCodigo());

        finalizaConexao();

        return servicosAgendamento;
    }

    public void delete(ServicosAgendamentoModel servicosAgendamento) throws SQLException {
        preparaComandoSql("delete from SERVICO_AGENDAMENTO where id_agendamento = ? and id_servico = ?");
        stmt.setLong(1, servicosAgendamento.getAgendamento().getId());
        stmt.setLong(2, servicosAgendamento.getServico().getId());
        executaFinalizandoConexao();
    }
    
    public List<ServicosAgendamentoModel> findServicosPorAgendamento(AgendamentoModel agendamento) throws SQLException {
        List<ServicosAgendamentoModel> listServicos = new ArrayList<>();

        preparaComandoSql("select sa.id, s.id, s.descricao,s.valor from SERVICO_AGENDAMENTO sa INNER JOIN SERVICO s ON s.id = sa.id_servico where sa.ID_AGENDAMENTO = ?");
        stmt.setLong(1, agendamento.getId());
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ServicosAgendamentoModel servico = ServicosAgendamentoModel.builder()
                        .id(rs.getLong("sa.id"))
                        .agendamento(agendamento)
                        .servico(ServicoModel.builder().id(rs.getLong("s.id")).descricao(rs.getString("s.descricao")).valor(rs.getDouble("s.valor")).build())
                        .build();
                
                listServicos.add(servico);
            }
        }
        finalizaConexao();

        return listServicos;
    }

    public void deleteByAgendamento(AgendamentoModel agendamento) throws SQLException{
        preparaComandoSql("delete from SERVICO_AGENDAMENTO where id_agendamento = ? ");
        stmt.setLong(1, agendamento.getId());
        executaFinalizandoConexao();
    }
}
