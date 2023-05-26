package db.map;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import db.AdministradorConexion;
import model.Jugador;

public class JugadorBD {	
	/**
	 * Obtiene de la base de datos todos los jugador, 
	 *    devolviendo una lista de objetos del tipo model.Jugador
	 * @return
	 */
	public static List<Jugador> getAll() {
		String query = "SELECT * FROM jugador;"; //revisar
		PreparedStatement ps = null;
		try {
			ps = AdministradorConexion.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			List<Jugador> jugadores = new ArrayList<Jugador>();
			while(rs.next()){
				jugadores.add(new Jugador(rs.getString("nif"), rs.getString("nombre"), rs.getString("apellido_1"), rs.getString("apellido_2"), rs.getDate("fecha_nacimiento").toLocalDate()));
			}
			return jugadores;
		}catch (SQLException e) {
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
	 * Obtiene de la base de datos el jugador con nif igual al par�metro nifJugador, 
	 *    creando un objeto del tipo model.Jugador
	 * @param nifJugador
	 * @return
	 */
	public static Jugador getById(String nifJugador) {
		String query = "SELECT nif FROM jugador;"; //revisar
		PreparedStatement ps = null;
		try{
			ps = AdministradorConexion.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			Jugador res = null;
			while(rs.next()){
				if(rs.getString("nif").equals(nifJugador))
					res = new Jugador(rs.getString("nif"), rs.getString("nombre"), rs.getString("apellido_1"), rs.getString("apellido_2"), rs.getDate("fecha_nacimiento").toLocalDate());
			}
			return res;
		} catch (SQLException e){
			e.printStackTrace();
			try{
				if(ps!=null && !ps.isClosed())
					ps.close();
			} catch (SQLException e1){
				e1.printStackTrace();
				return null;
			}
			return null;
		}
	}
	
}
