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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	
	public  ArrayList<Pronostico> agregarObjPronostico(List<ArchivoPronostico> pronosticos)
	{
		ArrayList<Pronostico> pronosticoF=new ArrayList<Pronostico>(); 
		for (ArchivoPronostico pronostico1: pronosticos)
		{
			// obtener string true or false  de los sig 3 valores y convertirlos a  boolean
			
			boolean gana=Boolean.parseBoolean(pronostico1.getGana1()); 
			boolean gana2=Boolean.parseBoolean(pronostico1.getGana2());
			boolean empata=Boolean.parseBoolean(pronostico1.getEmpata());
			
			
			// inicializar equipo, partido y pronostico
			
			Equipo equipo1 = new Equipo();
			
			Equipo equipo2 = new Equipo();
			
			Partido part=new Partido();	
			
			Pronostico pron= new Pronostico();
			
		//	Boolean.parseBoolean(pronostico.getEmpata());
			
			//del archivo de pronosticos saco el nombre del equipo y lo agrego al obj equipo correspondiente
			equipo1.setNombre(pronostico1.getEquipo1());
			part.setEquipo1(equipo1);
			
			equipo2.setNombre(pronostico1.getEquipo2());
			part.setEquipo2(equipo2);
			
			
			//settear partido
			pron.setPartido(part);
			pron.setParticipante(pronostico1.getParticipante());
		//	ResultadoEnum resultado = part.resultado(equipo1);
			
			// aunque funciona es necesario setteearlo correctamente 
			
			if (gana) // si gana1 es true entonces el equipo seleccinado por la persona es el uno y el resultado es Ganador
			{
				pron.setEquipo(equipo1);
				pron.setResultado(ResultadoEnum.Ganador);
				
			}
			else if (empata) //si empata es true entonces el equipo seleccinado por la persona no importa y el resultado es empate
			{
				pron.setEquipo(equipo1);
				//pron.setEquipo(equipo2);
				pron.setResultado(ResultadoEnum.Empate);
			}
			else if (gana2) //
			{
				pron.setEquipo(equipo2);
				pron.setResultado(ResultadoEnum.Ganador);
			}
			pronosticoF.add(pron);	
		}
		return pronosticoF; // devuelve lista de pronosticos
	}
}