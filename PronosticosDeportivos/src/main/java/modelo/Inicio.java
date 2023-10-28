package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Inicio 
{
	public static void main(String[] args) 
	{
		//ubic archivos D:\Archivos Personales\Documents\GitHub\TpIntegrador\PronosticosDeportivos\src\main\resources
		ArrayList<Partido> partidosF=new ArrayList<Partido>(); 
		ArrayList<Pronostico> pronosticoF=new ArrayList<Pronostico>(); 
		try
		{
			
			
			LectorArchivosResultado lectorResultado =new LectorArchivosResultado(args[0]);
			lectorResultado.parserArchivo();
			List<ArchivoResultado> partidos = lectorResultado.LineasArchivoResultado;			
			partidosF=lectorResultado.agregarObjPartido(partidos);
			Ronda ronda1=new Ronda();
			ronda1.setPartidos(partidosF);
			ronda1.setNro("1");

			// agregar a ronda
			
			
			
			
			LectorArchivosPronosticos lectorPronostico=new LectorArchivosPronosticos(args[1]);
			lectorPronostico.parserArchivo();
			List<ArchivoPronostico> pronosticos = lectorPronostico.LineasArchivoPronostico;
			pronosticoF=lectorPronostico.agregarObjPronostico(pronosticos);
			System.out.println(ronda1.puntos(pronosticoF));
			

		}
		catch (NoSuchElementException e)
		{
			System.err.println("Se esperaban 2 argumentos");
		}
	}
}
	//D:\Archivos Personales\Documents\GitHub\TpIntegrador
	
	/*private static ArrayList<Partido> agregarObjPartido (List<ArchivoResultado> partidos)
	{
		ArrayList<Partido> partidosF=new ArrayList<Partido>(); 
		for (ArchivoResultado partido: partidos)
		{
			Equipo equipo1 = new Equipo();
			Equipo equipo2 = new Equipo();
			Partido part=new Partido();
			
			equipo1.setNombre(partido.getEquipo1());
			equipo2.setNombre(partido.getEquipo2());
			
			part.setEquipo1(equipo1);
			part.setEquipo2(equipo2);
			part.setGolesEquipo1(partido.getCantGoles1());
			part.setGolesEquipo2(partido.getCantGoles2());
			partidosF.add(part);	

		}
		return partidosF;
	}
	
	private static ArrayList<Pronostico> agregarObjPronostico(List<ArchivoPronostico> pronosticos)
	{
		ArrayList<Pronostico> pronosticoF=new ArrayList<Pronostico>(); 
		for (ArchivoPronostico pronostico1: pronosticos)
		{
			boolean gana=Boolean.parseBoolean(pronostico1.getGana1());
			boolean gana2=Boolean.parseBoolean(pronostico1.getGana2());
			boolean empata=Boolean.parseBoolean(pronostico1.getEmpata());
		//	Boolean.parseBoolean(pronostico.getEmpata());
			
			Equipo equipo1 = new Equipo();
			Equipo equipo2 = new Equipo();
			Partido part=new Partido();				
			equipo1.setNombre(pronostico1.getEquipo1());
			equipo2.setNombre(pronostico1.getEquipo2());
			part.setEquipo1(equipo1);
			part.setEquipo2(equipo2);
			Pronostico pron= new Pronostico();
			pron.setPartido(part);
		//	ResultadoEnum resultado = part.resultado(equipo1);
			if (gana)
			{
				pron.setEquipo(equipo1);
				pron.setResultado(ResultadoEnum.Ganador);
				
			}
			else if (empata)
			{
				pron.setEquipo(equipo1);
				pron.setResultado(ResultadoEnum.Empate);
			}
			else if (gana2)
			{
				pron.setEquipo(equipo2);
				pron.setResultado(ResultadoEnum.Ganador);
			}
			pronosticoF.add(pron);	
		}
		return pronosticoF;
	}*/

