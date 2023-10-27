package modelo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;
public class LectorArchivosResultado 
{
	String rutaArchivoResultado;
	String rutaArchivoPronostico;
	List<ArchivoResultado> LineasArchivoResultado;
	
	public LectorArchivosResultado (String rutaArchivoResultado)
	{
		this.rutaArchivoResultado=rutaArchivoResultado;
		LineasArchivoResultado= new ArrayList<ArchivoResultado>();
	}
	
	@SuppressWarnings("unchecked")
	public void parserArchivo()
	{
		List<ArchivoResultado> listResultado=null;
		  try 
		    {
	            // archivos que va a ingresar
			  	listResultado = new CsvToBeanBuilder(new FileReader(this.rutaArchivoResultado))
	                    // con esta configuración podemos skipear la primera línea de nuestro archivo CSV
	                    .withSkipLines(1)
	                    // con esta configuración podemos elegir cual es el caracter que vamos a usar para delimitar
	                    .withSeparator(',')
	                    // Es necesario definir el tipo de dato que va a generar el objeto que estamos queriendo parsear a partir del CSV
	                    .withType(ArchivoResultado.class)
	                    .build()
	                    .parse();

	        } catch (IOException e) 
		  {
	        e.printStackTrace();
	        
		  }
		  this.LineasArchivoResultado=listResultado;
	        
	}
	
	//public ArrayList<ArchivoResultado> listarResultado()
}
