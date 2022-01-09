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
import model.CompAereaModel;

public class CompAereaController {
    
    Connection con;
    
    public ResultSet buscaCompAerea(String codCompAerea){
        con = new Conexao().conectar();
        String sql = "select * from companiaaerea where idCompAerea = ?";
        
        try{
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setString(1, codCompAerea);
            ResultSet rs = comando.executeQuery();
            
            return rs;
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "CompAereaConexao: " + erro);
            return null;
        }

    }
    
    public ResultSet buscaUltimaCompAerea(){
        con = new Conexao().conectar();
        try {
            String sql = "select max(idCompAerea)+1 as lastCod from companiaAerea";
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            return rs;
        }catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "CompAereaConexao: " + erro);
            return null;
        }
    }
    
    public boolean excluiCompAerea(int idCompAerea){
        boolean retorno = false;
        con = new Conexao().conectar();
        String sql = "delete from companiaAerea where idCompAerea = ?";
        try{
            PreparedStatement comando = Conexao.con.prepareStatement(sql);
            
            comando.setInt(1, idCompAerea);
            
            if(!comando.execute()){
                retorno = true;
            }else{
                retorno = false;
            }
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "compAereaConexao: " + erro);
            retorno = false;
        }
        
        return retorno;
    }
    
    public boolean cadastraCompAerea(CompAereaModel compAerea){
        boolean retorno = false;
        con = new Conexao().conectar();
        String sql = "insert into companiaAerea(descricao, situacao) values (?,?)";
        try{
            PreparedStatement comando = Conexao.con.prepareStatement(sql);
            comando.setString(1, compAerea.getCompAerea());
            comando.setString(2, Integer.toString(compAerea.getSituacao()));
            if(!comando.execute()){
                retorno = true;
            }else {
                retorno = false;
            }
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "compAereaConexao: " + erro);
            retorno = false;
        }
        
        return retorno;
    } 
    
    
}
