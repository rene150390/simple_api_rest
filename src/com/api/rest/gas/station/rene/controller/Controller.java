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
	
	//Endpoint de prueba
	@GET  
    public Response sayHello() {
		
		Map<String, Object> response = new HashMap<>();
		response.put("si", "si");
        return Response.ok(response, MediaType.APPLICATION_JSON).build();   
    }
	
	/*Endpoint http://localhost:8080/gas_station_backend/gas_store/purchase
	 * 
	 * Recibe de parámetros un objeto request del tipo RequestObject que contiene
	 * todos los atributos del request, se validan que los campos vengan y que no estén vacíon ni nulos
	 * de no venir en el request o estar vacíos se manda en el request un mensaje de error.
	 * 
	 * Algunos puntos importantes del funcionamiento y diseño del desarrollo:
	 * 
	 * Se sanitiza el response del web service en caso de caracteres UTF-8 convertirlos a ANSI y no
	 * surgan problemas a la hora de mapear a clases de java ni al procesar los datos.
	 * 
	 * Se utilizan los patrones de diseño Facade y DAO para encapsular la complejidad de la persistencia.
	 * Se utiliza el patrón de diseño Front Controller el mismo controlador puede manejar distintos request y responses.
	 *
	 * */
	@POST
	@Path("/purchase")
    public Response executeoperation(RequestObject request) throws Exception {
		ResponseObject response = new ResponseObject();
		// Validación campos vacío o faltantes
		String message = ValidateUtils.validateRequestEmptyOrInvalidFields(request);
		
		if(message.equals("ok")) {
			//Validación campo amount denbe ser mayor a 1
			message = ValidateUtils.validateRequestAmountField(request);
			if(message.equals("ok")) {
				//Se manda a llamar el servicio web https://api.datos.gob.mx/v1/precio.gasolina.publico
				//y se hace un "sanitizado" de los caracteres en codificación UTF-8
				String webServiceResponse = EncodeUtils.removeUTF8(HttpUtils.genericHttpClient("https://api.datos.gob.mx/v1/precio.gasolina.publico", "GET", null));
				if(webServiceResponse != null) {
					//Se procesa el resultado para seleccionar el elemento con el id indicado en el request
					FuelStationModel fuelStationModel = HandleRequestUtils.handleResult(webServiceResponse, request.getGasStation());
					dataOperationsFacadeImpl = new DataOperationsFacadeImpl();
					//Se persiste en la base de datos
					dataOperationsFacadeImpl.insertFuelStationService(fuelStationModel);
					//Se genera un response exitoso
					response = HttpUtils.getGenericResponse("", "Ok", true);
				} else {
					//Se genera un response con error
					response = HttpUtils.getGenericResponse("El servicio web regresó una respuesta vacía", "El servicio web regresó una respuesta vacía", false);
				}
			} else {
				//Se genera un response con error
				response = HttpUtils.getGenericResponse(message, message, false);
			}
		} else {
			//Se genera un response con error
			response = HttpUtils.getGenericResponse(message, message, false);
		}
		return Response.ok(response, MediaType.APPLICATION_JSON).build();   
    }
}
