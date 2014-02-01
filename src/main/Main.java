package main;

import referenceModel.Pessoa;
import generator.ServiceGenerator;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServiceGenerator.generate(Pessoa.class);
	}

}
