package supportsystem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import supportsystem.database.DataBase;
import supportsystem.logging.LogController;
import supportsystem.models.Cliente;

public class ClienteDAO {

    public List<Cliente> listarClientes() throws SQLException {
        DataBase db = new DataBase();
        Statement stmt = null;
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            stmt = db.getConnection().createStatement();
            rs = stmt.executeQuery("SELECT * FROM cliente");

            while (rs.next()) {
                Cliente cliente = new Cliente();

                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setNome_cliente(rs.getString("nome_cliente"));
                cliente.setId_tipo_cliente(rs.getInt("id_tipo_cliente"));
                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            db.close();
        }
        return clientes;

    }

    public void inserirCliente(Cliente cliente) throws SQLException {
        DataBase db = new DataBase();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = db.getConnection().prepareStatement("INSERT INTO cliente (nome_cliente, id_tipo_cliente, id_operador) VALUES (?, ?, ?)");
            pstmt.setString(1, cliente.getNome_cliente());
            pstmt.setInt(2, cliente.getId_tipo_cliente());
            pstmt.setInt(3, cliente.getId_operador());
            pstmt.execute();

        } catch (SQLException ex) {
            System.out.println(ex);
            LogController.createLog("Erro ao conectar-se na tabela CLIENTE do banco de dados. " + ex.getMessage(), "S");
        } finally {
            db.close();
        }
    }
    
   public void deletarCliente(Cliente cliente) throws SQLException {
        DataBase db = new DataBase();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = db.getConnection().prepareStatement("delete from cliente where id_cliente = ?");
            pstmt.setInt(1, cliente.getId_cliente());
            pstmt.execute();

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            db.close();
        }
    }
    
    public Cliente buscarCliente(int clienteid) throws SQLException {
        DataBase db = new DataBase();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = db.getConnection().prepareStatement("select * from cliente where id_cliente = ?");
            pstmt.setInt(1,clienteid);
            rs = pstmt.executeQuery();

            while (rs.next()) {

            Cliente cliente = new Cliente(rs.getInt("id_cliente"), rs.getString("nome_cliente"), rs.getInt("id_tipo_cliente"), rs.getInt("id_operador"));
            
            return cliente;
            
            }
            

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            db.close();
        }
        return null;
    }
     
     public void editarCliente(Cliente cliente) throws SQLException {
        DataBase db = new DataBase();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = db.getConnection().prepareStatement("update cliente set nome_cliente = ?, id_tipo_cliente = ?, id_operador = ? where id_cliente = ?");
            pstmt.setString(1, cliente.getNome_cliente());
            pstmt.setInt(2, cliente.getId_tipo_cliente());
            pstmt.setInt(3, cliente.getId_operador());
            pstmt.setInt(4, cliente.getId_cliente());
            pstmt.execute();
            
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
            LogController.createLog("Erro ao conectar-se na tabela CLIENTE do banco de dados. " + ex.getMessage(), "S");
        } finally {
            db.close();
        }
    }
     
     
    public Cliente ProcurarClienteParaTeste(int idcliente) throws SQLException {
        DataBase db = new DataBase();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = db.getConnection().prepareStatement("select * from cliente where id_cliente = ?");
            pstmt.setInt(1, idcliente);
            rs = pstmt.executeQuery();

            while (rs.next()) {

            Cliente Ccliente = new Cliente(rs.getInt("id_cliente"), rs.getString("nome_cliente"), rs.getInt("id_tipo_cliente"), rs.getInt("id_operador"));
            
            return Ccliente;
            
            }
            

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            db.close();
        }
        return null;
    }
    
}
