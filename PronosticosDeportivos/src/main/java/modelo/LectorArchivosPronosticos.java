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
	
	@SuppressWarnings({ "unchecked", "rawtypes", "resource" })
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

			  	
			    for (ArchivoPronostico pronostico : listPronostico) 
			    {
		            try 
		            {
		                // Check if the number of columns in the current row is not equal to 6
		                if (contarColumnas(pronostico) != 6) 
		                {
		                    throw new ColumnasIncorrectasException("EL CSV no tiene 6 columnas");
		                }
		            } 	
		            catch (ColumnasIncorrectasException e) 
		            {
		            	System.err.println(e.getMessage());
		            }
		            
		                

			    } 
		    }
		  	catch (IOException e) 
		    {
		        e.printStackTrace();
		    } 

	       
		  this.LineasArchivoPronostico=listPronostico;
	        
	}
	
	public  ArrayList<Pronostico> agregarObjPronostico(List<ArchivoPronostico> Listapronosticos)
	{
		ArrayList<Pronostico> pronosticoFinal=new ArrayList<Pronostico>(); 
		
		for (ArchivoPronostico pronosticoIndividual: Listapronosticos)
		{
			// obtener string true or false  de los sig 3 valores y convertirlos a  boolean
			try 
			{
				
				boolean gana=parseValorBoolean(pronosticoIndividual.getGana1());
				boolean gana2=parseValorBoolean(pronosticoIndividual.getGana2());
				boolean empata=parseValorBoolean(pronosticoIndividual.getEmpata());
				
				
				// inicializar equipo, partido y pronostico
				
				Equipo equipo1 = new Equipo();
				
				Equipo equipo2 = new Equipo();
				
				Partido partido=new Partido();	
				
				Pronostico pronostico= new Pronostico();
				
			//	Boolean.parseBoolean(pronostico.getEmpata());
				
				//del archivo de pronosticos saco el nombre del equipo y lo agrego al obj equipo correspondiente
				equipo1.setNombre(pronosticoIndividual.getEquipo1());
				partido.setEquipo1(equipo1);
				
				equipo2.setNombre(pronosticoIndividual.getEquipo2());
				partido.setEquipo2(equipo2);
				
				
				//settear partido
				pronostico.setPartido(partido);
				pronostico.setParticipante(pronosticoIndividual.getParticipante());
			//	ResultadoEnum resultado = part.resultado(equipo1);
						
				
				if (gana) // si gana1 es true entonces el equipo seleccinado por la persona es el uno y el resultado es Ganador
				{
					pronostico.setEquipo(equipo1);
					pronostico.setResultado(ResultadoEnum.Ganador);
					
				}
				else if (empata) //si empata es true entonces el equipo seleccinado por la persona no importa y el resultado es empate
				{
					pronostico.setEquipo(equipo1);
					//pron.setEquipo(equipo2);
					pronostico.setResultado(ResultadoEnum.Empate);
				}
				else if (gana2) //
				{
					pronostico.setEquipo(equipo2);
					pronostico.setResultado(ResultadoEnum.Ganador);
				}
				pronosticoFinal.add(pronostico);	
			}		
			
			catch (NullPointerException e) 
			{
				System.err.println("Uno de los argumentos es nulo. \n"+ e.getMessage());
			}
			catch (NoBooleanException e) 
			{
			    System.err.println("Uno de los argumentos no son booleanos " + e.getMessage());
			}
		}
		return pronosticoFinal; // devuelve lista de pronosticos
	}
	
	private static boolean parseValorBoolean(String booleano) throws NoBooleanException 
	{
	    if (!booleano.equalsIgnoreCase("true") && !booleano.equalsIgnoreCase("false"))
	    {
	        throw new NoBooleanException("Invalid boolean value: " + booleano);
	    }
	    return Boolean.parseBoolean(booleano);
	}
	
	private static int contarColumnas(ArchivoPronostico pronostico)
	{
		int contador=0;
		 if (pronostico.getParticipante() != null) contador++;
		    if (pronostico.getEquipo1() != null) contador++;
		    if (pronostico.getGana1() != null) contador++;
		    if (pronostico.getEmpata() != null) contador++;
		    if (pronostico.getGana2() != null) contador++;
		    if (pronostico.getEquipo2() != null) contador++;

		    return contador;
	}
	
}