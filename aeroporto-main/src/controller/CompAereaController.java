/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import util.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CompAereaController {
    
    Connection con;
    
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
