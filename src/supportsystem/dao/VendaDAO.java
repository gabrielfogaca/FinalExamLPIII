package supportsystem.dao;

import com.mysql.cj.jdbc.Driver;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import supportsystem.createXML.CriarDocumentoXML;
import supportsystem.database.DataBase;
import supportsystem.models.Vendedor;
import supportsystem.xml.ManipuladorXML;
import supportsystem.createXML.CriarDocumentoXML;

public class VendaDAO {

    public void inserirVendas(VendaDTO vendadto) throws SQLException {
        DataBase db = new DataBase();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        db.getConnection().setAutoCommit(false);
        try {

            pstmt = db.getConnection().prepareStatement("INSERT INTO venda (id_cliente, id_vendedor, nome_cliente, nome_vendedor, nome_item, vl_total_venda) values (?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1, vendadto.getId_cliente());
            pstmt.setInt(2, vendadto.getId_vendedor());
            pstmt.setString(3, vendadto.getNome_cliente());
            pstmt.setString(4, vendadto.getNome_vendedor());
            pstmt.setString(5, vendadto.getNome_item());
            pstmt.setFloat(6, vendadto.getValor_venda());

            pstmt.execute();

            //realizar o update na tabela de itens
            pstmt = db.getConnection().prepareStatement("UPDATE item set qtde_estoque = ? where nome_item = ?");
            pstmt.setInt(1, vendadto.getQuantidade_produto());
            pstmt.setString(2, vendadto.getNome_item());

            pstmt.execute();

            db.getConnection().commit();
        } catch (Exception e) {
            db.getConnection().rollback();
        }
        db.getConnection().setAutoCommit(true);
//        pstmt.close();       
    }

    public ArrayList<VendaDTO> listarVendas() throws SQLException {
        DataBase db = new DataBase();
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<VendaDTO> vendas = new ArrayList<>();

        try {
            stmt = db.getConnection().createStatement();
            rs = stmt.executeQuery("SELECT * FROM venda");

            while (rs.next()) {
                VendaDTO venda = new VendaDTO();

                venda.setId_venda(rs.getInt("id_venda"));
                venda.setId_cliente(rs.getInt("id_cliente"));
                venda.setId_vendedor(rs.getInt("id_vendedor"));
                venda.setNome_cliente(rs.getString("nome_cliente"));
                venda.setNome_vendedor(rs.getString("nome_vendedor"));
                venda.setNome_item(rs.getString("nome_item"));
                venda.setValor_venda(rs.getInt("vl_total_venda"));
                vendas.add(venda);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            db.close();
        }
        return vendas;

    }

    public ArrayList<VendaDTO> VendasXML(VendaDTO vendadto) throws SQLException {
        DataBase db = new DataBase();
        Statement stmt = null;
        ResultSet rs = null;
        
        ArrayList<VendaDTO> vendaXML = new ArrayList<>();
        
        String myQuery = "SELECT * FROM venda where id_venda = " + vendadto.getId_venda();
        
        System.out.println(myQuery);
        try {               
            stmt = db.getConnection().createStatement();
            rs = stmt.executeQuery(myQuery);

            while (rs.next()) {
                VendaDTO venda = new VendaDTO();

                venda.setId_venda(rs.getInt("id_venda"));
                venda.setId_cliente(rs.getInt("id_cliente"));
                venda.setId_vendedor(rs.getInt("id_vendedor"));
                venda.setNome_cliente(rs.getString("nome_cliente"));
                venda.setNome_vendedor(rs.getString("nome_vendedor"));
                venda.setNome_item(rs.getString("nome_item"));
                venda.setValor_venda(rs.getInt("vl_total_venda"));
                vendaXML.add(venda);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            db.close();
        }

        return CriarDocumentoXML.main(vendaXML);
        //preciso retornar um array contendo as informações da venda.

    }

}
