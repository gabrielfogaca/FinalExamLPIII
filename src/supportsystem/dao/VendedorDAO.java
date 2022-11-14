package supportsystem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import supportsystem.database.DataBase;
import supportsystem.logging.LogController;
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

}
