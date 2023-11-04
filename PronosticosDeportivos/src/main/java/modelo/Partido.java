package modelo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Partido 
{
	private Equipo equipo1;
	private Equipo equipo2;
	private int golesEquipo1;
	private int golesEquipo2;
	private int nroRonda;

	public boolean equals(Partido part) {
		if(this.equipo1.equals(part.getEquipo1()) && this.equipo2.equals(part.getEquipo2())) {
			return true;
		} else {
			return false;
		}
	}
	
	public ResultadoEnum resultado (Equipo aEquipo)
	{
		ResultadoEnum res=null;
		String eq = this.comparar();
		
		if(eq.equals("Empate")) {
			res= ResultadoEnum.Empate;
		} else if(eq.equals(aEquipo.getNombre())) {
			res= ResultadoEnum.Ganador;
		}else {
			res= ResultadoEnum.Perdedor;
		}
		//System.out.println(res);
		return res;
	}
	
	private String comparar ()
	
	{
		
		 String eqGanador = "";
		
			if (this.golesEquipo1>this.golesEquipo2)
			{
				eqGanador= this.equipo1.getNombre();
			}
			else if (this.golesEquipo1 == this.golesEquipo2)
			{
				eqGanador="Empate";
			}
			else if (this.golesEquipo1<this.golesEquipo2)
			{
				eqGanador=this.equipo2.getNombre();
			}
		return eqGanador;
		
		
	}
}
