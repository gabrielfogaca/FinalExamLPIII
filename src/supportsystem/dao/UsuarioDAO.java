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
import supportsystem.models.Usuario;

public class UsuarioDAO {
       
    public boolean logar(Usuario usuario) throws SQLException {
        DataBase db = new DataBase();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = db.getConnection().prepareStatement("select * from usuario where login = ? and senha = ?");
            pstmt.setString(1, usuario.getLogin());
            pstmt.setString(2, usuario.getSenha());
            rs = pstmt.executeQuery();
  
            if(rs.next()){
                return true;
            } else{
                return false;
            }
        } catch (SQLException ex) {
            return false;
        } finally {
            db.close();
        }
        
    }
    
}
