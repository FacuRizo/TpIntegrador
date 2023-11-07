package modelo;


public class Inicio 
{
	public static void main(String[] args) 
	{
		SistemaPronostico sistema = new SistemaPronostico();
        sistema.sistemaInicio(args[0], args[1]);
	}
}
        
        
		/*ArrayList<Partido> partidosFinal=new ArrayList<Partido>(); 
		ArrayList<Pronostico> pronosticoFinal=new ArrayList<Pronostico>(); 
		ArrayList<Ronda> rondaFinal=new ArrayList<Ronda>(); 		
		ArrayList<Ronda> rondaOrdenada= new ArrayList<Ronda>();
		
		
		Interfaz interfaz= new Interfaz();
		//ManejoRonda manejoRonda= new ManejoRonda();
		
		try
		{
			
			LectorArchivosResultado lectorResultado =new LectorArchivosResultado(args[0]);
			lectorResultado.parserArchivo();
			List<ArchivoResultado> partidos = lectorResultado.LineasArchivoResultado;			
			partidosFinal=lectorResultado.agregarObjPartido(partidos);
			
			LectorArchivosPronosticos lectorPronostico=new LectorArchivosPronosticos(args[1]);
			lectorPronostico.parserArchivo();
			List<ArchivoPronostico> pronosticos = lectorPronostico.LineasArchivoPronostico;
			pronosticoFinal=lectorPronostico.agregarObjPronostico(pronosticos);
			
			rondaOrdenada=ManejoRonda.crearRondas(partidosFinal);
			
			interfaz.menu(rondaOrdenada,partidosFinal, pronosticoFinal,rondaFinal);

		}
		catch (NoSuchElementException e)
		{
			System.err.println("Se esperaban 2 argumentos");
		}*/

