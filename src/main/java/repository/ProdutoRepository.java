package repository;

import model.ProdutoModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository extends BaseRepository {

    public void save(ProdutoModel produto) throws SQLException {
        String sql = "insert into PRODUTO (descricao, valor_venda, estoque_atual, obs) values (?,?,?,?)";
        preparaComandoSql(sql);

        stmt.setString(1, produto.getDescricao());
        stmt.setDouble(2, produto.getValorVenda());
        stmt.setInt(3, produto.getEstoqueAtual());
        stmt.setString(4, produto.getObs());

        executaFinalizandoConexao();
    }

    public void update(ProdutoModel produto) throws SQLException {
        String sql = "update PRODUTO set descricao = ?, valor_venda = ?, obs = ? where id = ?";
        preparaComandoSql(sql);

        stmt.setString(1, produto.getDescricao());
        stmt.setDouble(2, produto.getValorVenda());
        stmt.setString(4, produto.getObs());
        stmt.setLong(5, produto.getId());

        executaFinalizandoConexao();
    }

    public void updateEstoque(ProdutoModel produto) throws SQLException {
        String sql = "update PRODUTO set estoque_atual = ? where id = ?";
        preparaComandoSql(sql);

        stmt.setInt(1, produto.getEstoqueAtual());
        stmt.setLong(2, produto.getId());

        executaFinalizandoConexao();
    }

    public void delete(ProdutoModel produto) throws SQLException {
        preparaComandoSql("select * from PRODUTO where id = ?");
        stmt.setLong(1, produto.getId());
        executaFinalizandoConexao();
    }

    public List<ProdutoModel> findAll() throws SQLException {
        List<ProdutoModel> listProduto = new ArrayList<>();

        preparaComandoSql("select * from PRODUTO");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            ProdutoModel produto = ProdutoModel.builder()
                    .id(rs.getLong("id"))
                    .descricao(rs.getString("descricao"))
                    .valorVenda(rs.getDouble("valor_venda"))
                    .estoqueAtual(rs.getInt("estoque_atual"))
                    .obs(rs.getString("obs"))
                    .build();

            listProduto.add(produto);
        }

        rs.close();
        finalizaConexao();

        return listProduto;
    }

    public ProdutoModel findOne(ProdutoModel filter)throws SQLException {
        ProdutoModel produto = null;

        preparaComandoSql("select * from PRODUTO where ID = ?");

        stmt.setLong(1, filter.getId());

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            produto = ProdutoModel.builder()
                    .id(rs.getLong("id"))
                    .descricao(rs.getString("descricao"))
                    .valorVenda(rs.getDouble("valor_venda"))
                    .estoqueAtual(rs.getInt("estoque_atual"))
                    .obs(rs.getString("obs"))
                    .build();
        }

        rs.close();
        finalizaConexao();

        return produto;
    }
}
