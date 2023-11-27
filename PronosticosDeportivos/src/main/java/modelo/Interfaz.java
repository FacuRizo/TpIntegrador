package modelo;


import java.util.ArrayList;

import java.util.Map;

public class Interfaz 

{
	   public void menu(ArrayList<Ronda> rondaOrdenada, ArrayList<Partido> listaPartido , ArrayList<Pronostico> listaPronostico,ArrayList<Ronda> listaRonda, ArrayList<Fase> faseOrdenada )
	   {
  
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
		    System.out.println("---------");
		    System.out.println("");
		    this.menuFases(faseOrdenada);
		    System.out.println("");
		    System.out.println("---------");
		    System.out.println("");
		    this.menuPuntaje(rondaOrdenada, listaPronostico, faseOrdenada);
		    
	   }
	  
	   private void menuFases(ArrayList<Fase> faseOrdenada)
	   {
		   System.out.println("FASES: \n");
		   for (Fase fase : faseOrdenada)
			   
		   {
			 FaseEnum nombre= fase.getNombreFase();
			 for (Ronda ronda : fase.getListaRonda()) 
			 {
				 int numero = ronda.getNro();
				 System.out.println("Fase:"+ nombre + " Ronda "+numero);
			 }
		   }
		
	   }

	public void menuPuntaje(ArrayList<Ronda> rondaOrdenada, ArrayList<Pronostico> listaPronostico, ArrayList<Fase> faseFinal)
	   {
		   Map<String, ArrayList<Pronostico>> pronosticoHash = GestorCompetencia.listaPronosticoHash(listaPronostico);	

		   Map<String, ArrayList<ArrayList<Integer>>>  puntosPorParticipante = GestorCompetencia.puntosPartyAcertadas(pronosticoHash, rondaOrdenada, faseFinal);

		   System.out.println("PUNTAJES TOTALES: \n");
		   
		    for (String nombre : puntosPorParticipante.keySet()) 
		    {
		    	 
		    	ArrayList<ArrayList<Integer>> puntosPorRonda = puntosPorParticipante.get(nombre);
		    	for (ArrayList<Integer> puntosPorRondaIndividual : puntosPorRonda)
		    	{
		    		
		    	 int rondanro=puntosPorRondaIndividual.get(0);
		    	 int cantGanadas =puntosPorRondaIndividual.get(1);
				 int puntosParticipante = puntosPorRondaIndividual.get(2);
				 int puntosExtras = puntosPorRondaIndividual.get(3);
				 
				System.out.println("Participante: " + nombre + " | Ronda: " + rondanro + " | Acertadas: " 
				 + cantGanadas + " | Puntos: " + puntosParticipante + " | Puntos Extra: " + puntosExtras);
		    	}

				System.out.println("Puntos Totales: " + GestorCompetencia.puntosTotales(puntosPorParticipante, nombre));
		    }

			System.out.println("\nGanador: " + GestorCompetencia.ganador(puntosPorParticipante));
	   }
	   
	   public void menuPartidos(ArrayList<Partido> listaPartido)
	   {
		    System.out.println("PARTIDOS: \n");
	        System.out.printf("%-15s%-8s%-8s%-15s%-15s\n", "Equipo 1", "Goles 1", "Goles 2", "Equipo 2", "Fase");
	        
	        for (Partido partidoIndividual : listaPartido)
	        {
	            String equipo1 = partidoIndividual.getEquipo1().getNombre();
	            int goles1 = partidoIndividual.getGolesEquipo1();
	            int goles2 = partidoIndividual.getGolesEquipo2();
	            String equipo2 =  partidoIndividual.getEquipo2().getNombre();
	            FaseEnum fase = partidoIndividual.getFase();


	            System.out.printf("%-15s%-8d%-8d%-15s%-15s\n", equipo1, goles1, goles2, equipo2, fase);
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
	   
 
	   
	   

