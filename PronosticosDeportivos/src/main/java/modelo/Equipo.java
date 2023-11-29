package modelo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Equipo 
{
	/*
	 *  Nombre, Descripcion
	 */
	private String nombre;
	private String descripcion;
	
	// Metodo equals para comparar entre equipos
	public boolean equals(Equipo equipo2) {
		if(this.nombre.equals(equipo2.getNombre())) {
			return true;
		} else {
			return false;
		}
	}
	
}
