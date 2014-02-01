package generator;

import java.lang.reflect.Field;
import java.util.ArrayList;

import annotations.DateColumn;
import annotations.IntColumn;
import annotations.LongColumn;
import annotations.Table;
import annotations.VarcharColumn;

public class AnnotationGetter {
	
	public static ArrayList<VarcharColumn> getVarcharColumnAnnotations(Class<?> T){
		ArrayList<VarcharColumn> annotations = new ArrayList<VarcharColumn>();
		for (Field field : T.getDeclaredFields()) {
			if(field.isAnnotationPresent(VarcharColumn.class)){
				annotations.add(field.getAnnotation(VarcharColumn.class));
			}
		}
		return annotations;
	}
	
	public static ArrayList<DateColumn> getDateColumnAnnotations(Class<?> T){
		ArrayList<DateColumn> annotations = new ArrayList<DateColumn>();
		for (Field field : T.getDeclaredFields()) {
			if(field.isAnnotationPresent(DateColumn.class)){
				annotations.add(field.getAnnotation(DateColumn.class));
			}
		}
		return annotations;
	}
	
	public static ArrayList<IntColumn> getIntColumnAnnotations(Class<?> T){
		ArrayList<IntColumn> annotations = new ArrayList<IntColumn>();
		for (Field field : T.getDeclaredFields()) {
			if(field.isAnnotationPresent(IntColumn.class)){
				annotations.add(field.getAnnotation(IntColumn.class));
			}
		}
		return annotations;
	}
	
	public static ArrayList<LongColumn> getLongColumnAnnotations(Class<?> T){
		ArrayList<LongColumn> annotations = new ArrayList<LongColumn>();
		for (Field field : T.getDeclaredFields()) {
			if(field.isAnnotationPresent(LongColumn.class)){
				annotations.add(field.getAnnotation(LongColumn.class));
			}
		}
		return annotations;
	}
		
	public static Table getTableAnnotation(Class<?> T){
		return T.getAnnotation(Table.class);
	}
	
	
	
	
	
	
}
