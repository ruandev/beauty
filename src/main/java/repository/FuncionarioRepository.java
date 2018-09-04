package repository;

import model.FuncionarioModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepository extends BaseRepository {

    public void save(FuncionarioModel funcionario) throws SQLException {
        String sql = "insert into FUNCIONARIO (nome, telefone, cpf, endereco, numero, complemento, bairro, cidade, cep, obs, email) values (?,?,?,?,?,?,?,?,?,?,?)";
        preparaComandoSql(sql);

        stmt.setString(1, funcionario.getNome());
        stmt.setString(2, funcionario.getTelefone());
        stmt.setString(3, funcionario.getCpf());
        stmt.setString(4, funcionario.getEndereco());
        stmt.setString(5, funcionario.getNumero());
        stmt.setString(6, funcionario.getComplemento());
        stmt.setString(7, funcionario.getBairro());
        stmt.setString(8, funcionario.getCidade());
        stmt.setString(9, funcionario.getCep());
        stmt.setString(10, funcionario.getObs());
        stmt.setString(11, funcionario.getEmail());

        executaFinalizandoConexao();
    }

    public void update(FuncionarioModel funcionario) throws SQLException {
        String sql = "update FUNCIONARIO set nome = ?, telefone = ?, cpf = ?, endereco = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, cep = ?, obs = ?, email = ? where id = ?";
        preparaComandoSql(sql);

        stmt.setString(1, funcionario.getNome());
        stmt.setString(2, funcionario.getTelefone());
        stmt.setString(3, funcionario.getCpf());
        stmt.setString(4, funcionario.getEndereco());
        stmt.setString(5, funcionario.getNumero());
        stmt.setString(6, funcionario.getComplemento());
        stmt.setString(7, funcionario.getBairro());
        stmt.setString(8, funcionario.getCidade());
        stmt.setString(9, funcionario.getCep());
        stmt.setString(10, funcionario.getObs());
        stmt.setString(11, funcionario.getEmail());
        stmt.setLong(12, funcionario.getId());

        executaFinalizandoConexao();

    }

    public void delete(FuncionarioModel funcionario) throws SQLException {
        preparaComandoSql("select * from FUNCIONARIO where id = ?");
        stmt.setLong(1, funcionario.getId());
        executaFinalizandoConexao();
    }

    public List<FuncionarioModel> findAll() throws SQLException {
        List<FuncionarioModel> listCliente = new ArrayList<>();

        preparaComandoSql("select * from FUNCIONARIO");
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                FuncionarioModel funcionario = FuncionarioModel.builder()
                        .id(rs.getLong("id"))
                        .nome(rs.getString("nome"))
                        .telefone(rs.getString("telefone"))
                        .cpf(rs.getString("cpf"))
                        .obs(rs.getString("obs"))
                        .email(rs.getString("email"))
                        .build();
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setNumero(rs.getString("numero"));
                funcionario.setComplemento(rs.getString("complemento"));
                funcionario.setBairro(rs.getString("bairro"));
                funcionario.setCidade(rs.getString("cidade"));
                funcionario.setCep(rs.getString("cep"));
                
                listCliente.add(funcionario);
            }
        }
        finalizaConexao();

        return listCliente;
    }

    public FuncionarioModel findOne(FuncionarioModel filter)throws SQLException {
        FuncionarioModel funcionario = null;

        preparaComandoSql("select * from FUNCIONARIO where ID = ?");

        stmt.setLong(1, filter.getId());

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
           funcionario = FuncionarioModel.builder()
                   .id(rs.getLong("id"))
                   .nome(rs.getString("nome"))
                   .telefone(rs.getString("telefone"))
                   .cpf(rs.getString("cpf"))
                   .obs(rs.getString("obs"))
                   .email(rs.getString("email"))
                   .build();
           funcionario.setEndereco(rs.getString("endereco"));
           funcionario.setNumero(rs.getString("numero"));
           funcionario.setComplemento(rs.getString("complemento"));
           funcionario.setBairro(rs.getString("bairro"));
           funcionario.setCidade(rs.getString("cidade"));
           funcionario.setCep(rs.getString("cep"));
        }

        rs.close();
        finalizaConexao();

        return funcionario;
    }

}
