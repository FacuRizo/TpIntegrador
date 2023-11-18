package test;

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

		private ArrayList<Partido> partidosFinal=new ArrayList<Partido>(); 
		private ArrayList<Pronostico> pronosticoFinal=new ArrayList<Pronostico>(); 
	//	private ArrayList<Ronda> rondaFinal=new ArrayList<Ronda>(); 		
		private ArrayList<Ronda> rondaOrdenada= new ArrayList<Ronda>();	
		private Map<String, ArrayList<Pronostico> > pronosticoHash =new HashMap<>();
	//	private Interfaz interfaz= new Interfaz();
		

	    @Test
	    public void testPuntosEnDosRondasConsecutivas()
	    
	    {	    	   
	    /*	String archivoPartido = getDireccionResource("resultadosTest.csv");
	    	String archivoPronostico = getDireccionResource("pronosticosTest.csv");*/
	    	String archivoPartido = "D:/Archivos Personales/Documents/GitHub/TpIntegrador/PronosticosDeportivos/src/test/resources/resultadosTest.csv";
	    	String archivoPronostico = "D:/Archivos Personales/Documents/GitHub/TpIntegrador/PronosticosDeportivos/src/test/resources/pronosticosTest.csv";

	    	String[] archivos = new String[]{archivoPartido, archivoPronostico};
	        SistemaPronostico sistema = new SistemaPronostico();
	        sistema.sistemaInicio(archivos);
	        //creo q se rompe aca
	        rondaOrdenada=GestorCompetencia.crearRondas(partidosFinal);
	        pronosticoHash=GestorCompetencia.listaPronosticoHash(pronosticoFinal);		
	        
			Map<String, List <Integer>> puntosPorParticipante = new HashMap<>();
			
	        for (String nombre : pronosticoHash.keySet()) {
	            List<Integer> puntosPorRonda = new ArrayList<>();

	            for (Ronda rondaIndividual : rondaOrdenada) {
	                int puntosParticipante = rondaIndividual.puntos(pronosticoHash.get(nombre), nombre);
	                puntosPorRonda.add(puntosParticipante);
	            }

	            puntosPorParticipante.put(nombre, puntosPorRonda);
	        }
	        System.out.println("pronosticoHash: " + pronosticoHash);
	        System.out.println("puntosPorParticipante: " + puntosPorParticipante);

	        String nombreParticipante = "Mariana";
	        List<Integer> valorEsperado = Arrays.asList(12);
	        List<Integer> valorReal = puntosPorParticipante.get(nombreParticipante);

	        assertEquals(valorEsperado, valorReal);
	    }
	    
	    

	    private String getDireccionResource(String resourceName) 
	    {
	    	ClassLoader classLoader = getClass().getClassLoader();
	    	File file = new File(classLoader.getResource(resourceName).getFile());
	    	return file.getAbsolutePath();
	    }
	    
	    
/*


	        int puntosRound2 = gestor.calcularPuntosEnUnaRonda(rondaOrdenadaRound2, pronosticos, "NombreParticipante");

	        // Assert that the points for two consecutive rounds are as expected
	        assertEquals(expectedPuntosRound1, puntosRound1, "Points in round 1 are not as expected");
	        assertEquals(expectedPuntosRound2, puntosRound2, "Points in round 2 are not as expected");
	    }*/



/*	@Before
	 public static void inicioTest() 
	{
		
		String[] args = new String[2];
		args[0]="TpIntegrador\\PronosticosDeportivos\\src\\test\\resources\\resultadosTest.csv";
		args[1]="TpIntegrador\\PronosticosDeportivos\\src\\test\\resources\\pronosticosTest.csv";
		SistemaPronostico sistema = new SistemaPronostico();
        sistema.sistemaInicio(args);
	}
	
/*        	private void sistemaInicio (String[] args) 
        	{
        		try 
        		{
        			inicializarPartido(args[0]);
        			iniciarlizarPronostico(args[1]);
        			rondaOrdenada();		
        			

        		}
        		catch (NoSuchElementException e)
        		{
        			System.err.println("Se esperaban 2 argumentos");
        		}
        		
        	}
        	
        	private  void inicializarPartido(String archivoPartido)
        	{
        		LectorArchivosResultado lectorResultado =new LectorArchivosResultado(archivoPartido);
        		lectorResultado.parserArchivo();
        		List<ArchivoResultado> partidos = lectorResultado.LineasArchivoResultado;			
        		partidosFinal=lectorResultado.agregarObjPartido(partidos);
        	}
        	
        	private void iniciarlizarPronostico(String archivoPronostico)
        	{
        		LectorArchivosPronosticos lectorPronostico=new LectorArchivosPronosticos(archivoPronostico);
        		lectorPronostico.parserArchivo();
        		List<ArchivoPronostico> pronosticos = lectorPronostico.LineasArchivoPronostico;
        		pronosticoFinal=lectorPronostico.agregarObjPronostico(pronosticos);
        	}
        	
        	private void rondaOrdenada()
        	{
        		rondaOrdenada=GestorCompetencia.crearRondas(partidosFinal);
        	}


        
    
	*/

	


}
