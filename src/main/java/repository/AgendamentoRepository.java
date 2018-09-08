package repository;

import java.sql.ResultSet;
import model.AgendamentoModel;
import utils.Utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ClienteModel;

public class AgendamentoRepository extends BaseRepository {


    public AgendamentoModel agendar(AgendamentoModel agendamento) throws SQLException {
        String sql = "insert into AGENDAMENTO (id_cliente, data_hora, obs) values (?,?,?)";
        preparaComandoSql(sql);

        stmt.setLong(1, agendamento.getClienteModel().getId());
        stmt.setTimestamp(2, Utils.convetLocalDateTimeToTimestamp(agendamento.getDataHora()));
        stmt.setString(3, agendamento.getObs());

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
    
   public List<AgendamentoModel> findAllAgendamentosFuturos() throws SQLException {
        List<AgendamentoModel> listAgendamentos = new ArrayList<>();

        preparaComandoSql("select a.id, a.id_cliente, c.nome, a.data_hora from AGENDAMENTO A INNER JOIN CLIENTE C on a.id_cliente = c.id where DATE(a.data_hora) >= DATE(now())");
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                AgendamentoModel servico = AgendamentoModel.builder()
                        .id(rs.getLong("a.id"))
                        .clienteModel(ClienteModel.builder().id(rs.getLong("a.id_cliente")).nome(rs.getString("c.nome")).build())
                        .dataHora(Utils.convetTimestampToLocalDateTime(rs.getTimestamp("a.data_hora")))
                        .build();
                
                listAgendamentos.add(servico);
            }
        }
        finalizaConexao();

        return listAgendamentos;
    }
   
   public AgendamentoModel findOne(AgendamentoModel agendamento) throws SQLException {
       preparaComandoSql("select a.id, a.id_cliente, c.nome, a.data_hora from AGENDAMENTO A INNER JOIN CLIENTE C where a.id = ?");
       stmt.setLong(1, agendamento.getId());
       
       try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                agendamento = AgendamentoModel.builder()
                        .id(rs.getLong("a.id"))
                        .clienteModel(ClienteModel.builder().id(rs.getLong("a.id_cliente")).nome(rs.getString("c.nome")).build())
                        .dataHora(Utils.convetTimestampToLocalDateTime(rs.getTimestamp("a.data_hora")))
                        .build();
            }
        }
        finalizaConexao();

        return agendamento;
    }
   
   public void delete(AgendamentoModel agendamento)throws SQLException{
       ServicosAgendamentoRepository servicosAgendamentoRepository = new ServicosAgendamentoRepository();
       servicosAgendamentoRepository.deleteByAgendamento(agendamento);
       preparaComandoSql("delete from AGENDAMENTO where id = ? ");
       stmt.setLong(1, agendamento.getId());
       executaFinalizandoConexao();
   }
}

