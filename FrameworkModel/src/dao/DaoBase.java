/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.*;
import java.sql.*;
import javax.swing.JOptionPane;

import model.Pessoa;

/**
 *
 * @author annaluiza
 */ 
public class DaoBase{

	private static Connection connection = null;
    
    public static Statement getStatment() throws SQLException{
        
        if(connection == null){
            String url = "jdbc:mysql://localhost:3306/Les";
            try{
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url, "root","");
            } 
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString()+" FALHA NA CONEXÃO"); 
            }
        }
        return connection.createStatement();
    }
    
    public static ArrayList<Pessoa> executeSelect(String select) throws SQLException{
    	ArrayList<Pessoa> list = new ArrayList<Pessoa>();
    	 
    	try {
    		Statement stmt = getStatment();
            ResultSet rs;
            rs = stmt.executeQuery(select);
            while(rs.next())
            {
            	Pessoa p = new Pessoa();
            	p.setNome(rs.getString("nome"));
            	p.setGenero(rs.getBoolean("genero"));
            	p.setDataNascimento(rs.getDate("dataNascimento"));
            	p.setQtdFilhos(rs.getInt("qtdFilhos"));
            	//System.out.println("nome:" + p.getNome() + ", genero: " + p.getGenero() + ", nascimento: " + p.getDataNascimento() + ", filhos: " + p.getQtdFilhos());
            	list.add(p);
            }
        }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString()+" Erro ao selecionar"); 
            }
		return list;
    }
    
    public static void executeInsert(String insert) {
    	try {
        	Statement stmt = DaoBase.getStatment();
            stmt.executeUpdate(insert);
            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "Confirmação do Sistema", JOptionPane.INFORMATION_MESSAGE);
            stmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Erro ao cadastrar.");
                e.getStackTrace();
            }
        }
    
    public static void executeDelete(String delete) {
    	try {
    		System.out.println(delete);
        	Statement stmt = DaoBase.getStatment();
            stmt.executeUpdate(delete);
            JOptionPane.showMessageDialog(null, "Remocao efetuada!", "Confirmação do Sistema", JOptionPane.INFORMATION_MESSAGE);
            stmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Erro ao remover.");
                e.getStackTrace();
            }
        }
    
    public static void executeUpdate(String update) {
    	try {
    		System.out.println(update);
        	Statement stmt = DaoBase.getStatment();
        	System.out.println(stmt);
        	
        	stmt.executeUpdate(update);
            JOptionPane.showMessageDialog(null, "Dado atualizado!", "Confirmação do Sistema", JOptionPane.INFORMATION_MESSAGE);
            stmt.close();
            } catch (SQLException e) {
            	System.out.println(e);
            	
            	JOptionPane.showMessageDialog(null,"Erro ao  dados.");
                e.getStackTrace();
            }
        }
}
