package generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.IOUtils;

import annotations.BoolColumn;
import annotations.DateColumn;
import annotations.IntColumn;
import annotations.LongColumn;
import annotations.Table;
import annotations.VarcharColumn;

public class DaoGenerator {
    
    public static void generate(Class<?> T){

        File file = new File("src/dao");
        file.mkdir();
        
        ArrayList<VarcharColumn> varcharList;
        ArrayList<LongColumn> longList;
        ArrayList<IntColumn> intList;
        ArrayList<DateColumn> dateList;
        ArrayList<BoolColumn> boolList;
        
        String insert = "";
        String valuesInsert = "";
        String valuesSelect = "";
        String valuesUpdate = "";
        String select;
        String update;
        String where = "";
        
        String a = "";
        String b = T.getName().split("model.")[1].toLowerCase();
        try {
            FileInputStream inputStream = new FileInputStream(new File("classModels/DaoModel"));
            String fileString = IOUtils.toString(inputStream);
            fileString=fileString.replaceAll("<Class>", T.getName().split("model.")[1]);
            fileString=fileString.replaceAll("<Object>", T.getName().split("model.")[1].toLowerCase());
         
            //delete
             String tableName = AnnotationGetter.getTableAnnotation(T).name();
             fileString=fileString.replaceAll("<Table>", tableName);

             //insert
            varcharList = AnnotationGetter.getVarcharColumnAnnotations(T);
            longList = AnnotationGetter.getLongColumnAnnotations(T);
            intList = AnnotationGetter.getIntColumnAnnotations(T);
            dateList = AnnotationGetter.getDateColumnAnnotations(T);
            boolList = AnnotationGetter.getBoolColumnAnnotations(T);
        
            insert = "";
            update = "";
            valuesInsert = "";
            valuesSelect = "";
            valuesUpdate = "";
            where = "";
            for (VarcharColumn varV : varcharList) {
                if (!varV.name().equals("id")) {
                	insert += varV.name()+",";
                	a = varV.name().valueOf(varV.name().toCharArray()[0]).toUpperCase() + varV.name().substring(1);
                    valuesInsert += b+".get"+a+"(),";
                    valuesSelect += b+".set"+a+"(rs.getString("+ '"'+ varV.name() + '"'+"); ";
                    valuesUpdate += varV.name() + "="+b+".get"+a+"(),";
                }else{
                	a = varV.name().valueOf(varV.name().toCharArray()[0]).toUpperCase() + varV.name().substring(1);   
                    where = varV.name() + "="+b+".get"+a+"()";
                }
            }
            for (LongColumn varL : longList) {
                if (!varL.name().equals("id")) {
                    insert += varL.name()+",";
                    a = varL.name().valueOf(varL.name().toCharArray()[0]).toUpperCase() + varL.name().substring(1);
                    valuesInsert += b+".get"+a+"(),";
                    valuesSelect += b+".set"+a+"(rs.getString("+ '"'+ varL.name() + '"'+"); ";
                    valuesUpdate += varL.name() + "="+b+".get"+a+"(),";
                }
                else{
                	a = varL.name().valueOf(varL.name().toCharArray()[0]).toUpperCase() + varL.name().substring(1);   
                    where = varL.name() + "="+b+".get"+a+"()";
                }
            }
            for (DateColumn varD : dateList) {
                if (!varD.name().equals("id")) {
                    insert += varD.name()+",";
                    a = varD.name().valueOf(varD.name().toCharArray()[0]).toUpperCase() + varD.name().substring(1);
                    valuesInsert += b+".get"+a+"(),";
                    valuesSelect += b+".set"+a+"(rs.getDate("+ '"'+ varD.name() + '"'+"); ";
                    valuesUpdate += varD.name() + "="+b+".get"+a+"(),";
                }
                else{
                	a = varD.name().valueOf(varD.name().toCharArray()[0]).toUpperCase() + varD.name().substring(1);   
                    where = varD.name() + "="+b+".get"+a+"()";
                }
            }
            for (BoolColumn varB : boolList) {
                if (!varB.name().equals("id")) {
                    insert += varB.name()+",";
                    a = varB.name().valueOf(varB.name().toCharArray()[0]).toUpperCase() + varB.name().substring(1);
                    valuesInsert += b+".get"+a+"(),";
                    valuesSelect += b+".set"+a+"(rs.getInt("+ '"'+ varB.name() +'"'+"); ";
                    valuesUpdate += varB.name() + "="+b+".get"+a+"(),";
                }
                else{
                	a = varB.name().valueOf(varB.name().toCharArray()[0]).toUpperCase() + varB.name().substring(1);   
                    where = varB.name() + "="+b+".get"+a+"()";
                }
            }
            for (IntColumn varI :intList) {
                if (!varI.name().equals("id")) {    
                insert += varI.name()+",";
                    a = varI.name().valueOf(varI.name().toCharArray()[0]).toUpperCase() + varI.name().substring(1);
                    valuesInsert += b+".get"+a+"(),";
                    valuesSelect += b+".set"+a+"(rs.getInt("+ '"'+ varI.name() +'"'+"); ";
                    valuesUpdate += varI.name() + "="+b+".get"+a+"(),";
                }
                else{
                	a = varI.name().valueOf(varI.name().toCharArray()[0]).toUpperCase() + varI.name().substring(1);   
                    where = varI.name() + "="+b+".get"+a+"()";
                }
            }
            valuesInsert=valuesInsert.substring(0, valuesInsert.length()-1);
            insert=insert.substring(0, insert.length()-1);
            valuesUpdate = valuesUpdate.substring(0, valuesUpdate.length()-1);
            valuesUpdate += " where "+where;
            fileString=fileString.replaceAll("<InsertFildsValues>", T.getName().split("model.")[1].toLowerCase());
            fileString=fileString.replaceAll("<InsertFields>", T.getName().split("model.")[1].toLowerCase());
            fileString=fileString.replaceAll("<UpdateFields>", valuesUpdate);
            fileString=fileString.replaceAll("<SelectFildsValues>", valuesSelect);

            file = new File("src/dao/"+T.getName().split("model.")[1]+"Dao.java");
            FileOutputStream fop = new FileOutputStream(file);
            file.createNewFile();
            byte[] contentInBytes = fileString.getBytes();
            fop.write(contentInBytes);
            fop.flush();
            fop.close();
 
            inputStream.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
        }


    }


}        