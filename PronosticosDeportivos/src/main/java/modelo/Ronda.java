package modelo;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
public class Ronda 
{
	/*
	 *  nro Ronda, ListaPartidos , nombreFase
	 */

	private int nro;
	private ArrayList<Partido> listaPartidos;
	private FaseEnum nombreFase;
	
	
	/*
	 *  Permite calcular los puntos  a partir de una lista de pronosticos y un nombre
	 */
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
	
	/*
	 *  Calcula la cantidad de aciertos en una lista de pronosticos
	 */
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
	/*
	 *  booleano de los aciertos
	 */
	public boolean aciertosBool(ArrayList<Pronostico> listaPronostico, String nomParticipante)
	{
		int aciertos = aciertos(listaPronostico, nomParticipante);
		return aciertos == listaPartidos.size();
	}

}

	