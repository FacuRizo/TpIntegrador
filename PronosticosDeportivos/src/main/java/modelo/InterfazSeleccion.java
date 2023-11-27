package modelo;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class InterfazSeleccion
{
	private int puntaje;
	private int puntajeExtra;
	private int eleccion;
	private SistemaPronostico sistemaPronostico =new SistemaPronostico();
	
	public void menuSeleccion(String[] args)
	{
		try 
		{	
		Scanner scanner = new Scanner(System.in);
		
		this.lecturaPuntaje(scanner);
		this.eleccionLectura(scanner, args);
		
		scanner.close();
		sistemaPronostico.sistemaInicio(args, eleccion);
		}
		catch (NoSuchElementException e)
		{
			System.err.println("Se esperaban 2 argumentos");
			System.err.println(e);
		}
	}

	private void lecturaPuntaje(Scanner scan) 
	{
		System.out.println(" ");
		
		System.out.println("Ingrese la cantidad de puntos por acierto: ");
		puntaje = scan.nextInt();
		
		Puntaje.setPuntaje(puntaje);

		System.out.println("Ingrese la cantidad de puntos extra: ");
		puntajeExtra = scan.nextInt();

		Puntaje.setPuntajeExtra(puntajeExtra);
	}
	
	private int eleccionLectura(Scanner scan, String[] args) 
	{
		System.out.println("Leer archivos por: 1. CSV || 2. SQL");
		
		eleccion = scan.nextInt();
		
		 if (eleccion!=1 && eleccion!=2)
		 {
			 throw new IllegalArgumentException("Opción inválida. Por favor, seleccione 1 para CSV o 2 para SQL.");
		 }
		 
		 return eleccion;


	}

}
