package db.map;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import db.AdministradorConexion;
import model.Equipo;

public class EquipoBD {
	/**
	 * Obtiene de la base de datos el equipo con licencia igual al par�metro licenciaEquipo, 
	 *    creando un objeto del tipo model.Equipo
	 * @param licenciaEquipo
	 * @return
	 */
	public static Equipo getById(String licenciaEquipo) {
		String query = "SELECT licencia FROM equipo;";
		PreparedStatement ps = null;
		try{
			ps = AdministradorConexion.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			Equipo res = null;
			while (rs.next()){
				if(rs.getString("licencia").equals(licenciaEquipo))
					res = new Equipo(rs.getString("licencia"), rs.getString("nombre"), rs.getInt("telefono"), rs.getString("nombre_club"), rs.getInt("categoria_edad"), rs.getInt("categoria_competicion"));
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
