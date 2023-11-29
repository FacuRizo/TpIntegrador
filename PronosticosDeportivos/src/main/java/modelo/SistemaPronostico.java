package modelo;

import java.util.ArrayList;
import java.util.List;

public class SistemaPronostico 

{
	public ArrayList<Partido> partidosFinal=new ArrayList<Partido>(); 
	public ArrayList<Pronostico> pronosticoFinal=new ArrayList<Pronostico>(); 
	private ArrayList<Ronda> rondaFinal=new ArrayList<Ronda>(); 		
	public ArrayList<Ronda> rondaOrdenada= new ArrayList<Ronda>();	
	public ArrayList<Fase> faseOrdenada = new ArrayList<Fase>();
	private Interfaz interfaz = new Interfaz();
	
	public void sistemaInicio (String[] args, int eleccion)
	{
		if(eleccion == 1) 
		{
			this.lectorCSV(args);// LEER CON CSV
		}
		else if (eleccion == 2) 
		{
			this.lectorSQL();  // LEER CON SQL
		}
		rondayFasesOrdenada(); // agregar uso de fase
		interfaz.menu(rondaOrdenada, partidosFinal, pronosticoFinal, rondaFinal,faseOrdenada);
	}
	
	private void lectorCSV(String[] args)	
	{
		try
		{
			String archivoPartido= args[0];
			String archivoPronostico= args[1];
			inicializarPartido(archivoPartido);
			inicializarPronostico(archivoPronostico);
		}
		 catch (ArrayIndexOutOfBoundsException e)
		{
			System.err.println("Argumentos insuficientes, Se esperaban 2");
		}
	}
	
	private void lectorSQL() 
	{
		partidosFinal = LectorResultadoSQL.lectura();
		pronosticoFinal = LectorPronosticoSQL.lectura();
	}
	
	private void inicializarPartido(String archivoPartido)
	{
		LectorArchivosResultado lectorResultado =new LectorArchivosResultado(archivoPartido);
		lectorResultado.parserArchivo();
		List<ArchivoResultado> partidos = lectorResultado.LineasArchivoResultado;			
		partidosFinal=lectorResultado.agregarObjPartido(partidos);
	}
	
	private void inicializarPronostico(String archivoPronostico)
	{
		LectorArchivosPronosticos lectorPronostico=new LectorArchivosPronosticos(archivoPronostico);
		lectorPronostico.parserArchivo();
		List<ArchivoPronostico> pronosticos = lectorPronostico.LineasArchivoPronostico;
		pronosticoFinal = lectorPronostico.agregarObjPronostico(pronosticos);
	}
	
	private void rondayFasesOrdenada()
	{
		rondaOrdenada = GestorCompetencia.crearRondas(partidosFinal);
		faseOrdenada = GestorCompetencia.crearFases(rondaOrdenada);
	}
}