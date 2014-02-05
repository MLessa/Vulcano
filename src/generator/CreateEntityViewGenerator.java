package generator;

import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import generator.AnnotationGetter;
import annotations.BoolColumn;
import annotations.DateColumn;
import annotations.IntColumn;
import annotations.LongColumn;
import annotations.Table;
import annotations.VarcharColumn;

import org.apache.commons.io.IOUtils;

public class CreateEntityViewGenerator {
	
	private Table table;
	
	private Class<?> entity; 
	
	private ArrayList<VarcharColumn> varcharList;
	private ArrayList<LongColumn> longList;
	private ArrayList<IntColumn> intList;
	private ArrayList<DateColumn> dateList;
	private ArrayList<BoolColumn> boolList;
	
	private String fields;
	private String labels;
	
	private String instacies;
	private String fileString;
	private String clearActions;

	public CreateEntityViewGenerator(Class<?> T) {

		this.table = AnnotationGetter.getTableAnnotation(T);
		
		this.varcharList = AnnotationGetter.getVarcharColumnAnnotations(T);
		this.longList = AnnotationGetter.getLongColumnAnnotations(T);
		this.intList = AnnotationGetter.getIntColumnAnnotations(T);
		this.dateList = AnnotationGetter.getDateColumnAnnotations(T);
		this.boolList = AnnotationGetter.getBoolColumnAnnotations(T);
		
		this.labels = new String();
		this.fields = new String();
		
		this.instacies = new String();
		this.fileString = new String();
		this.clearActions = new String();
		
	}
	

	private void generatePropertiesStrings(String type, String name){
		
		String labelName = name + "Label";
		
		String fieldName = name + "Field";
		
		this.labels = this.labels + "private JLabel " + labelName +";\n";
		this.fields = this.fields + "private " + type + " " + fieldName + ";\n";
		
		String fieldInstacies = new String();
		
		if (type.equals("JCheckBox")) {
			
			fieldInstacies = fieldName  + " = new " + type + "(\"\");\n contentPane.add(" + fieldName + ");\n\n";
			this.clearActions = this.clearActions + fieldName + ".setSelected(false);\n";
		}
		
		else if (type.equals("JFormattedTextField")) {
			
			String mask = "try {  \n " + fieldName + ".setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter(\"##-##-####\")));  \n } catch (ParseException e) { \n e.printStackTrace(); \n\n }"; 
			
			fieldInstacies = fieldName  + " = new " + type + "();\n contentPane.add(" + fieldName + ");\n" + mask + "\n";
			
			this.clearActions = this.clearActions + fieldName + ".setText(\"\");\n";
		}
		else{
			
			fieldInstacies = fieldName  + " = new " + type + "();\n contentPane.add(" + fieldName + ");\n" + fieldName + ".setColumns(10);\n\n";
			this.clearActions = this.clearActions + fieldName + ".setText(\"\");\n";
		}
		
		String labelsInstacies = labelName + " = new JLabel(\""  +name + "\");\n contentPane.add(" + labelName + ");\n\n";
		
		
		this.instacies = this.instacies + labelsInstacies + fieldInstacies;
	
	}
	
	
	private void generateViewProperties(){
		
		for (VarcharColumn var : this.varcharList) {
			if (!var.name().equals("id")) {
				this.generatePropertiesStrings("JTextField", var.name());
			}
			
		}
		for (LongColumn var : this.longList) {
			if (!var.name().equals("id")) {
				this.generatePropertiesStrings("JTextField", var.name());
			}
			
		}
		for (IntColumn var : this.intList) {
			if (!var.name().equals("id")) {
				this.generatePropertiesStrings("JTextField", var.name());
			}
			
		}
		for (DateColumn var : this.dateList) {
			if (!var.name().equals("id")) {
				this.generatePropertiesStrings("JFormattedTextField", var.name());
			}
			
		}
		
		for (BoolColumn var : this.boolList) {
			if (!var.name().equals("id")) {
				this.generatePropertiesStrings("JCheckBox", var.name());
			}
			
		}
	}
	
	public void generateJavaFile() throws IOException{
		
		this.generateViewProperties();
		
		String tableName = table.name() + "View";
		
		FileInputStream inputStream = new FileInputStream("/Users/douglasbarbosa/Documents/workspace3/Vulcano/src/main/createViewPrototype.txt");
		this.fileString = IOUtils.toString(inputStream);
		
		this.fileString = fileString.replace("<ClassName>", tableName);
		this.fileString = fileString.replace("<Labels>", this.labels);
		this.fileString = fileString.replace("<Fields>", this.fields);
		this.fileString = fileString.replace("<Instancies>", this.instacies);
		this.fileString = fileString.replace("<ClearActions>", this.clearActions);
		
	    File file = new File("/Users/douglasbarbosa/Documents/workspace3/Vulcano/src/view/"+ tableName +".java");
	    FileOutputStream fop = new FileOutputStream(file);

	    if (!file.exists()) {
	    	file.createNewFile();
	    }

	    byte[] contentInBytes = fileString.getBytes();

	    fop.write(contentInBytes);
	    fop.flush();
	    fop.close();

	    inputStream.close();
	
		
	}
	

}
