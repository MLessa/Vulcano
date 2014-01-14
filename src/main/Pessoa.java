package main;

import annotations.LongColumn;
import annotations.Table;
import annotations.VarcharColumn;

@Table(name = "Pessoa", primeryKeyParameterName = "id")
public class Pessoa {
	
	@LongColumn(name = "id")
	private Long id;
	
	@VarcharColumn(name = "nome", size = 250)
	private String nome;
	
	@VarcharColumn(name = "cpf", size = 8)
	private String cpf;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
