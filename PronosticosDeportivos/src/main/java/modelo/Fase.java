package modelo;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Fase {

	private FaseEnum nombreFase;
	private ArrayList<Ronda> listaRonda;

	public boolean aciertosFaseBool(ArrayList<Pronostico> listaPronostico, String nomParticipante)
    {
        for (Ronda rondaIndividual : listaRonda) {
            if (!rondaIndividual.aciertosBool(listaPronostico, nomParticipante)) {
                return false; 
            }
        }
        return true;
    }
}
