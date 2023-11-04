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
	
	public ArrayList<Partido> agregarObjPartido (List<ArchivoResultado> listaPartidos)
	{
		ArrayList<Partido> partidosFinal=new ArrayList<Partido>(); 
		for (ArchivoResultado partidoIndividual: listaPartidos)
		{
			
			//boolean gana=Boolean.parseBoolean(pronostico1.getGana1());
			int cantGoles1 = Integer.parseInt(partidoIndividual.getCantGoles1());
			int cantGoles2 = Integer.parseInt(partidoIndividual.getCantGoles2());
			
			int nroRonda = Integer.parseInt(partidoIndividual.getNroRonda());
			
			//inicializamos
			Equipo equipo1 = new Equipo();
			Equipo equipo2 = new Equipo();
			Partido partido=new Partido();
			//seteamos nombre
			equipo1.setNombre(partidoIndividual.getEquipo1());
			equipo2.setNombre(partidoIndividual.getEquipo2());
			
			//setteamos equipos y goles
			partido.setEquipo1(equipo1);
			partido.setEquipo2(equipo2);
			
			partido.setGolesEquipo1(cantGoles1);
			partido.setGolesEquipo2(cantGoles2);
			
			partido.setNroRonda(nroRonda);
			
			partidosFinal.add(partido);		
		
			
		}
		return partidosFinal; // devolvemos lista de partidos
	}

}

