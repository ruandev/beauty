package repository;

import model.AgendamentoModel;
import model.FuncionarioModel;
import model.ServicoModel;
import model.ServicosAgendamentoModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicosAgendamentoRepository extends BaseRepository {

    public ServicosAgendamentoModel save(ServicosAgendamentoModel servicosAgendamento) throws SQLException {
        String sql;
        if (servicosAgendamento.getFuncionario() != null) {
            sql = "insert into SERVICO_AGENDAMENTO (id_servico, id_agendamento, obs, id_funcionario, valor) values (?,?,?,?,?)";
            preparaComandoSql(sql);

            stmt.setLong(1, servicosAgendamento.getServico().getId());
            stmt.setLong(2, servicosAgendamento.getAgendamento().getId());
            stmt.setString(3, servicosAgendamento.getObs());
            stmt.setLong(4, servicosAgendamento.getFuncionario().getId());
            stmt.setDouble(5, servicosAgendamento.getValor());
        } else {
            sql = "insert into SERVICO_AGENDAMENTO (id_servico, id_agendamento, obs, valor) values (?,?,?,?)";
            preparaComandoSql(sql);

            stmt.setLong(1, servicosAgendamento.getServico().getId());
            stmt.setLong(2, servicosAgendamento.getAgendamento().getId());
            stmt.setString(3, servicosAgendamento.getObs());
            stmt.setDouble(4, servicosAgendamento.getValor());
        }
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

        preparaComandoSql("select sa.id, s.id, s.descricao,s.valor, sa.valor, f.id, f.nome from SERVICO_AGENDAMENTO sa INNER JOIN SERVICO s ON s.id = sa.id_servico left join funcionario f on f.id = sa.id_funcionario where sa.ID_AGENDAMENTO = ?");
        stmt.setLong(1, agendamento.getId());
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ServicosAgendamentoModel servico = ServicosAgendamentoModel.builder()
                        .id(rs.getLong("sa.id"))
                        .agendamento(agendamento)
                        .servico(ServicoModel.builder().id(rs.getLong("s.id")).descricao(rs.getString("s.descricao")).valor(rs.getDouble("s.valor")).build())
                        .funcionario(FuncionarioModel.builder().id(rs.getLong("f.id")).nome(rs.getString("f.nome")).build())
                        .valor(rs.getDouble("sa.valor"))
                        .build();

                listServicos.add(servico);
            }
        }
        finalizaConexao();

        return listServicos;
    }

    public void deleteByAgendamento(AgendamentoModel agendamento) throws SQLException {
        preparaComandoSql("delete from SERVICO_AGENDAMENTO where id_agendamento = ? ");
        stmt.setLong(1, agendamento.getId());
        executaFinalizandoConexao();
    }

    public ServicosAgendamentoModel update(ServicosAgendamentoModel servicosAgendamento) throws SQLException {

        String sql = "update SERVICO_AGENDAMENTO set id_funcionario = ?, valor = ? where id_agendamento = ? and id_servico = ?";

        preparaComandoSql(sql);

        stmt.setLong(1, servicosAgendamento.getFuncionario().getId());
        stmt.setDouble(2, servicosAgendamento.getValor());
        stmt.setLong(3, servicosAgendamento.getAgendamento().getId());
        stmt.setLong(4, servicosAgendamento.getServico().getId());

        executaComandoSql();

        servicosAgendamento.setId(retornaUltimoCodigo());

        finalizaConexao();

        return servicosAgendamento;
    }
}
