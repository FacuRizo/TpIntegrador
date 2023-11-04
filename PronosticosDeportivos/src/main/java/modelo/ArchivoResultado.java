package modelo;

import com.opencsv.bean.CsvBindByPosition;
//import com.opencsv.bean.CsvDate;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ArchivoResultado 
{
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
	
	//  NroRonda,equipo1,cantgoles1,cantgoles2,equipo2

	
}
