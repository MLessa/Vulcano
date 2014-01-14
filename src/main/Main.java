package main;

import java.util.ArrayList;

import generator.AnnotationGetter;
import annotations.Table;
import annotations.VarcharColumn;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<VarcharColumn> list = AnnotationGetter.getVarcharColumnAnnotations(Pessoa.class);
		for (VarcharColumn var : list) {
			System.out.println(var.name());
			System.out.println(var.size());
			System.out.println(var.isUniqueKey());
			System.out.println(var.required());
			System.out.println("-------------------------");
		}
		Table table = AnnotationGetter.getTableAnnotation(Pessoa.class);
		System.out.println(table.name());
		System.out.println(table.primeryKeyParameterName());
		System.out.println(table.isPrimaryKeyAutoIncrement());
		
	}

}
