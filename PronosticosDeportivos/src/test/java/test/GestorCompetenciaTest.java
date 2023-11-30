package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import org.junit.Test;

import modelo.Fase;
import modelo.GestorCompetencia;
import modelo.Pronostico;
import modelo.Puntaje;
import modelo.Ronda;
import modelo.SistemaPronostico;

public class GestorCompetenciaTest 

{
	    @Test
	    public void testPuntosEnDosRondasConsecutivas()
	    
	    {	    	   
	    	String rutaRelativaResultados = "src/test/resources/resultadosTest.csv";
	    	String rutaRelativaPronosticos = "src/test/resources/pronosticosTest.csv";
	    	
	    	// Obtencion de la ruta absoluta de ambos archivos
	    	File archivoResultados = new File(rutaRelativaResultados);
	    	String rutaAbsolutaResultados = archivoResultados.getAbsolutePath();
	    	File archivoPronosticos = new File(rutaRelativaPronosticos);
	    	String rutaAbsolutaPronosticos = archivoPronosticos.getAbsolutePath(); 
	    
	    	// Calculo de los puntos
	    	String[] args = new String[]{rutaAbsolutaResultados, rutaAbsolutaPronosticos};
	        SistemaPronostico sistema = new SistemaPronostico();
	        Puntaje.setPuntaje(3);
	        Puntaje.setPuntajeExtra(3);
	        sistema.sistemaInicio(args, 1, false);


	        ArrayList<Ronda> rondaOrdenada=sistema.getRondaOrdenada();
	        ArrayList<Fase> faseOrdenada=sistema.getFaseOrdenada();
	        ArrayList<Pronostico> pronosticoFinal=sistema.getPronosticoFinal();
	       	Map<String, ArrayList<Pronostico>> pronosticoHash = GestorCompetencia.listaPronosticoHash(pronosticoFinal);
	    	Map<String, ArrayList<ArrayList<Integer>>> puntosPorParticipante =GestorCompetencia.puntosPartyAcertadas(pronosticoHash, rondaOrdenada, faseOrdenada);
	 
	      	int puntos = GestorCompetencia.puntosTotales(puntosPorParticipante, "Mariana");

	       	
	       	// Comparacion
	       	assertEquals(puntos,15);

	    }	  
}
