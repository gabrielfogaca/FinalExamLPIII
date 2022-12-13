package supportsystem.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import supportsystem.database.DataBase;
import supportsystem.logging.LogController;
import supportsystem.models.Cliente;
import supportsystem.models.Produto;
import supportsystem.models.Vendedor;

public class VendedorDAO {

    public List<Vendedor> listarVendedores() throws SQLException {
        DataBase db = new DataBase();
        Statement stmt = null;
        ResultSet rs = null;
        List<Vendedor> vendedores = new ArrayList<>();

        try {
            stmt = db.getConnection().createStatement();
            rs = stmt.executeQuery("SELECT * FROM vendedor");

            while (rs.next()) {
                Vendedor vendedor = new Vendedor();

                vendedor.setId_vendedor(rs.getInt("id_vendedor"));
                vendedor.setNome_vendedor(rs.getString("nome_vendedor"));
                vendedor.setPc_comissao(rs.getInt("pc_comissao"));
                vendedores.add(vendedor);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
            LogController.createLog("Erro ao conectar-se na tabela VENDEDOR do banco de dados. " + ex.getMessage(), "S");
        } finally {
            db.close();
        }
        return vendedores;

    }
    
    public void inserirVendedor(Vendedor vendedor) throws SQLException {
        DataBase db = new DataBase();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = db.getConnection().prepareStatement("INSERT INTO vendedor (nome_vendedor, pc_comissao, id_operador) VALUES (?, ?,?)");
            pstmt.setString(1, vendedor.getNome_vendedor());
            pstmt.setInt(2,vendedor.getPc_comissao());
            pstmt.setInt(3,vendedor.getId_operador());
            pstmt.execute();

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            db.close();
        }
    }
    
    public boolean deleteVendedor(Vendedor vendedor) throws SQLException {
        DataBase db = new DataBase();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = db.getConnection().prepareStatement("delete from vendedor where id_vendedor = ?");
            pstmt.setInt(1,vendedor.getId_vendedor());
            pstmt.execute();

        } catch (SQLException ex) {
            return false;
        } finally {
            db.close();
        }
        return true;
    }

    public Vendedor buscarVendedor(int vendedorid) throws SQLException {
        DataBase db = new DataBase();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = db.getConnection().prepareStatement("select * from vendedor where id_vendedor = ?");
            pstmt.setInt(1,vendedorid);
            rs = pstmt.executeQuery();

            while (rs.next()) {

            Vendedor vendedor = new Vendedor(rs.getInt("id_vendedor"), rs.getString("nome_vendedor"), rs.getInt("pc_comissao"), rs.getInt("id_operador"));
            
            return vendedor;
            
            }
            

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            db.close();
        }
        return null;
    }
     
     public void editarVendedor(Vendedor vendedor) throws SQLException {
        DataBase db = new DataBase();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = db.getConnection().prepareStatement("update vendedor set nome_vendedor = ?, pc_comissao = ?, id_operador = ? where id_vendedor = ?");
            pstmt.setString(1, vendedor.getNome_vendedor());
            pstmt.setInt(2, vendedor.getPc_comissao());
            pstmt.setInt(3, vendedor.getId_operador());
            pstmt.setInt(4, vendedor.getId_vendedor());
            System.out.println(vendedor.getId_operador());
            
            pstmt.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex);
            LogController.createLog("Erro ao conectar-se na tabela vendedor do banco de dados. " + ex.getMessage(), "S");
        } finally {
            db.close();
        }
    }
}
