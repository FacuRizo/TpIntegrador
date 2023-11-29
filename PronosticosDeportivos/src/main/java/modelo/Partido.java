package modelo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Partido 
{
	/*
	 *  Equipo 1 , Equipo 2, goles Equipo 1, goles Equipo 2, nroRonda, fase
	 */
	private Equipo equipo1;
	private Equipo equipo2;
	private int golesEquipo1;
	private int golesEquipo2;
	private int nroRonda;
	private FaseEnum fase;
	
	public boolean equals(Partido part)
	{
		if(this.equipo1.equals(part.getEquipo1()) && this.equipo2.equals(part.getEquipo2())) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 *  Devuelve el Resultado enum correspondiente del equipo
	 */	
	public ResultadoEnum resultado (Equipo aEquipo)
	{
		ResultadoEnum resultadoFinal=null;
		String equipo = this.comparar();
		
		if(equipo.equals("Empate")) {
			resultadoFinal= ResultadoEnum.Empate;
		} else if(equipo.equals(aEquipo.getNombre())) {
			resultadoFinal= ResultadoEnum.Ganador;
		}else {
			resultadoFinal= ResultadoEnum.Perdedor;
		}
		return resultadoFinal;
	}
	
	/*
	 *  Compara los equipos y selecciona el ganador o "empate" en aso de empate
	 */	
	private String comparar ()
	{
		 String equipoGanador = "";
		
			if (this.golesEquipo1>this.golesEquipo2)
			{
				equipoGanador= this.equipo1.getNombre();
			}
			else if (this.golesEquipo1 == this.golesEquipo2)
			{
				equipoGanador="Empate";
			}
			else if (this.golesEquipo1<this.golesEquipo2)
			{
				equipoGanador=this.equipo2.getNombre();
			}
		return equipoGanador;
	}
}