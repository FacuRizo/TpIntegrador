package modelo;

import com.opencsv.bean.CsvBindByPosition;
//import com.opencsv.bean.CsvDate;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ArchivoResultado 
{
	@CsvBindByPosition(position= 0)
	private String Equipo1;
	@CsvBindByPosition(position= 1)
	private Integer CantGoles1;
	@CsvBindByPosition(position= 2)
	private Integer CantGoles2;
	@CsvBindByPosition(position= 3)
	private String Equipo2;
	
	// equipo1,cantgoles1,cantgoles2,equipo2

	
}
