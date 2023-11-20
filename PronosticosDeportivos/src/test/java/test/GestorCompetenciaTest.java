package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.*;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import modelo.ArchivoPronostico;
import modelo.ArchivoResultado;
import modelo.GestorCompetencia;
import modelo.Interfaz;
import modelo.LectorArchivosPronosticos;
import modelo.LectorArchivosResultado;
import modelo.Partido;
import modelo.Pronostico;
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
	    	String[] archivos = new String[]{rutaAbsolutaResultados, rutaAbsolutaPronosticos};
	        SistemaPronostico sistema = new SistemaPronostico();
	        sistema.sistemaInicio(archivos);

	       	Map<String, ArrayList<Pronostico>> pronosticoHash = GestorCompetencia.listaPronosticoHash(sistema.pronosticoFinal);
	       	Map<String,ArrayList <Integer>> puntosPorParticipante = GestorCompetencia.puntosPartyAcertadas(pronosticoHash, sistema.rondaOrdenada);
	    
	       	List<Integer> puntos = puntosPorParticipante.get("Mariana");
	       	
	       	// Comparacion
	       	assertEquals(puntos.get(0), 12);

	    }	  
}
