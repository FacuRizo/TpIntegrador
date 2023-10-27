package modelo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;
public class LectorArchivosPronosticos
{

	String rutaArchivoPronostico;
	List<ArchivoPronostico> LineasArchivoPronostico;
	
	public LectorArchivosPronosticos (String rutaArchivoPronostico)
	{
		this.rutaArchivoPronostico=rutaArchivoPronostico;
		LineasArchivoPronostico= new ArrayList<ArchivoPronostico>();
	}
	
	@SuppressWarnings("unchecked")
	public void parserArchivo()
	{
		List<ArchivoPronostico> listPronostico=null;
		  try 
		    {
	            // archivos que va a ingresar
			  	listPronostico = new CsvToBeanBuilder(new FileReader(this.rutaArchivoPronostico))
	                    // con esta configuración podemos skipear la primera línea de nuestro archivo CSV
	                    .withSkipLines(1)
	                    // con esta configuración podemos elegir cual es el caracter que vamos a usar para delimitar
	                    .withSeparator(',')
	                    // Es necesario definir el tipo de dato que va a generar el objeto que estamos queriendo parsear a partir del CSV
	                    .withType(ArchivoPronostico.class)
	                    .build()
	                    .parse();

	        } catch (IOException e) 
		  {
	        e.printStackTrace();
	        
		  }
		  this.LineasArchivoPronostico=listPronostico;
	        
	}
	
	//public ArrayList<ArchivoResultado> listarResultado()
}