package referenceModel;

import java.util.Date;

import annotations.DateColumn;
import annotations.IntColumn;
import annotations.LongColumn;
import annotations.Table;
import annotations.VarcharColumn;


@Table(name = "Pessoa", primeryKeyParameterName = "id")
public class Pessoa {

	@LongColumn(isUniqueKey=true,name="id",required=true)
	private Long id;
	
	@VarcharColumn(isUniqueKey=false,name="nome",required=false,size=250)
	private String nome;
	
	@IntColumn(isUniqueKey=false,name="qtdFilhos",required=false)
	private int qtdFilhos;
	
	@DateColumn(isUniqueKey=false,name="dataNascimento",required=true)
	private Date dataNascimento;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
