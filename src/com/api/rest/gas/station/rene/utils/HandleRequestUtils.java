package com.api.rest.gas.station.rene.utils;

import java.util.List;

import com.api.rest.gas.station.rene.json.model.FuelStationModel;
import com.api.rest.gas.station.rene.json.model.FuelStationResponseModel;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HandleRequestUtils {
	
	public static FuelStationModel handleResult(String stringResponse, String id) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		FuelStationResponseModel responseModel = mapper.readValue(stringResponse, FuelStationResponseModel.class);
		List<FuelStationModel> models = responseModel.getResults();
		FuelStationModel result = new FuelStationModel();
		
		for(FuelStationModel model : models) {
			if(id.equals(model.get_id())) {
				result.setCalle(model.getCalle());
				result.setColonia(model.getColonia());
				result.setDate_insert(model.getDate_insert());
				result.setRegular(model.getRegular());
				result.setNumeropermiso(model.getNumeropermiso());
				result.setPermisoid(model.getPermisoid());
				result.setLatitude(model.getLatitude());
				result.setLongitude(model.getLongitude());
				result.setPremium(model.getPremium());
				result.setRazonsocial(model.getRazonsocial());
				result.setCodigopostal(model.getCodigopostal());
				result.setDieasel(model.getDieasel());
				result.setFechaaplicacion(model.getFechaaplicacion());
				result.setRfc(model.getRfc());
				result.setId_gass(model.get_id());
			}
		}
		
		return result;
	}

}
