package modelo;

import java.util.ArrayList;

import java.util.List;
import java.util.NoSuchElementException;

public class Inicio 
{
	public static void main(String[] args) 
	{
		
		ArrayList<Partido> partidosF=new ArrayList<Partido>(); 
		ArrayList<Pronostico> pronosticoF=new ArrayList<Pronostico>(); 
		ArrayList<Ronda> rondaF=new ArrayList<Ronda>(); 
		Interfaz menu= new Interfaz();
		try
		{
			
			LectorArchivosResultado lectorResultado =new LectorArchivosResultado(args[0]);
			lectorResultado.parserArchivo();
			List<ArchivoResultado> partidos = lectorResultado.LineasArchivoResultado;			
			partidosF=lectorResultado.agregarObjPartido(partidos);
			
			// agregar a ronda
			Ronda ronda1=new Ronda();
			ronda1.setPartidos(partidosF);
			ronda1.setNro("1");
			rondaF.add(ronda1);
			
			LectorArchivosPronosticos lectorPronostico=new LectorArchivosPronosticos(args[1]);
			lectorPronostico.parserArchivo();
			List<ArchivoPronostico> pronosticos = lectorPronostico.LineasArchivoPronostico;
			pronosticoF=lectorPronostico.agregarObjPronostico(pronosticos);
			
			//System.out.println(ronda1.puntos(pronosticoF));
			
			//menu.menu(partidosF, pronosticoF);
			menu.menu(partidosF, pronosticoF,rondaF);

		}
		catch (NoSuchElementException e)
		{
			System.err.println("Se esperaban 2 argumentos");
		}
	}
	
	
}
