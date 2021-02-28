package com.api.rest.gas.station.rene.dao.impl;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.api.rest.gas.station.rene.dao.DataOperationsDAO;
import com.api.rest.gas.station.rene.json.model.FuelStationModel;


public class DataOperationsDaoImpl implements DataOperationsDAO{
	
	private Connection connect() throws Exception {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream file = classLoader.getResourceAsStream("/db.properties");
		Properties props = new Properties();
		
		props.load(file);
		
		String url = props.getProperty("db.url");
		String user = props.getProperty("db.user");
		String password = props.getProperty("db.pass");
		
		Connection conn = null;
		
		try {
		conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("Aqui error: " + e.toString());
		}
		
		return conn;
	}
	
	@Override
	public void saveFuelStation(FuelStationModel model) throws Exception {
		if(model != null) {
			
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder
				.append("INSERT INTO GAS_STATION (CALLE, RFC, DATE_INSERTED, REGULAR, COLONIA, NUMERO_PERMISO, FECHA_APLICACION, PERMISO_ID, LONGITUDE, "
						+ "LATITUDE, PREMIUM, RAZON_SOCIAL, CODIGO_POSTAL, DIESEL, ID_GASS) ")
				.append("values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			String sql = sqlBuilder.toString();
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = this.connect();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, model.getCalle());
				pstmt.setString(2, model.getRfc());
				pstmt.setString(3, model.getDate_insert());
				pstmt.setString(4, model.getRegular());
				pstmt.setString(5, model.getColonia());
				pstmt.setString(6, model.getNumeropermiso());
				pstmt.setString(7, model.getFechaaplicacion());
				pstmt.setString(8, model.getPermisoid());
				pstmt.setString(9, model.getLongitude());
				pstmt.setString(10, model.getLatitude());
				pstmt.setString(11, model.getPremium());
				pstmt.setString(12, model.getRazonsocial());
				pstmt.setString(13, model.getCodigopostal());
				pstmt.setString(14, model.getDieasel());
				pstmt.setString(15, model.getId_gass());
				pstmt.executeUpdate();
			   
			  } catch (SQLException e) {
				 
			  }finally {
					if(pstmt != null) {
						pstmt.close();
					}
					if(conn != null) {
						conn.close();
					}
			  }
		}
	}
}
