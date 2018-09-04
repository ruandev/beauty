package repository;

import model.ClienteModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository extends BaseRepository {

    public ClienteModel save(ClienteModel cliente) throws SQLException {
        String sql = "insert into cliente (nome, telefone, rg, cpf, endereco, numero, complemento, bairro, cidade, cep, obs, email) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        preparaComandoSql(sql);

        stmt.setString(1, cliente.getNome());
        stmt.setString(2, cliente.getTelefone());
        stmt.setString(3, cliente.getRg());
        stmt.setString(4, cliente.getCpf());
        stmt.setString(5, cliente.getEndereco());
        stmt.setString(6, cliente.getNumero());
        stmt.setString(7, cliente.getComplemento());
        stmt.setString(8, cliente.getBairro());
        stmt.setString(9, cliente.getCidade());
        stmt.setString(10, cliente.getCep());
        stmt.setString(11, cliente.getObs());
        stmt.setString(12, cliente.getEmail());

        executaComandoSql();

        cliente.setId(retornaUltimoCodigo());

        finalizaConexao();

        return cliente;
    }

    public void update(ClienteModel cliente) throws SQLException {
        String sql = "update cliente set nome = ?, telefone = ?, rg = ?, cpf = ?, endereco = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, cep = ?, obs = ?, email = ? where id = ?";
        preparaComandoSql(sql);

        stmt.setString(1, cliente.getNome());
        stmt.setString(2, cliente.getTelefone());
        stmt.setString(3, cliente.getRg());
        stmt.setString(4, cliente.getCpf());
        stmt.setString(5, cliente.getEndereco());
        stmt.setString(6, cliente.getNumero());
        stmt.setString(7, cliente.getComplemento());
        stmt.setString(8, cliente.getBairro());
        stmt.setString(9, cliente.getCidade());
        stmt.setString(10, cliente.getCep());
        stmt.setString(11, cliente.getObs());
        stmt.setString(12, cliente.getEmail());
        stmt.setLong(13, cliente.getId());

        executaFinalizandoConexao();

    }

    public void delete(ClienteModel cliente) throws SQLException {
        preparaComandoSql("delete from CLIENTE where id = ?");
        stmt.setLong(1, cliente.getId());
        executaFinalizandoConexao();
    }

    public List<ClienteModel> findAll() throws SQLException {
        List<ClienteModel> listCliente = new ArrayList<>();

        preparaComandoSql("select * from CLIENTE");
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ClienteModel cliente = ClienteModel.builder()
                        .id(rs.getLong("id"))
                        .nome(rs.getString("nome"))
                        .telefone(rs.getString("telefone"))
                        .rg(rs.getString("rg"))
                        .cpf(rs.getString("cpf"))
                        .obs(rs.getString("obs"))
                        .email(rs.getString("email"))
                        .build();
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setNumero(rs.getString("numero"));
                cliente.setComplemento(rs.getString("complemento"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setCep(rs.getString("cep"));
                
                listCliente.add(cliente);
            }
        }
        finalizaConexao();

        return listCliente;
    }

    public ClienteModel findOne(ClienteModel cliente)throws SQLException {

        preparaComandoSql("select * from CLIENTE where ID = ?");

        stmt.setLong(1, cliente.getId());

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                cliente = ClienteModel.builder()
                        .id(rs.getLong("id"))
                        .nome(rs.getString("nome"))
                        .telefone(rs.getString("telefone"))
                        .rg(rs.getString("rg"))
                        .cpf(rs.getString("cpf"))
                        .obs(rs.getString("obs"))
                        .email(rs.getString("email"))
                        .build();
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setNumero(rs.getString("numero"));
                cliente.setComplemento(rs.getString("complemento"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setCep(rs.getString("cep"));
            }
        }
        finalizaConexao();

        return cliente;
    }

    public List<ClienteModel> findAllCombo() throws SQLException {
        List<ClienteModel> listCliente = new ArrayList<>();

        preparaComandoSql("select * from CLIENTE");
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ClienteModel cliente = ClienteModel.builder()
                        .id(rs.getLong("id"))
                        .nome(rs.getString("nome"))
                        .build();
                
                listCliente.add(cliente);
            }
        }
        finalizaConexao();

        return listCliente;
    }
    
}
