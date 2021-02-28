package com.api.rest.gas.station.rene.data.operations.facade;

import com.api.rest.gas.station.rene.json.model.FuelStationModel;

public interface DataOperationsFacade {
	public void insertFuelStationService(FuelStationModel model) throws Exception;
}
