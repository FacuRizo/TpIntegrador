package modelo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Pronostico 
{
	private Partido partido;
	private Equipo equipo;
	private ResultadoEnum resultado;
	private String participante;
	private int cantPuntos;
	
	/*
	 *  Asignacion de puntos
	 */
	public int puntos(ResultadoEnum resReal)
	{
		if(resReal.equals(resultado))
		{
			return Puntaje.getPuntaje();
		}
		else
		{
			return 0;
		}

	}
	
}
