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
	 public int aciertos(ArrayList<Pronostico> listaPronostico, String nomParticipante) 
	 {
	        int aciertos = 0;

	        for (Pronostico pronosticoIndividual : listaPronostico) 
	        {
	            for (Partido partidoIndividual : listaPartidos)
	            {
	                if (pronosticoIndividual.getPartido().equals(partidoIndividual) &&
	                        pronosticoIndividual.getParticipante().equals(nomParticipante)) 
	                {
	                    ResultadoEnum res = partidoIndividual.resultado(pronosticoIndividual.getEquipo());
	                    if (pronosticoIndividual.puntos(res) != 0) 
	                    {
	                        aciertos++;
	                    }
	                }
	            }
	        }
	        return aciertos;
	    }

}

	