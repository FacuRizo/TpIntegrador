package modelo;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
public class Ronda 
{

	private int nro;
	private ArrayList<Partido> listaPartidos;
	
	public int puntos (ArrayList<Pronostico> listaPronostico, String nomParticipante)
	{
		int puntoFinal=0;
		
		for (Pronostico pronosticoIndividual : listaPronostico) 
		{
			
			for (Partido partidoIndividual : listaPartidos) 
			{
				if (pronosticoIndividual.getPartido().equals(partidoIndividual) && pronosticoIndividual.getParticipante().equals(nomParticipante)) 
				{
					ResultadoEnum res=partidoIndividual.resultado(pronosticoIndividual.getEquipo());
					puntoFinal+=pronosticoIndividual.puntos(res);
					
				}
			}
			
		}
		return puntoFinal;
	}
	// Esto aunque funciona probablemente no deberia estar aca
	public int puntosInd (ArrayList<Pronostico> listoPronostico , Partido partido)
	{
		int puntoFinal=0;
		for (Pronostico pronostico : listoPronostico) 
		{			
				if (pronostico.getPartido().equals(partido)) 
				{
					ResultadoEnum resultado=partido.resultado(pronostico.getEquipo());
					puntoFinal=pronostico.puntos(resultado);
					
				}	
			
		}
		return  puntoFinal;
	}

}

	