package db.stats;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.AdministradorConexion;
import model.Equipo;
import model.Jugador;

public class Estadisticas {
	/**
	 * M�todo que debe devolver el listado de los jugadores que no han estado en ning�n equipo 
	 * en el a�o recibido como par�metro
	 * @param anio
	 * @return
	 */
	public static List<Jugador> getJugadoresNoHanEstadoEnEquipo(int anio){
		String query = "SELECT * FROM jugador WHERE nif NOT IN (SELECT nif_jugador FROM jugador_milita_equipo WHERE ? BETWEEN fecha_inicio AND fecha_fin):";
		PreparedStatement ps = null;
		try{
			ps = AdministradorConexion.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			List<Jugador> jugadores = new ArrayList<Jugador>();
			while(rs.next()){

			}
			return jugadores;
		}catch(SQLException e){
			e.printStackTrace();
			try {
				if (ps!=null && !ps.isClosed())
					ps.close();	
			} catch (SQLException e1) {
				e1.printStackTrace();
				return null;
			}
			return null;
		} 
	}
	
	/**
	 * Metodo que devuelve el numero de equipos del mismo club maximo en los que algun jugador ha estado
	 * @return
	 */
	public static int getNumeroMaximoEquiposDelMismoClubHaEstadoUnJugador(){
		String query = "";
		PreparedStatement ps = null;
		try{
			ps = AdministradorConexion.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			int res = 0;
			while(rs.next()){
				if(rs!=null)
					res++;
			}
			return res;
		} catch(SQLException e){

		}
		return -1;
	}
	
	/**
	 * M�todo que debe devolver el listado de los jugadores que han estado en el mayor n�mero de equipos
	 * del mismo club 
	 * @return
	 */
	public static List<Jugador> getJugadoresMasEquiposMismoClub(){
		// TODO: Implementar
		return null;
	}

	/**
	 * M�todo que debe devolver el listado de los jugadores que han estado en el equipo recibido como
	 * par�metro el a�o (anio)
	 * @param equipo
	 * @param anio
	 * @return
	 */
	public static List<Jugador> getJugadoresEquipoAnio(Equipo equipo, int anio) {
		// TODO: Implementar
		return null;
	}
}
