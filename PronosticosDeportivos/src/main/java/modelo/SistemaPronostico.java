package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class SistemaPronostico 

{
	private ArrayList<Partido> partidosFinal=new ArrayList<Partido>(); 
	private ArrayList<Pronostico> pronosticoFinal=new ArrayList<Pronostico>(); 
	private ArrayList<Ronda> rondaFinal=new ArrayList<Ronda>(); 		
	private ArrayList<Ronda> rondaOrdenada= new ArrayList<Ronda>();	
	private Interfaz interfaz= new Interfaz();
	
	public void sistemaInicio (String archivoPartido , String archivoPronostico) 
	{
		try
		{
			inicializarPartido(archivoPartido);
			iniciarlizarPronostico(archivoPronostico);
			rondaOrdenada();		
			interfaz.menu(rondaOrdenada,partidosFinal, pronosticoFinal,rondaFinal);

		}
		catch (NoSuchElementException e)
		{
			System.err.println("Se esperaban 2 argumentos");
		}
		
	}
	
	private void inicializarPartido(String archivoPartido)
	{
		LectorArchivosResultado lectorResultado =new LectorArchivosResultado(archivoPartido);
		lectorResultado.parserArchivo();
		List<ArchivoResultado> partidos = lectorResultado.LineasArchivoResultado;			
		partidosFinal=lectorResultado.agregarObjPartido(partidos);
	}
	
	private void iniciarlizarPronostico(String archivoPronostico)
	{
		LectorArchivosPronosticos lectorPronostico=new LectorArchivosPronosticos(archivoPronostico);
		lectorPronostico.parserArchivo();
		List<ArchivoPronostico> pronosticos = lectorPronostico.LineasArchivoPronostico;
		pronosticoFinal=lectorPronostico.agregarObjPronostico(pronosticos);
	}
	
	private void rondaOrdenada()
	{
		rondaOrdenada=ManejoRonda.crearRondas(partidosFinal);
	}


	
}
