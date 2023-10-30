package modelo;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
public class Ronda 
{

	private String nro;
	private ArrayList<Partido> partidos;
	
	
	
	public int puntos (ArrayList<Pronostico> prono)
	{
		int punto=0;
		
		for (Pronostico pronostico : prono) 
		{
			
			for (Partido partido2 : partidos) 
			{
				if (pronostico.getPartido().equals(partido2)) 
				{
					ResultadoEnum res=partido2.resultado(pronostico.getEquipo());
					punto+=pronostico.puntos(res);
					
				}
			}
			
		}
		return punto;
	}
	
	public int puntosInd (ArrayList<Pronostico> prono , Partido partido)
	{
		int punto=0;
		for (Pronostico pronostico : prono) 
		{			
				if (pronostico.getPartido().equals(partido)) 
				{
					ResultadoEnum res=partido.resultado(pronostico.getEquipo());
					punto=pronostico.puntos(res);
					
				}	
			
		}
		return  punto;
	}
	

	
}
