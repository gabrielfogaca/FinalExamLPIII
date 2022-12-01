package supportsystem.dao;

import java.util.List;
import supportsystem.database.DataBase;
import supportsystem.models.Produto;
import java.sql.*;
import java.util.ArrayList;
import supportsystem.logging.LogController;
import supportsystem.models.Cliente;
import supportsystem.models.Vendedor;

public class ProdutoDAO {

    public ArrayList<ProdutoDTO> listarProduto() throws SQLException {
        DataBase db = new DataBase();
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<ProdutoDTO> produtos = new ArrayList<>();

        try {
            stmt = db.getConnection().createStatement();
            rs = stmt.executeQuery("SELECT * FROM item");

            while (rs.next()) {
                ProdutoDTO produto = new ProdutoDTO();

                produto.setId_item(rs.getInt("id_item"));
                produto.setNome_item(rs.getString("nome_item"));
                produto.setPreco(rs.getFloat("preco"));
                produto.setQtde_produto(rs.getInt("qtde_estoque"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            db.close();
        }
        return produtos;

    }
    
    
    public void inserirProduto(Produto produto) throws SQLException {
        DataBase db = new DataBase();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = db.getConnection().prepareStatement("INSERT INTO item (nome_item, preco, qtde_estoque) VALUES (?, ?, ?)");
            pstmt.setString(1, produto.getNome_item());
            pstmt.setFloat(2,produto.getPreco());
            pstmt.setInt(3,produto.getQtd());
            pstmt.execute();

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            db.close();
        }
    }
    
    /**
     *
     * @return
     * @throws SQLException
     */
    public List<Produto> listarProdutoVenda() throws SQLException {
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
                produto.setPreco(rs.getFloat("preco"));
                produto.setQtd(rs.getInt("qtde_estoque"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
            LogController.createLog("Erro ao conectar-se na tabela PRODUTO do banco de dados. " + ex.getMessage(), "S");
        } finally {
            db.close();
        }
        return produtos;

    }
    
    public ArrayList<ProdutoDTO> deleteProduto(ProdutoDTO produtodto) throws SQLException {
        DataBase db = new DataBase();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = db.getConnection().prepareStatement("delete from item where id_item = ?");
            pstmt.setInt(1,produtodto.getId_item());
            pstmt.execute();

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            db.close();
        }
        return null;
    }

     public Produto buscarProduto(int produtoid) throws SQLException {
        DataBase db = new DataBase();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = db.getConnection().prepareStatement("select * from item where id_item = ?");
            pstmt.setInt(1,produtoid);
            rs = pstmt.executeQuery();

            while (rs.next()) {

            Produto produto = new Produto(rs.getInt("id_item"), rs.getString("nome_item"), rs.getInt("preco"), rs.getInt("qtde_estoque"));
            
            return produto;
            
            }
            

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            db.close();
        }
        return null;
    }
     
     public void editarProduto(Produto produto) throws SQLException {
        DataBase db = new DataBase();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = db.getConnection().prepareStatement("update item set nome_item = ?, preco = ? where id_item = ?");
            pstmt.setString(1, produto.getNome_item());
            pstmt.setInt(2, (int) produto.getPreco());
            pstmt.setInt(3, produto.getId_item());
            pstmt.execute();
            System.out.println(pstmt);
            
        } catch (SQLException ex) {
            System.out.println(ex);
            LogController.createLog("Erro ao conectar-se na tabela ITEM do banco de dados. " + ex.getMessage(), "S");
        } finally {
            db.close();
        }
    }
}
