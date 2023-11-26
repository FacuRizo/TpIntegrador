package modelo;

public class Puntaje {

	private static int puntaje;
	private static int puntajeExtra;

	public static int getPuntaje() {
		return puntaje;
	}

	public static int getPuntajeExtra() {
		return puntajeExtra;
	}

	public static void setPuntaje(int puntaje) {
		Puntaje.puntaje = puntaje;
	}

	public static void setPuntajeExtra(int puntajeExtra) {
		Puntaje.puntajeExtra = puntajeExtra;
	}
	
}
