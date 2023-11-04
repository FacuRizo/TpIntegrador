package modelo;


import java.util.ArrayList;

public class Interfaz 

{
	 
	 
	   public void menu(ArrayList<Partido> part , ArrayList<Pronostico> pron,ArrayList<Ronda> ron )
	   {
		    ManejoRonda r= new ManejoRonda();
		    
		    this.menuPartidos(part);
		    
		    System.out.println("");
		    System.out.println("---------");
		    System.out.println("");
		    this.MenuPronostico(pron);
		    System.out.println("");
		    System.out.println("---------");
		    System.out.println("");
		    
		    this.menuRondas(r.crearRondas(part), pron);
	   }
	   
	   public void menuPartidos(ArrayList<Partido> part)
	   {
		    
	        System.out.printf("%-15s%-8s%-8s%-15s\n", "Equipo 1", "Goles 1", "Goles 2", "Equipo 2");
	        
	        for (Partido partido : part)
	        {
	            String equipo1 = partido.getEquipo1().getNombre();
	            int goles1 = partido.getGolesEquipo1();
	            int goles2 = partido.getGolesEquipo2();
	            String equipo2 =  partido.getEquipo2().getNombre();


	            System.out.printf("%-15s%-8d%-8d%-15s\n", equipo1, goles1, goles2, equipo2);
	        }
	   }
	   
	   public void MenuPronostico (ArrayList<Pronostico> pronos)
	   {
		   System.out.printf("%-35s%-27s%-27s%-27s\n", "Partido", "Equipo Seleccionado", "Resultado", "Participante");

	        for (Pronostico pronostico : pronos)
	        {
	            String part1 = pronostico.getPartido().getEquipo1().getNombre();
	            String part2 = pronostico.getPartido().getEquipo2().getNombre();
	            String eq = pronostico.getEquipo().getNombre();
	            String persona =pronostico.getParticipante();
	            ResultadoEnum res =pronostico.getResultado();           
	            


	            System.out.printf("%-35s%-27s%-27s%-27s\n", part1+ " vs " +part2 , eq, res , persona);
	        }
	   }
	   
	   public void menuRondas(ArrayList<Ronda> ron, ArrayList<Pronostico> pronos)
	   {
		   System.out.printf("%-35s%-27s\n", "Partido", "Numero");
		   
		   for (Ronda ronda : ron) 
		   {
			 
			   for (Partido partido : ronda.getPartidos()) 
			   {
				   String part1= partido.getEquipo1().getNombre();
				   String part2= partido.getEquipo2().getNombre();
				   
				   String part=part1 + " vs "+ part2;
			   
			   int nro=(ronda.getNro());
			   int pto=ronda.puntosInd(pronos, partido);
			   System.out.printf("%-35s%-27s\n", part, nro);
			   }
			  // int ptoTotal=ronda.puntos(pronos);
			  // System.out.println("Total :"+ Integer.toString(ptoTotal) );
		   }
		}		   
			
	  // no lee total correctamente

		   
}
	   
 
	   
	   

