package repository;

import model.FornecedorModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorRepository extends BaseRepository {

    public void save(FornecedorModel fornecedor) throws SQLException {
        String sql = "insert into FORNECEDOR (nome_fantasia, cnpj, representante, telefone, email, celular, obs, endereco, numero, complemento, bairro, cidade, cep) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        preparaComandoSql(sql);

        stmt.setString(1, fornecedor.getNomeFantasia());
        stmt.setString(2, fornecedor.getCnpj());
        stmt.setString(3, fornecedor.getRepresentante());
        stmt.setString(4, fornecedor.getTelefone());
        stmt.setString(5, fornecedor.getEmail());
        stmt.setString(6, fornecedor.getCelular());
        stmt.setString(7, fornecedor.getObs());
        stmt.setString(8, fornecedor.getEndereco());
        stmt.setString(9, fornecedor.getNumero());
        stmt.setString(10, fornecedor.getComplemento());
        stmt.setString(11, fornecedor.getBairro());
        stmt.setString(12, fornecedor.getCidade());
        stmt.setString(13, fornecedor.getCep());

        executaFinalizandoConexao();
    }

    public void update(FornecedorModel fornecedor) throws SQLException {
        String sql = "update FORNECEDOR set nome_fantasia = ?, cnpj = ?, representante = ?, telefone = ?, email = ?, celular = ?, obs = ?, endereco = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, cep = ? where id = ?";
        preparaComandoSql(sql);

        stmt.setString(1, fornecedor.getNomeFantasia());
        stmt.setString(2, fornecedor.getCnpj());
        stmt.setString(3, fornecedor.getRepresentante());
        stmt.setString(4, fornecedor.getTelefone());
        stmt.setString(5, fornecedor.getEmail());
        stmt.setString(6, fornecedor.getCelular());
        stmt.setString(7, fornecedor.getObs());
        stmt.setString(8, fornecedor.getEndereco());
        stmt.setString(9, fornecedor.getNumero());
        stmt.setString(10, fornecedor.getComplemento());
        stmt.setString(11, fornecedor.getBairro());
        stmt.setString(12, fornecedor.getCidade());
        stmt.setString(13, fornecedor.getCep());
        stmt.setLong(14, fornecedor.getId());

        executaFinalizandoConexao();

    }

    public void delete(FornecedorModel fornecedor) throws SQLException {
        preparaComandoSql("select * from FORNECEDOR where id = ?");
        stmt.setLong(1, fornecedor.getId());
        executaFinalizandoConexao();
    }

    public List<FornecedorModel> findAll() throws SQLException {
        List<FornecedorModel> listFornecedor = new ArrayList<>();

        preparaComandoSql("select * from FORNECEDOR");
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                FornecedorModel fornecedor = FornecedorModel.builder()
                        .id(rs.getLong("id"))
                        .nomeFantasia(rs.getString("nome_fantasia"))
                        .cnpj(rs.getString("cnpj"))
                        .representante(rs.getString("representante"))
                        .telefone(rs.getString("telefone"))
                        .email(rs.getString("email"))
                        .celular(rs.getString("celular"))
                        .obs(rs.getString("obs"))
                        .build();
                fornecedor.setEndereco(rs.getString("endereco"));
                fornecedor.setNumero(rs.getString("numero"));
                fornecedor.setComplemento(rs.getString("complemento"));
                fornecedor.setBairro(rs.getString("bairro"));
                fornecedor.setCidade(rs.getString("cidade"));
                fornecedor.setCep(rs.getString("cep"));
                
                listFornecedor.add(fornecedor);
            }
        }
        finalizaConexao();

        return listFornecedor;
    }

    public FornecedorModel findOne(FornecedorModel filter)throws SQLException {
        FornecedorModel fornecedor = null;

        preparaComandoSql("select * from FORNECEDOR where ID = ?");

        stmt.setLong(1, filter.getId());

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                fornecedor = FornecedorModel.builder()
                        .id(rs.getLong("id"))
                        .nomeFantasia(rs.getString("nome_fantasia"))
                        .cnpj(rs.getString("cnpj"))
                        .representante(rs.getString("representante"))
                        .telefone(rs.getString("telefone"))
                        .email(rs.getString("email"))
                        .celular(rs.getString("celular"))
                        .obs(rs.getString("obs"))
                        .build();
                fornecedor.setEndereco(rs.getString("endereco"));
                fornecedor.setNumero(rs.getString("numero"));
                fornecedor.setComplemento(rs.getString("complemento"));
                fornecedor.setBairro(rs.getString("bairro"));
                fornecedor.setCidade(rs.getString("cidade"));
                fornecedor.setCep(rs.getString("cep"));
            }
        }
        finalizaConexao();

        return fornecedor;
    }

}
