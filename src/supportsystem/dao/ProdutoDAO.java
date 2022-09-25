package supportsystem.dao;

import java.util.List;
import supportsystem.database.DataBase;
import supportsystem.models.Produto;
import java.sql.*;
import java.util.ArrayList;

public class ProdutoDAO {

    public List<Produto> listarProduto() throws SQLException {
        DataBase db = new DataBase();
        Statement stmt = null;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = db.getConnection().createStatement();
            rs = stmt.executeQuery("SELECT * FROM item");

            while (rs.next()) {
                Produto produto = new Produto();

                produto.setId_item(rs.getInt("id_item"));
                produto.setNome_item(rs.getString("nome_item"));
                produto.setPreco(rs.getInt("preco"));
                produto.setQtd(rs.getInt("qtde_estoque"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            db.close();
        }
        return produtos;

    }
}
