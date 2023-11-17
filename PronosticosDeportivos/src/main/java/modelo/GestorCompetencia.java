package modelo;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;

public class GestorCompetencia 

{

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
					rondaHash.put(nroRonda, ronda);
				}
				ronda.getListaPartidos().add(partidoIndividual);
		}
	
		ArrayList<Ronda> rondaFinal = new ArrayList<>(rondaHash.values());
		
		return rondaFinal;
		
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
	
	public static Map<String,ArrayList <Integer>> puntosPartyAcertadas (Map<String, ArrayList<Pronostico>> pronosticoHash, ArrayList<Ronda> listaRonda)
	{
		 Map<String, ArrayList <Integer>> puntosPorParticipante = new HashMap<>();
		 	
		    for (String nombre : pronosticoHash.keySet()) 
		    {
		    	int puntosParticipante = 0;
		        int cantDeAcertadas=0;
		        
		        ArrayList<Integer> puntosPorRonda = new ArrayList<>();

		        for (Ronda rondaIndividual : listaRonda) 
		        {
		        	  
		            puntosParticipante += rondaIndividual.puntos(pronosticoHash.get(nombre), nombre);
		            cantDeAcertadas+=rondaIndividual.aciertos(pronosticoHash.get(nombre), nombre);
		        }
		        puntosPorRonda.add(puntosParticipante);
		        puntosPorRonda.add(cantDeAcertadas);

		        puntosPorParticipante.put(nombre, puntosPorRonda);
		    }

		    return puntosPorParticipante;	
	
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