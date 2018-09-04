package repository;

import model.ServicosAgendamentoModel;
import model.ServicosModel;

import java.sql.SQLException;

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
        preparaComandoSql("delete from SERVICO_AGENDAMENTO where id = ?");
        stmt.setLong(1, servicosAgendamento.getId());
        executaFinalizandoConexao();
    }
}
