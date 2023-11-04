package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ManejoRonda 

{
	/**
	 * 
	 */
	public ArrayList<Ronda> crearRondas(ArrayList<Partido> partidoFinal)
	{
		Map<Integer, Ronda> rondaHash =new HashMap<>();
		//ArrayList<Ronda> rondaF= new ArrayList<Ronda>();
		
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
		//rondaF = (ArrayList<Ronda>) rondas.values();
		ArrayList<Ronda> rondaFinal = new ArrayList<>(rondaHash.values());
		
		return rondaFinal;
		
	}
	
	public int puntos(ArrayList<Ronda> listaRondas, ArrayList<Pronostico> listaPronosticos, String nombreParticipante) {
		int puntosTotales = 0;
		for (Ronda rondaIndividual : listaRondas) {
			puntosTotales += rondaIndividual.puntos(listaPronosticos, nombreParticipante);
		}
		return puntosTotales;
	}
	
}
