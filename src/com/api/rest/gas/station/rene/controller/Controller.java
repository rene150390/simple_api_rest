package com.api.rest.gas.station.rene.controller;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.api.rest.gas.station.rene.data.operations.facade.DataOperationsFacade;
import com.api.rest.gas.station.rene.data.operations.facade.impl.DataOperationsFacadeImpl;
import com.api.rest.gas.station.rene.http.model.RequestObject;
import com.api.rest.gas.station.rene.http.model.ResponseObject;
import com.api.rest.gas.station.rene.json.model.FuelStationModel;
import com.api.rest.gas.station.rene.utils.EncodeUtils;
import com.api.rest.gas.station.rene.utils.HandleRequestUtils;
import com.api.rest.gas.station.rene.utils.HttpUtils;
import com.api.rest.gas.station.rene.utils.ValidateUtils;

@Path("/gas_store") 
@Produces(MediaType.APPLICATION_JSON) 
@Consumes(MediaType.APPLICATION_JSON) 
public class Controller {
	
	private DataOperationsFacade dataOperationsFacadeImpl;
	
	@GET  
    public Response sayHello() {
		
		Map<String, Object> response = new HashMap<>();
		response.put("si", "si");
        return Response.ok(response, MediaType.APPLICATION_JSON).build();   
    }
	
	@POST
	@Path("/purchase")
    public Response executeoperation(RequestObject request) throws Exception {
		ResponseObject response = new ResponseObject();
		String message = ValidateUtils.validateRequestEmptyOrInvalidFields(request);
		
		if(message.equals("ok")) {
			message = ValidateUtils.validateRequestAmountField(request);
			if(message.equals("ok")) {
				String webServiceResponse = EncodeUtils.removeUTF8(HttpUtils.genericHttpClient("https://api.datos.gob.mx/v1/precio.gasolina.publico", "GET", null));
				if(webServiceResponse != null) {
					FuelStationModel fuelStationModel = HandleRequestUtils.handleResult(webServiceResponse, request.getGasStation());
					dataOperationsFacadeImpl = new DataOperationsFacadeImpl();
					dataOperationsFacadeImpl.insertFuelStationService(fuelStationModel);
					response = HttpUtils.getGenericResponse("", "Ok", true);
				} else {
					response = HttpUtils.getGenericResponse("El servicio web regresó una respuesta vacía", "El servicio web regresó una respuesta vacía", false);
				}
			} else {
				response = HttpUtils.getGenericResponse(message, message, false);
			}
		} else {
			response = HttpUtils.getGenericResponse(message, message, false);
		}
		return Response.ok(response, MediaType.APPLICATION_JSON).build();   
    }
}
