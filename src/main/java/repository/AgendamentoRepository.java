package repository;

import model.AgendamentoModel;
import utils.Utils;

import java.sql.SQLException;

public class AgendamentoRepository extends BaseRepository {


    public AgendamentoModel agendar(AgendamentoModel agendamento) throws SQLException {
        String sql = "insert into AGENDAMENTO (id_cliente, data_hora, obs, id_func) values (?,?,?,?)";
        preparaComandoSql(sql);

        stmt.setLong(1, agendamento.getClienteModel().getId());
        stmt.setTimestamp(2, Utils.convetLocalDateTimeToTimestamp(agendamento.getDataHora()));
        stmt.setString(3, agendamento.getObs());
        stmt.setLong(4, agendamento.getAgendadoPor().getId());

        executaComandoSql();

        agendamento.setId(retornaUltimoCodigo());

        finalizaConexao();

        return agendamento;
    }

    public void alterarAgendamento(AgendamentoModel agendamento) throws SQLException {
        String sql = "update AGENDAMENTO set data_hora = ?, obs = ? where id = ?";
        preparaComandoSql(sql);

        stmt.setTimestamp(1, Utils.convetLocalDateTimeToTimestamp(agendamento.getDataHora()));
        stmt.setString(2, agendamento.getObs());
        stmt.setLong(3, agendamento.getId());

        executaFinalizandoConexao();

    }
}

