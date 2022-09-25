package supportsystem.dao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import supportsystem.database.DataBase;

public class VendaDAO {

    public void listarVendas(VendaDTO vendadto) throws SQLException {
        DataBase db = new DataBase();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        pstmt = db.getConnection().prepareStatement("INSERT INTO venda (nome_cliente, nome_vendedor, nome_item, vl_total_venda) values (?, ?, ?, ?)");
        pstmt.setString(1, vendadto.getNome_cliente());
        pstmt.setString(2, vendadto.getNome_vendedor());
        pstmt.setString(3, vendadto.getNome_item());
        pstmt.setInt(4, vendadto.getValor_venda());

        pstmt.executeQuery();
        pstmt.close();
    }
}