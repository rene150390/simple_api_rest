package com.api.rest.gas.station.rene.dao;

import com.api.rest.gas.station.rene.json.model.FuelStationModel;

public interface DataOperationsDAO {
	
	public void saveFuelStation(FuelStationModel dbCounter) throws Exception;
	
}
