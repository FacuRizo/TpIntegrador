package modelo;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Fase 

{
	private FaseEnum nombreFase;
	private ArrayList<Ronda> listaRonda;
	private int puntos;
}
