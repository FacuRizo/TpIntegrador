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
	
	
	
	public ResultadoEnum resultado (Equipo aEquipo)
	{
		ResultadoEnum res=null;
		Equipo eq=this.comparar();
		if (eq.getNombre()==aEquipo.getNombre())
		{
			res= ResultadoEnum.Ganador;
		}
		else if (eq.getNombre()!=aEquipo.getNombre())
		{
			res= ResultadoEnum.Perdedor;
		}
		else if (eq.getNombre()==null)
		{
			res= ResultadoEnum.Empate;
		}
		return res;
	}
	
	private Equipo comparar ()
	 // 
	{
		/*try 
		{*/ Equipo eqGanador=null;
			if (this.golesEquipo1>this.golesEquipo2)
			{
				eqGanador= this.equipo1;
			}
			else if (this.golesEquipo1 == this.golesEquipo2)
			{
				eqGanador=null;
			}
			else if (this.golesEquipo1<this.golesEquipo2)
			{
				eqGanador=this.equipo2;
			}
		return eqGanador;
		/*} catch (Exception e) 
		{
			// TODO: Agregar si hay negativos
		}*/
		

		
	}
}
