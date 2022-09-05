package MyServer.CsvXml;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import com.opencsv.exceptions.CsvException;

public class ConverterRunner {

	public static void main(String[] args) throws ClassNotFoundException {

		
		try {
			
			Converter.convert_csv(args[0], args[1], getClassFromFile(args[2]));
			TransformerFactory tfactory = TransformerFactory.newInstance();
			Transformer xform = tfactory.newTransformer(new StreamSource(args[3]));
			xform.transform(new StreamSource(args[1]),new StreamResult(args[4]));
			
		} catch (NoSuchMethodException | SecurityException
				| InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException
				| IOException | TransformerException e) {
			e.printStackTrace();
		} catch (CsvException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@SuppressWarnings("")
	public static Class getClassFromFile(String classPath) throws ClassNotFoundException, IOException {
		Path p = Paths.get(classPath);
	    URLClassLoader loader = new URLClassLoader(new URL[] {
	          p.toUri().toURL()
	    });
	    Class c = loader.loadClass("csv_to_xml.Contestant");
	    loader.close();
	    return c;
	}

}