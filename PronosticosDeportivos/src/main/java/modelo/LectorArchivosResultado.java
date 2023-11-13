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
	
	@SuppressWarnings({ "unchecked", "rawtypes", "resource" })
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

			    for (ArchivoResultado resultado : listResultado) 
			    {
		            try 
		            {
		                // Check if the number of columns in the current row is not equal to 6
		                if (contarColumnas(resultado) != 5) 
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
		  this.LineasArchivoResultado=listResultado;
	        
	}
	
	public ArrayList<Partido> agregarObjPartido (List<ArchivoResultado> listaPartidos)
	{
		ArrayList<Partido> partidosFinal=new ArrayList<Partido>(); 
		for (ArchivoResultado partidoIndividual: listaPartidos)
		{
			int cantGoles1 = 0;
			int cantGoles2 = 0;
			
			try {
				cantGoles1 = Integer.parseInt(partidoIndividual.getCantGoles1());
				cantGoles2 = Integer.parseInt(partidoIndividual.getCantGoles2());
				
			
			
			
			//boolean gana=Boolean.parseBoolean(pronostico1.getGana1());
			int nroRonda = Integer.parseInt(partidoIndividual.getNroRonda());
			
			//inicializamos
			Equipo equipo1 = new Equipo();
			Equipo equipo2 = new Equipo();
			Partido partido = new Partido();
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
			catch (NumberFormatException e) 
			{
			System.err.println("Error en los goles ingresados, uno o ambos no son numeros enteros. \n" + e.getMessage());
			}
			catch (NullPointerException e) {
				System.err.println("Uno de los argumentos es nulo. \n"+ e.getMessage());
			}
		}
		return partidosFinal; // devolvemos lista de partidos
	}
	
	private  static int contarColumnas(ArchivoResultado resultado)
	{
		int contador=0;
		 if (resultado.getCantGoles1() != null) contador++;
		    if (resultado.getEquipo1() != null) contador++;
		    if (resultado.getCantGoles2() != null) contador++;
		    if (resultado.getEquipo2() != null) contador++;
		    if (resultado.getNroRonda() != null) contador++;

		    return contador;
	}
}

