package modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Interfaz 

{
	 
	 
	   public void menu(ManejoRonda manejoRonda, ArrayList<Ronda> rondaOrdenada, ArrayList<Partido> listaPartido , ArrayList<Pronostico> listaPronostico,ArrayList<Ronda> listaRonda )
	   {
		  //	ManejoRonda manejoRonda= new ManejoRonda();
		  // 	ArrayList<Ronda> rondaOrdenada= new ArrayList<Ronda>();
		   	
		   // rondaOrdenada=manejoRonda.crearRondas(listaPartido);
		    
		    
		    System.out.println("");
		    System.out.println("---------");
		    System.out.println("");
		    this.MenuPronostico(listaPronostico);
		    System.out.println("");
		    System.out.println("---------");
		    System.out.println("");	   
		    this.menuPartidos(listaPartido);
		    System.out.println("");
		    System.out.println("---------");
		    System.out.println("");
		    this.menuRondas(rondaOrdenada, listaPronostico);
		    System.out.println("");
		    /*this.menuPuntaje(manejoRonda,rondaOrdenada, listaPartido, listaPronostico);
		    System.out.println("");
		    System.out.println("---------");
		    System.out.println("");*/
		    /*this.menuTest(manejoRonda, listaPronostico);
		    System.out.println("");
		    System.out.println("---------");
		    System.out.println("");
		    */
		    this.menuPuntaje2(manejoRonda,rondaOrdenada, listaPronostico);
		    
	   }
	   
	   public void menuTest(ManejoRonda manejoRonda,ArrayList<Pronostico> listaPronostico)
	   {
		   Map<String, ArrayList<Pronostico> > pronosticoHash =new HashMap<>();
		    pronosticoHash= manejoRonda.listaPronosticoHash(listaPronostico);
		    for (String i : pronosticoHash.keySet())
		    {
		    	System.out.println("key: " + i + " value: " + pronosticoHash.get(i));
			}
			
	   }
	   
	   // Menu del Puntaje sin HashMap
	   
	   /*
	   public void menuPuntaje(ManejoRonda manejoRonda,ArrayList<Ronda> rondaOrdenada, ArrayList<Partido> listaPartido,ArrayList<Pronostico> listaPronostico)
	   {
		  // ArrayList<Ronda> listaRonda2 = manejoRonda.crearRondas(listaPartido);
		   // Map<String, ArrayList<Pronostico> > pronosticoHash =new HashMap<>();
		   // pronosticoHash= manejoRonda.listaPronosticoHash(listaPronostico);
		    String nomAnterior = "";
		    
		    for (Pronostico pronosticoIndividual : listaPronostico) {
		    	
		    	String nom = "";
		    	nom = pronosticoIndividual.getParticipante();
		    	
		    	if(nomAnterior.equals(nom)) {
		    		continue;
		    	} else {
		    		nomAnterior = nom;
		    		System.out.println("Puntos de " + nom +" : " + manejoRonda.puntos1(rondaOrdenada, listaPronostico, nom));
		    	//	System.out.println(" Hash Puntos de " + nom +" : " + manejoRonda.puntos2(pronosticoHash, rondaOrdenada));
		    	}
		    	
			}
	   }*/
	   
	   public void menuPuntaje2(ManejoRonda manejoRonda,ArrayList<Ronda> rondaOrdenada, ArrayList<Pronostico> listaPronostico)
	   {
		   Map<String, ArrayList<Pronostico>> pronosticoHash = manejoRonda.listaPronosticoHash(listaPronostico);	

		   Map<String, Integer> puntosPorParticipante = manejoRonda.puntos2(pronosticoHash, rondaOrdenada);
		   
		   System.out.println("PUNTAJES TOTALES: \n");
		   
		    for (String nombre : puntosPorParticipante.keySet()) 
		    {
		        int puntosParticipante = puntosPorParticipante.get(nombre);
		        System.out.println(nombre + ": " + puntosParticipante);
		    }

		   
	   }
	   
	   public void menuPartidos(ArrayList<Partido> listaPartido)
	   {
		    System.out.println("PARTIDOS: \n");
	        System.out.printf("%-15s%-8s%-8s%-15s\n", "Equipo 1", "Goles 1", "Goles 2", "Equipo 2");
	        
	        for (Partido partidoIndividual : listaPartido)
	        {
	            String equipo1 = partidoIndividual.getEquipo1().getNombre();
	            int goles1 = partidoIndividual.getGolesEquipo1();
	            int goles2 = partidoIndividual.getGolesEquipo2();
	            String equipo2 =  partidoIndividual.getEquipo2().getNombre();


	            System.out.printf("%-15s%-8d%-8d%-15s\n", equipo1, goles1, goles2, equipo2);
	        }
	   }
	   
	   public void MenuPronostico (ArrayList<Pronostico> listaPronostico)
	   {
		   System.out.println("PRONOSTICOS: \n");
		   System.out.printf("%-35s%-27s%-27s%-27s\n", "Partido", "Equipo Seleccionado", "Resultado", "Participante");

	        for (Pronostico pronosticoIndividual : listaPronostico)
	        {
	            String part1Nombre = pronosticoIndividual.getPartido().getEquipo1().getNombre();
	            String part2Nombre = pronosticoIndividual.getPartido().getEquipo2().getNombre();
	            String equipoNombre = pronosticoIndividual.getEquipo().getNombre();
	            String persona =pronosticoIndividual.getParticipante();
	            ResultadoEnum res =pronosticoIndividual.getResultado();           
	            


	            System.out.printf("%-35s%-27s%-27s%-27s\n", part1Nombre+ " vs " + part2Nombre , equipoNombre, res , persona);
	        }
	   }
	   
	   public void menuRondas(ArrayList<Ronda> listaRonda, ArrayList<Pronostico> listaPronostico)
	   {
		   System.out.println("RONDAS:");
		   // System.out.printf("%-35s\n", "Partido");
		   
		   int cont = 0;
		   
		   for (Ronda rondaIndividual : listaRonda) 
		   {
			   cont++;
			   System.out.println("\n Ronda " + cont + ":");
			   
			   for (Partido partidoIndividual : rondaIndividual.getListaPartidos()) 
			   {
				   String partido1Nombre= partidoIndividual.getEquipo1().getNombre();
				   String part2Nombre= partidoIndividual.getEquipo2().getNombre();
				   
				   String partidoVS= partido1Nombre + " vs "+ part2Nombre;
			   
				   //int nro=(rondaIndividual.getNro());
				   //int pto=rondaIndividual.puntosInd(listaPronostico, partidoIndividual);
				   System.out.printf("%-35s\n", partidoVS);
			   }
			  // int ptoTotal=ronda.puntos(pronos);
			  // System.out.println("Total :"+ Integer.toString(ptoTotal) );
			   System.out.println("---------");
		   }
		}		    
}
	   
 
	   
	   

