package modelo;

import com.opencsv.bean.CsvBindByPosition;
//import com.opencsv.bean.CsvDate;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ArchivoPronostico
{
	@CsvBindByPosition(position= 0)
	private String Equipo1;
	@CsvBindByPosition(position= 1)
	private String Gana1;
	@CsvBindByPosition(position= 2)
	private String Empata;
	@CsvBindByPosition(position= 3)
	private String Gana2;
	@CsvBindByPosition(position= 4)
	private String Equipo2;
	
}
