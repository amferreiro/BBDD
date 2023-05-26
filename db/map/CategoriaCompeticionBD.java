package db.map;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.AdministradorConexion;
import model.CategoriaCompeticion;

public class CategoriaCompeticionBD {
	/**
	 * 
	 * @param categoriaCompeticion
	 * @return Obtiene de la base de datos la categor�a de competici�n con id igual al par�metro categoriaCompeticion, 
	 *    creando un objeto del tipo model.CategoriaCompeticion
	 */
	public static CategoriaCompeticion getById(int categoriaCompeticion) {
		String query = "SELECT * FROM catergoria_competicion;";
		PreparedStatement ps = null;
		try{
			ps = AdministradorConexion.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			CategoriaCompeticion res = null;
			while (rs.next()){
				if(rs.getInt("id")==categoriaCompeticion)
					res = new CategoriaCompeticion(rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("numero_max_equipos"));
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
