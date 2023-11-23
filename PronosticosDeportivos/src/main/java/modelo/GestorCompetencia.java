package modelo;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;

public class GestorCompetencia 

{

	public static ArrayList<Fase> crearFases (ArrayList<Ronda> rondaFinal)
	{
			Map<FaseEnum, Fase> faseHash =new HashMap<>();
		
		
			for (Ronda rondaIndividual : rondaFinal) 
			{
				   FaseEnum nombreFase=rondaIndividual.getNombreFase();				
					
				   Fase fase=faseHash.get(nombreFase);
					
					if (fase==null)
					{
						fase = new Fase();
						fase.setNombreFase(nombreFase);
						fase.setListaRonda(new ArrayList<>());
				
						faseHash.put(nombreFase, fase);
					}
					fase.getListaRonda().add(rondaIndividual);
			}
	
		
			ArrayList<Fase> faseFinal = new ArrayList<>(faseHash.values());
			
			return faseFinal;
			
	}
	
	public static  ArrayList<Ronda> crearRondas(ArrayList<Partido> partidoFinal)
	{
		Map<Integer, Ronda> rondaHash =new HashMap<>();
	
		
		for (Partido partidoIndividual : partidoFinal) 
		{
				int nroRonda =partidoIndividual.getNroRonda();
				
				
				Ronda ronda=rondaHash.get(nroRonda);
				
				if (ronda==null)
				{
					ronda = new Ronda();
					ronda.setNro(nroRonda);
					ronda.setListaPartidos(new ArrayList<>());
					ronda.setNombreFase(seleccionarFase(partidoIndividual));
					rondaHash.put(nroRonda, ronda);
				}
				ronda.getListaPartidos().add(partidoIndividual);
		}
	
		ArrayList<Ronda> rondaFinal = new ArrayList<>(rondaHash.values());
		
		return rondaFinal;
		
	}
	
	private static FaseEnum seleccionarFase(Partido partidoIndividual)
	{
		FaseEnum fase;
		if (partidoIndividual.getNroRonda()==1)
		{
			fase=FaseEnum.Eliminatorias;
		}
		else if (partidoIndividual.getNroRonda()==2)
		{
			fase=FaseEnum.Grupos;
		}
		else
		{
			fase=FaseEnum.Finales;
		}
		return fase;
			
	}
	// Calculo del Puntaje sin HashMap
	
	/*
	public int puntos1(ArrayList<Ronda> listaRondas, ArrayList<Pronostico> listaPronosticos, String nombreParticipante) {
		int puntosTotales = 0;
		for (Ronda rondaIndividual : listaRondas) {
			puntosTotales += rondaIndividual.puntos(listaPronosticos, nombreParticipante);
		}
		return puntosTotales;
	}
	*/
	
	// usa lista ordenada de rondas
	public static Map<String, ArrayList<ArrayList<Integer>>> puntosPartyAcertadas (Map<String, ArrayList<Pronostico>> pronosticoHash, ArrayList<Ronda> listaRonda)
	{
		Map<String, ArrayList<ArrayList<Integer>>> puntosPorParticipante = new HashMap<>();
		 int nroRonda=0;
		    for (String nombre : pronosticoHash.keySet()) 
		    {
		    	int puntosParticipante = 0;
		        int cantDeAcertadas=0;
		        
		        ArrayList<ArrayList<Integer>> puntosPorRonda = new ArrayList<>();

		        for (Ronda rondaIndividual : listaRonda) 
		        {
		        	ArrayList<Integer> puntosPorRondaIndividual = new ArrayList<>();  
		        	
		            puntosParticipante += rondaIndividual.puntos(pronosticoHash.get(nombre), nombre);
		            cantDeAcertadas+=rondaIndividual.aciertos(pronosticoHash.get(nombre), nombre);
		            nroRonda =rondaIndividual.getNro();
		            puntajeExtraRonda(puntosParticipante, cantDeAcertadas, rondaIndividual);
		            
		            puntosPorRondaIndividual.add(puntosParticipante);
		            puntosPorRondaIndividual.add(cantDeAcertadas);
		            puntosPorRondaIndividual.add(nroRonda);
		            puntosPorRonda.add(puntosPorRondaIndividual);
		            
		        }
		      /*  puntosPorRonda.add(puntosParticipante);
		        puntosPorRonda.add(cantDeAcertadas);
		        puntosPorRonda.add(nroRonda);*/
		      

		        puntosPorParticipante.put(nombre, puntosPorRonda);
		    }

		    return puntosPorParticipante;	
	
	}
	
	private static int puntajeExtraRonda (int puntosParticipante, int cantDeAcertadas , Ronda rondaIndividual)
	{
		int puntosExtra=3;
		if (cantDeAcertadas==rondaIndividual.getListaPartidos().size())
		{
			puntosParticipante=puntosParticipante+puntosExtra;
		}
		return puntosParticipante;
		
	}

	public static Map<String, ArrayList<Pronostico>> listaPronosticoHash (ArrayList<Pronostico> partidoFinal)
	{
		Map<String, ArrayList<Pronostico> > pronosticoHash =new HashMap<>();
		for (Pronostico pronosticoIndividual : partidoFinal) 
		{
			String nombre= pronosticoIndividual.getParticipante();
			if (pronosticoHash.containsKey(nombre)) 
			{
				pronosticoHash.get(nombre).add(pronosticoIndividual);
			}
			else
			{
				ArrayList<Pronostico> pronosticolista = new ArrayList<Pronostico>();
				pronosticolista.add(pronosticoIndividual);
				pronosticoHash.put(nombre, pronosticolista);
			}
		
		}
		return pronosticoHash;
		
	}
	
	
	
}
