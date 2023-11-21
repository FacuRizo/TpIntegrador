package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LectorPronosticoSQL {

	private static Connection conexion = null;
	private static Statement consulta = null;
	private static ArrayList<Pronostico> pronosticoFinal = new ArrayList<>();
	
	public static ArrayList<Pronostico> lectura() {
		
		try {
			// abrir la conexion
			conexion = DriverManager.getConnection(ConectorSQL.DB_URL, ConectorSQL.USER, ConectorSQL.PASS);
						
			// creando statement
			consulta = conexion.createStatement();
						
			// creamos la consulta
			String sql;
						
			sql = "SELECT * FROM pronosticos";
						
			// guardamos el resultado de la consulta
			ResultSet resultado = consulta.executeQuery(sql);
						
			// recorremos resultado
			while(resultado.next()) {
				Equipo equipo1 = new Equipo();
				Equipo equipo2 = new Equipo();
				Partido partido=new Partido();
				Pronostico pronostico= new Pronostico();
				
				equipo1.setNombre(resultado.getString("Equipo_1"));
				partido.setEquipo1(equipo1);
				
				equipo2.setNombre(resultado.getString("Equipo_2"));
				partido.setEquipo2(equipo2);
				
				//settear partido
				pronostico.setPartido(partido);
				pronostico.setParticipante(resultado.getString("Nombre_participante"));
	
				if (resultado.getInt("Gana_1") == 1)
				{
					pronostico.setEquipo(equipo1);
					pronostico.setResultado(ResultadoEnum.Ganador);
					
				}
				else if (resultado.getInt("Empata") == 1)
				{
					pronostico.setEquipo(equipo1);
					pronostico.setResultado(ResultadoEnum.Empate);
				}
				else if (resultado.getInt("Gana_2") == 1) //
				{
					pronostico.setEquipo(equipo2);
					pronostico.setResultado(ResultadoEnum.Ganador);
				}
				
				pronosticoFinal.add(pronostico);
			}
			
			
		} catch (SQLException se) {
			// Execpción ante problemas de conexión
	        se.printStackTrace();
	    } finally {
	            // Esta sentencia es para que ante un problema con la base igual se cierren las conexiones
	            try {
	                if (consulta != null)
	                    consulta.close();
	            } catch (SQLException se2) {
	            	se2.printStackTrace();
	            }
	            try {
	                if (conexion != null)
	                    conexion.close();
	            } catch (SQLException se) {
	                se.printStackTrace();
	            }
	    }
		
		return pronosticoFinal;
	}
}
