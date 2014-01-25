package model;

import java.util.Date;
//import annotations.LongColumn;
//import annotations.Table;
//import annotations.VarcharColumn;

//@Table(name = "Pessoa", primeryKeyParameterName = "id")
public class Pessoa {
	
	//@LongColumn(name = "id")
	private Long id;
	
	//@VarcharColumn(name = "nome", size = 250)
	private String nome;
	
	private int qtdFilhos;
	
	private Date dataNascimento;

	private boolean genero;

	public boolean getGenero() {
		return this.genero;
	}

	public void setGenero(boolean genero) {
		this.genero = genero;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtdFilhos() {
		return qtdFilhos;
	}

	public void setQtdFilhos(int qtdFilhos) {
		this.qtdFilhos = qtdFilhos;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	
}
