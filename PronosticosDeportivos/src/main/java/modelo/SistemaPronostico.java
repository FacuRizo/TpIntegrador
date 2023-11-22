package modelo;

import java.util.ArrayList;
import java.util.List;



public class SistemaPronostico 

{
	private ArrayList<Partido> partidosFinal=new ArrayList<Partido>(); 
	public ArrayList<Pronostico> pronosticoFinal=new ArrayList<Pronostico>(); 
	private ArrayList<Ronda> rondaFinal=new ArrayList<Ronda>(); 		
	public ArrayList<Ronda> rondaOrdenada= new ArrayList<Ronda>();	
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
		rondaOrdenada();		
		interfaz.menu(rondaOrdenada, partidosFinal, pronosticoFinal, rondaFinal);
	}
	
/*	public void sistemaInicio (String[] args, int eleccion) 
	{
		try 
		{	
			
			Scanner scanner = new Scanner(System.in);
			
			eleccionLectura(scanner, args[0], args[1]);
			lecturaPuntaje(scanner);
			
			scanner.close();
			
			rondaOrdenada();		
			interfaz.menu(rondaOrdenada, partidosFinal, pronosticoFinal, rondaFinal);

		}
		catch (NoSuchElementException e)
		{
			System.err.println("Se esperaban 2 argumentos");
			System.err.println(e);
		}
		
	}
	*/
	
	private void lectorCSV(String[] args)	
	{
		String archivoPartido= args[0];
		String archivoPronostico= args[1];
		inicializarPartido(archivoPartido);
		inicializarPronostico(archivoPronostico);
	}
	
	private void lectorSQL() {
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
	
	private void rondaOrdenada()
	{
		rondaOrdenada = GestorCompetencia.crearRondas(partidosFinal);
	}

	
	/*
	private void eleccionLectura(Scanner scan, String arg1, String arg2) {
		System.out.println("Leer archivos por: 1. CSV || 2. SQL");
		int eleccion = scan.nextInt();
		
		if(eleccion == 1) {
			lectorCSV(arg1, arg2);  // LEER CON CSV
		} else if(eleccion == 2){
			lectorSQL();  // LEER CON SQL
		} else {
			System.out.println("No se pudo leer correctamente ninguna opcion!");
		}

	}

	private void lecturaPuntaje(Scanner scan) {
		System.out.println(" ");
		
		System.out.println("Ingrese la cantidad de puntos por acierto:");
		int puntaje = scan.nextInt();
		
		Puntaje.setPuntaje(puntaje);
	}
*/

}
