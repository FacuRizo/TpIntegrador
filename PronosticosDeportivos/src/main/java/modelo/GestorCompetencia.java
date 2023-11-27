package modelo;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;

public class GestorCompetencia {

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
				int nroRonda = partidoIndividual.getNroRonda();
				Ronda ronda = rondaHash.get(nroRonda);
				
				if (ronda == null)
				{
					ronda = new Ronda();
					ronda.setNro(nroRonda);
					ronda.setListaPartidos(new ArrayList<>());
					ronda.setNombreFase(partidoIndividual.getFase());
					rondaHash.put(nroRonda, ronda);
				}
				ronda.getListaPartidos().add(partidoIndividual);
		}
	
		ArrayList<Ronda> rondaFinal = new ArrayList<>(rondaHash.values());
		return rondaFinal;
	}

	public static Map<String, ArrayList<ArrayList<Integer>>> puntosPartyAcertadas (Map<String, ArrayList<Pronostico>> pronosticoHash, ArrayList<Ronda> listaRonda, ArrayList<Fase> faseFinal)
	{
		Map<String, ArrayList<ArrayList<Integer>>> puntosPorParticipante = new HashMap<>();
		 int nroRonda = 0;
		    for (String nombre : pronosticoHash.keySet()) 
		    {
		    	
		        int puntosParticipante = 0;
                int cantDeAcertadas = 0;
                int puntosExtras = 0;
                int puntosExtrasFase = 0;

                ArrayList<ArrayList<Integer>> puntosPorRonda = new ArrayList<>();

                for (Fase fase : faseFinal)
                {
					boolean bandera = false;
					puntosExtrasFase = 0;

                    if (fase.aciertosFaseBool(pronosticoHash.get(nombre), nombre)) 
                    {
                        puntosExtrasFase = Puntaje.getPuntajeExtra(); 
					}

					for (Ronda rondaIndividual : fase.getListaRonda()) 
					{
						puntosParticipante = 0;
						cantDeAcertadas = 0;
						puntosExtras = 0;
							
						ArrayList<Integer> puntosPorRondaIndividual = new ArrayList<>();  
							
						puntosParticipante += rondaIndividual.puntos(pronosticoHash.get(nombre), nombre);
						cantDeAcertadas += rondaIndividual.aciertos(pronosticoHash.get(nombre), nombre);
						nroRonda = rondaIndividual.getNro();
						puntosExtras = puntajeExtraRonda(cantDeAcertadas, rondaIndividual);
							
						puntosPorRondaIndividual.add(nroRonda);
						puntosPorRondaIndividual.add(cantDeAcertadas);
						puntosPorRondaIndividual.add(puntosParticipante);

						if(!bandera){
							puntosPorRondaIndividual.add(puntosExtras + puntosExtrasFase);
							bandera = true;
						}else{
							puntosPorRondaIndividual.add(puntosExtras);
						}

						puntosPorRonda.add(puntosPorRondaIndividual);
					}
					
					puntosPorParticipante.put(nombre, puntosPorRonda);
				} 
		    }
		    return puntosPorParticipante;	
	}
	
	private static int puntajeExtraRonda (int cantDeAcertadas, Ronda rondaIndividual){
		int puntosExtra = Puntaje.getPuntajeExtra();
		if (cantDeAcertadas == rondaIndividual.getListaPartidos().size())
		{
			return puntosExtra;
		}
		return 0;
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

	public static int puntosTotales(Map<String, ArrayList<ArrayList<Integer>>> puntosPorParticipante, String nombreParticipante)
	{
		int puntosTotales = 0;
		// Puntos Por Ronda = [nroRonda, cantDeAcertadas, puntosParticipante, puntosExtras]
		for (ArrayList<Integer> puntosPorRonda : puntosPorParticipante.get(nombreParticipante)) 
		{
			puntosTotales += puntosPorRonda.get(2);
			puntosTotales += puntosPorRonda.get(3);
		}
		return puntosTotales;
	}

	public static String ganador(Map<String, ArrayList<ArrayList<Integer>>> puntosPorParticipante)
	{
		String ganador = "";
		int puntosMax = 0;
		for (String nombre : puntosPorParticipante.keySet()) 
		{
			int puntosTotales = puntosTotales(puntosPorParticipante, nombre);
			if (puntosTotales > puntosMax)
			{
				puntosMax = puntosTotales;
				ganador = nombre;
			}
		}
		return ganador;
	}
}

