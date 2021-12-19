package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.LoginModel;

public class UsuarioConexao {

    Connection con;

    public ResultSet autenticaUsuario(LoginModel objLogin) {
        con = new Conexao().conectar();

        try {
            String sql = "select * from users where user = ? and password = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            
            pstm.setString(1, objLogin.getUser());
            pstm.setString(2, objLogin.getPassword());
            
            ResultSet rs = pstm.executeQuery();
            
            return rs;
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioConexao: " + erro);
            return null;
        }
    }

}
