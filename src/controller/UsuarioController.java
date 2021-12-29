package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import model.LoginModel;
import util.Conexao;

public class UsuarioController {

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
    
    public ResultSet buscaUltimoUsuario(){
        con = new Conexao().conectar();
        try {
            String sql = "select count(iduser)+1 as lastCod from users";
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            return rs;
        }catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "UsuarioConexao: " + erro);
            return null;
        }
    }
    
    public boolean cadastraUsuario(LoginModel usuario){
        boolean retorno = false;
        con = new Conexao().conectar();
        String sql = "insert into users(user, password, nameuser, compAerea, situacao, perfil) values (?,?,?,?,?,?)";
        try{
            PreparedStatement comando = Conexao.con.prepareStatement(sql);
            comando.setString(1, usuario.getUser());
            comando.setString(2, usuario.getPassword());
            comando.setString(3, usuario.getNameUser());
            comando.setInt(4, usuario.getCompAerea());
            comando.setInt(5, usuario.getSituacao());
            comando.setInt(6, usuario.getPerfilUsuario());
            if(!comando.execute()){
                retorno = true;
            }else {
                retorno = false;
            }
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "UsuarioConexao: " + erro);
            retorno = false;
        }
        
        return retorno;
    }
    
    public ResultSet buscaUsuario(int idUsuario){
        con = new Conexao().conectar();
        
        String sql = "select * from users where idUser = ?";
        
        try {

            PreparedStatement pstm = con.prepareStatement(sql);
            
            pstm.setInt(1, idUsuario);
            
            ResultSet rs = pstm.executeQuery();
            
            return rs;
        }catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "UsuarioConexao: " + erro);
            return null;
        }

    }
    
    public boolean excluiUsuario(int idUsuario){
        boolean retorno = false;
        con = new Conexao().conectar();
        String sql = "delete from users where idUser = ?";
        try{
            PreparedStatement comando = Conexao.con.prepareStatement(sql);
            
            comando.setInt(1, idUsuario);
            
            if(!comando.execute()){
                retorno = true;
            }else{
                retorno = false;
            }
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "UsuarioConexao: " + erro);
            retorno = false;
        }
        
        return retorno;
    }
    
    public ResultSet buscaCompAerea(List<String> listCompAerea) throws SQLException{
    con = new Conexao().conectar();
    
    
        try{
        String sql = "select descricao from companiaaerea where idCompAerea <> 1 order by idCompAerea";
        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            listCompAerea.add(rs.getString("descricao"));
        }

        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "UsuarioConexao: " + erro);
        }
        
        return null;
    }
    

}
