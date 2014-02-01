package generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

public class ServiceGenerator {

	public static void generate(Class<?> T){

		File file = new File("src/service");
		file.mkdir();

		try {
			FileInputStream inputStream = new FileInputStream(new File("classModels/ServiceModel"));
			String fileString = IOUtils.toString(inputStream);
			fileString=fileString.replaceAll("<Class>", T.getName().split("model.")[1]);
			fileString=fileString.replaceAll("<Object>", T.getName().split("model.")[1].toLowerCase());
			file = new File("src/service/"+T.getName().split("model.")[1]+"Service.java");
			FileOutputStream fop = new FileOutputStream(file);
			file.createNewFile();
			byte[] contentInBytes = fileString.getBytes();
			fop.write(contentInBytes);
            fop.flush();
            fop.close();
 
            inputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


}
