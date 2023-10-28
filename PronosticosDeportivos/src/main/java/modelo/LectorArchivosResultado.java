package modelo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;
public class LectorArchivosResultado 
{
	String rutaArchivoResultado;
	
	List<ArchivoResultado> LineasArchivoResultado;
	
	public LectorArchivosResultado (String rutaArchivoResultado)
	{
		this.rutaArchivoResultado=rutaArchivoResultado;
		LineasArchivoResultado= new ArrayList<ArchivoResultado>();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	
	public ArrayList<Partido> agregarObjPartido (List<ArchivoResultado> partidos)
	{
		ArrayList<Partido> partidosF=new ArrayList<Partido>(); 
		for (ArchivoResultado partido: partidos)
		{
			//inicializamos
			Equipo equipo1 = new Equipo();
			Equipo equipo2 = new Equipo();
			Partido part=new Partido();
			//seteamos nomnbre
			equipo1.setNombre(partido.getEquipo1());
			equipo2.setNombre(partido.getEquipo2());
			//setteamos equipos y goles
			part.setEquipo1(equipo1);
			part.setEquipo2(equipo2);
			part.setGolesEquipo1(partido.getCantGoles1());
			part.setGolesEquipo2(partido.getCantGoles2());
			partidosF.add(part);		
		
			
		}
		return partidosF; // devolvemos lista de partidos
	}
}

