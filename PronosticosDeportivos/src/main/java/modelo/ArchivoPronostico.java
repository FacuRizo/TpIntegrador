package modelo;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ArchivoPronostico
{
	@CsvBindByPosition(position= 0)
	private String Participante;
	@CsvBindByPosition(position= 1)
	private String Equipo1;
	@CsvBindByPosition(position= 2)
	private String Gana1;
	@CsvBindByPosition(position= 3)
	private String Empata;
	@CsvBindByPosition(position= 4)
	private String Gana2;
	@CsvBindByPosition(position= 5)
	private String Equipo2;
	
	// Participante ,Equipo 1 , gana1 , empata , gana 2 , equipo2
	
}
