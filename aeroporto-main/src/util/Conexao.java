
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {

    public static Connection con;
    
    public Connection conectar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/aeroporto?user=root&password=";
            try{
                con = DriverManager.getConnection(url);    
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Conexao: " + erro.getMessage());
            }
            return con;
        }catch(ClassNotFoundException erro){
            JOptionPane.showMessageDialog(null, "Conexao: " + erro.getMessage());
            return null;
        }
    }           

    public static void desconectar(){
        try{
            con.close();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Conexao: "+erro.getMessage());
        }
    }    
}
