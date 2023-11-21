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

	public int puntos(ResultadoEnum resReal)
	{
		if(resReal.equals(resultado))
		{
			//System.out.println("Le pegaste");
			return Puntaje.getPuntaje();
		}
		else
		{
			//System.out.println("No le pegaste");
			return 0;
		}

	}
	
}
