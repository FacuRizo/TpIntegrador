package modelo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Pronostico 
{
	private Partido partido;
	private Equipo equipo;
	private ResultadoEnum resultado;
	
}
