package service;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Pessoa;
import dao.DaoBase;
import dao.PessoaDao;

public class PessoaService {

	private PessoaDao pessoaDao;

	public PessoaService(int op){
	/*
	 * 0 select
	 * 1 insert
	 * 2 delete
	 * 3 update
	 */
	
		pessoaDao = new PessoaDao();
		//op=1;
		////////////////
		Pessoa pessoa = new Pessoa();
		
		switch (op)
		{
			case 0:
				ArrayList<Pessoa> pes;
				pes = pessoaDao.findAll();
		
				for(int i = 0; i < pes.size(); i++) {
					System.out.println("nome:" + pes.get(i).getNome() + ", genero: " + pes.get(i).getGenero() + ", nascimento: " + pes.get(i).getDataNascimento() + ", filhos: " + pes.get(i).getQtdFilhos());
		        }
			
			break;
			
			case 1:
				pessoaDao.Insert(pessoa);
				
			break;
			
			case 2:
				pessoaDao.Delete(pessoa);
				
			break;
			
			case 3:
				pessoaDao.Update(pessoa);
				break;
		}
	}
}