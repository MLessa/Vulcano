package service;

import java.util.ArrayList;

import model.Pessoa;
import dao.PessoaDao;

public class PessoaService {

	private PessoaDao pessoaDao;

	public PessoaService(){
		pessoaDao = new PessoaDao();
	}

	public void executeInsert(Pessoa pessoa){
		pessoaDao.executeInsert(pessoa);
	}

	public void executeUpdate(Pessoa pessoa){
		pessoaDao.executeUpdate(pessoa);
	}

	public ArrayList<Pessoa> findAll(){
		return pessoaDao.findAll();
	}

	public Pessoa findById(Long id){
		return pessoaDao.findById(id);
	}

	public ArrayList<Pessoa> findByExample(Pessoa pessoa){
		return pessoaDao.findByExample(pessoa);
	}
}
