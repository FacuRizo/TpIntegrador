package modelo;
/*
 *  Excepcion dada en caso de columnas incorrectas
 */

public class ColumnasIncorrectasException extends Exception 
	{

		private static final long serialVersionUID = 1L;

		public ColumnasIncorrectasException() {
		    super();
		}

		public ColumnasIncorrectasException(String message) {
		    super(message);
		}
	}



