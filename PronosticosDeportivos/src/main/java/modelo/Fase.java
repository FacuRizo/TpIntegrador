package modelo;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Fase 
{
	/*
	 * nombre Fase , Lista Rondas
	 */
	private FaseEnum nombreFase;
	private ArrayList<Ronda> listaRonda;
	/*
	 *  Devuelve true si se acertaron todas las rondas dentro de una fase 
	 */
	public boolean aciertosFaseBool(ArrayList<Pronostico> listaPronostico, String nomParticipante)
    {
        for (Ronda rondaIndividual : listaRonda) {
            if (!rondaIndividual.aciertosBool(listaPronostico, nomParticipante))
            {
                return false; 
            }
        }
        return true;
    }
}
