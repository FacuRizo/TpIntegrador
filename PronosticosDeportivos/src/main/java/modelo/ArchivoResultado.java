package modelo;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ArchivoResultado 
{
	// Asignacion de la lectura del archivo CSV de Resultados
	@CsvBindByPosition(position= 0)
	private String NroRonda;
	@CsvBindByPosition(position= 1)
	private String Equipo1;
	@CsvBindByPosition(position= 2)
	private String CantGoles1;
	@CsvBindByPosition(position= 3)
	private String CantGoles2;
	@CsvBindByPosition(position= 4)
	private String Equipo2;
	@CsvBindByPosition(position= 5)
	private String Fase;
	
	//  NroRonda,equipo1,cantgoles1,cantgoles2,equipo2

	
}
