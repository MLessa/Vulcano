package dao;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Pessoa;

public class PessoaDao{
	
	public void Insert(Pessoa pessoa){
		pessoa.setNome("Nos");	
		pessoa.setQtdFilhos(17);
		///////////////
		
		String insert = "insert into pessoa(id,nome,genero,dataNascimento,qtdFilhos) values(null,'"+pessoa.getNome()+"',"+pessoa.getGenero()+","+pessoa.getDataNascimento()+",'"+ pessoa.getQtdFilhos()+"')";
		     
		try {
			DaoBase.executeInsert(insert);
		}
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString()+" Erro ao selecionar"); 
        }
	}
	
	public void Update(Pessoa pessoa){
		////////////
		pessoa.setNome("Eu");
		pessoa.setId(1);
		////////////
		
		String update = "update pessoa set nome = '"+ pessoa.getNome() +"', genero=" + pessoa.getGenero() + ", dataNascimento = " + pessoa.getDataNascimento() + ", qtdFilhos =" + pessoa.getQtdFilhos() + 
				" where id =" + pessoa.getId();
		     
		try {
			DaoBase.executeUpdate(update);
		}
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString()+" Erro ao atualizar"); 
        }
	}
	
	public void Delete(Pessoa pessoa){
	pessoa.setId(3);
	////////////
	
	String delete = "delete from pessoa where id ="+pessoa.getId(); 
		try {
			DaoBase.executeDelete(delete);
		}
	    catch(Exception e){
	        JOptionPane.showMessageDialog(null, e.toString()+" Erro ao remover"); 
	    }
	}
	
	public ArrayList<Pessoa> findAll(){
		ArrayList<Pessoa> pes = new ArrayList<Pessoa>();
		String select = "Select * from Les.pessoa";
		try {
			pes = DaoBase.executeSelect(select);
		}
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString()+" Erro ao selecionar"); 
        }
		return pes;
	}
	
	public Pessoa findById(Long id){
		return null;
	}
	
}
