package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ManejoRonda 

{
	/**
	 * 
	 */
	public ArrayList<Ronda> crearRondas(ArrayList<Partido> partidoF)
	{
		Map<Integer, Ronda> rondas =new HashMap<>();
		//ArrayList<Ronda> rondaF= new ArrayList<Ronda>();
		
		for (Partido partido : partidoF) 
		{
				int nroRonda =partido.getNroRonda();
				
				Ronda ronda=rondas.get(nroRonda);
				
				if (ronda==null)
				{
					ronda = new Ronda();
					ronda.setNro(nroRonda);
					ronda.setPartidos(new ArrayList<>());
					rondas.put(nroRonda, ronda);
				}
				ronda.getPartidos().add(partido);
		}
		//rondaF = (ArrayList<Ronda>) rondas.values();
		ArrayList<Ronda> rondaF = new ArrayList<>(rondas.values());
		
		return rondaF;
		
	}
	
	public int puntos(ArrayList<Ronda> rondas, ArrayList<Pronostico> pronosticos, String nomParticipante) {
		int puntosTotales = 0;
		for (Ronda ronda : rondas) {
			puntosTotales += ronda.puntos(pronosticos, nomParticipante);
		}
		return puntosTotales;
	}
	
}
