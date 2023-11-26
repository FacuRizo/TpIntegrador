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

	// usa lista ordenada de rondas
	public static Map<String, ArrayList<ArrayList<Integer>>> puntosPartyAcertadas (Map<String, ArrayList<Pronostico>> pronosticoHash, ArrayList<Ronda> listaRonda)
	{
		Map<String, ArrayList<ArrayList<Integer>>> puntosPorParticipante = new HashMap<>();
		 int nroRonda = 0;
		    for (String nombre : pronosticoHash.keySet()) 
		    {
		    	
		        ArrayList<ArrayList<Integer>> puntosPorRonda = new ArrayList<>();

		        for (Ronda rondaIndividual : listaRonda) 
		        {
		        	int puntosParticipante = 0;
			        int cantDeAcertadas = 0;
		        	int puntosExtras = 0;
			        
		        	ArrayList<Integer> puntosPorRondaIndividual = new ArrayList<>();  
		        	
		            puntosParticipante += rondaIndividual.puntos(pronosticoHash.get(nombre), nombre);
		            cantDeAcertadas += rondaIndividual.aciertos(pronosticoHash.get(nombre), nombre);
		            nroRonda = rondaIndividual.getNro();
		            puntosExtras = puntajeExtraRonda(cantDeAcertadas, rondaIndividual);
		            
		            puntosPorRondaIndividual.add(nroRonda);
		            puntosPorRondaIndividual.add(cantDeAcertadas);
		            puntosPorRondaIndividual.add(puntosParticipante);
		            puntosPorRondaIndividual.add(puntosExtras);
		            puntosPorRonda.add(puntosPorRondaIndividual);
				}
		        
				puntosPorParticipante.put(nombre, puntosPorRonda);
		    }
			System.out.println(puntosPorParticipante);
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

	public static void puntajeExtraFase (Map<String, ArrayList<ArrayList<Integer>>> puntosPorParticipante, ArrayList<Fase> faseFinal){

		/*int puntosExtra = Puntaje.getPuntajeExtra();
		for (Fase faseIndividual : faseFinal) 
		{
			System.out.println(faseIndividual.getNombreFase());
			System.out.println(faseIndividual.getListaRonda());

			for (Ronda ronda : faseIndividual.getListaRonda()) {

				for(String nombre : puntosPorParticipante.keySet()){

					ArrayList<ArrayList<Integer>> puntosPorRonda = puntosPorParticipante.get(nombre);
					for (ArrayList<Integer> puntosPorRondaIndividual : puntosPorRonda) //[1, 4, 12, 3]
					{
						if (puntosPorRondaIndividual.get(0) == ronda.getNro() && puntosPorRondaIndividual.get(3) == 3)
						{
							faseIndividual.setPuntos(Puntaje.getPuntajeExtra());
						}
					}
				}
			}
		}*/
		
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
