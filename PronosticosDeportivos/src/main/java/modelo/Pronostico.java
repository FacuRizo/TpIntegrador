package modelo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Pronostico 
{
	private Partido partido;
	private Equipo equipo;
	private ResultadoEnum resultado;
	//private int puntos;
	
	
	public int puntos(ResultadoEnum resReal)
	{
		if(resReal.equals(resultado))
		{
			return 3;
		}
		else
		{
			return 0;
		}

	}
	
}
