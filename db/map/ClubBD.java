package db.map;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.AdministradorConexion;
import model.Club;

public class ClubBD {
	/**
	 * Obtiene de la base de datos el club con nombre igual al par�metro nombreClub, 
	 *    creando un objeto del tipo model.Club
	 * @param nombreClub
	 * @return
	 */
	public static Club getById(String nombreClub) {
		String query = "SELECT nombreClub FROM club;";
		PreparedStatement ps = null;
		try{
			ps = AdministradorConexion.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			Club res = null;
			while (rs.next()){
				if(rs.getString("nombreClub").equals(nombreClub))
					res = new Club(rs.getString("nombre"), rs.getString("calle"), rs.getInt("numero"), rs.getInt("piso"), rs.getInt("escalera"), rs.getInt("cp"), rs.getString("localidad"), rs.getString("telefono"), rs.getString("personaContacto"));
			}
			return res;
		}catch(SQLException e){
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
