package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LectorResultadoSQL {
	
	private static Connection conexion = null;
	private static Statement consulta = null;
	private static ArrayList<Partido> partidosFinal = new ArrayList<>();
	
	public static ArrayList<Partido> lectura() {
		
		try {
			// abrir la conexion
			conexion = DriverManager.getConnection(ConectorSQL.DB_URL, ConectorSQL.USER, ConectorSQL.PASS);
						
			// creando statement
			consulta = conexion.createStatement();
						
			// creamos la consulta
			String sql;
						
			sql = "SELECT * FROM resultados";
						
			// guardamos el resultado de la consulta
			ResultSet resultado = consulta.executeQuery(sql);
						
			// recorremos resultado
			while(resultado.next()) {
				//inicializamos
				Equipo equipo1 = new Equipo();
				Equipo equipo2 = new Equipo();
				Partido partido = new Partido();
				
				// resultado.getString("Equipo1");
				//seteamos nombre
				equipo1.setNombre(resultado.getString("Equipo1"));
				equipo2.setNombre(resultado.getString("Equipo2"));
				
				//setteamos equipos y goles
				partido.setEquipo1(equipo1);
				partido.setEquipo2(equipo2);
				
				partido.setGolesEquipo1(resultado.getInt("Cant_Goles_1"));
				partido.setGolesEquipo2(resultado.getInt("Cant_Goles_2"));
				
				partido.setNroRonda(resultado.getInt("Nro_Ronda"));
							
				partidosFinal.add(partido);
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
		
		return partidosFinal;
	}
}
