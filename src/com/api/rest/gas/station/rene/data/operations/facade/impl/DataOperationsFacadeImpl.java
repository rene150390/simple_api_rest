package com.api.rest.gas.station.rene.data.operations.facade.impl;

import com.api.rest.gas.station.rene.dao.DataOperationsDAO;
import com.api.rest.gas.station.rene.dao.impl.DataOperationsDaoImpl;
import com.api.rest.gas.station.rene.data.operations.facade.DataOperationsFacade;
import com.api.rest.gas.station.rene.json.model.FuelStationModel;

public class DataOperationsFacadeImpl implements DataOperationsFacade{
	
	private DataOperationsDAO dataOperationsImpl;
	
	public void insertFuelStationService(FuelStationModel model) throws Exception {
		if(model != null) {
			dataOperationsImpl = new DataOperationsDaoImpl();
			dataOperationsImpl.saveFuelStation(model);
		}
		
	}
}
