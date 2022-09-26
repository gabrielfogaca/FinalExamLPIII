package supportsystem.dao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import supportsystem.database.DataBase;
import supportsystem.models.Vendedor;

public class VendaDAO {

    public void inserirVendas(VendaDTO vendadto) throws SQLException {
        DataBase db = new DataBase();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        pstmt = db.getConnection().prepareStatement("INSERT INTO venda (id_cliente, id_vendedor, nome_cliente, nome_vendedor, nome_item, vl_total_venda) values (?, ?, ?, ?, ?, ?)");
        pstmt.setInt(1, vendadto.getId_cliente());
        pstmt.setInt(2, vendadto.getId_vendedor());
        pstmt.setString(3, vendadto.getNome_cliente());
        pstmt.setString(4, vendadto.getNome_vendedor());
        pstmt.setString(5, vendadto.getNome_item());
        pstmt.setFloat(6, vendadto.getValor_venda());

        pstmt.execute();
        pstmt.close();
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
}
