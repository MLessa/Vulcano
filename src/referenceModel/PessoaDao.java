package referenceModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PessoaDao{
	private DaoBase daoBase;
	
	public PessoaDao(){
		daoBase=DaoBase.getInstance();
	}

	public void executeInsert(Pessoa pessoa) throws ClassNotFoundException, SQLException{
		String insert = "insert into pessoa(nome,dataNascimento,qtdFilhos) " +
				"values('"+pessoa.getNome()+
				","+pessoa.getDataNascimento()+
				",'"+ pessoa.getQtdFilhos()+"')";
		
		daoBase.executeInsert(insert);
	}

	public void executeUpdate(Pessoa pessoa) throws ClassNotFoundException, SQLException{
		String update = "update pessoa set nome = '"+ pessoa.getNome() 
				+ ", dataNascimento = " 
				+ pessoa.getDataNascimento() 
				+ ", qtdFilhos =" + pessoa.getQtdFilhos() 
				+ " where id =" + pessoa.getId();

		daoBase.executeUpdate(update);
	}

	public void executeDelete(Pessoa pessoa) throws ClassNotFoundException, SQLException{	
		String delete = "delete from pessoa where id ="+pessoa.getId(); 
		daoBase.executeDelete(delete);
	}

	public ArrayList<Pessoa> findAll() throws ClassNotFoundException, SQLException{
		ArrayList<Pessoa> pessoaList = new ArrayList<Pessoa>();
		String query = "Select * from Pessoa";
		ResultSet rs = daoBase.executeSelect(query);
		while(rs.next()){
			Pessoa pessoa = new Pessoa();
			pessoa.setNome(rs.getString("nome"));
			pessoa.setDataNascimento(rs.getDate("dataNascimento"));
			pessoa.setQtdFilhos(rs.getInt("qtdFilhos"));
			pessoaList.add(pessoa);
		}
		return pessoaList;
	}

	public Pessoa findById(Long id) throws SQLException, ClassNotFoundException{
		String select = "Select * from Pessoa where id="+id;
		ResultSet rs = daoBase.executeSelect(select);

		Pessoa pessoa = new Pessoa();
		pessoa.setNome(rs.getString("nome"));
		pessoa.setDataNascimento(rs.getDate("dataNascimento"));
		pessoa.setQtdFilhos(rs.getInt("qtdFilhos"));

		return pessoa;
	}

	public ArrayList<Pessoa> findByExemple(Pessoa exemple) throws ClassNotFoundException, SQLException{
		ArrayList<Pessoa> pessoaList = new ArrayList<Pessoa>();
		String query = "Select * from Pessoa where id=id";
		if(exemple.getNome()!=null)
			query+=" and nome="+exemple.getNome();

		ResultSet rs = daoBase.executeSelect(query);
		while(rs.next()){
			Pessoa pessoa = new Pessoa();
			pessoa.setNome(rs.getString("nome"));
			pessoa.setDataNascimento(rs.getDate("dataNascimento"));
			pessoa.setQtdFilhos(rs.getInt("qtdFilhos"));
			pessoaList.add(pessoa);
		}
		return pessoaList;
	}

}
