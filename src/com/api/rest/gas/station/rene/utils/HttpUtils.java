package com.api.rest.gas.station.rene.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import com.api.rest.gas.station.rene.http.model.ResponseObject;


public class HttpUtils {
	
	public static String genericHttpClient(String endpoint, String http_method, Map<String, Object> paramRequest) throws Exception {
		String output = "";
		 StringBuilder response = new StringBuilder();
		
		if(endpoint != null && http_method != null) {
			
			URL url = new URL(endpoint);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestProperty("Accept", "application/json");
	        
			switch(http_method) {
				case "GET":
					conn.setRequestMethod(http_method);
				break;
				default:
				
			}
			if (conn.getResponseCode() != 200) {
	            throw new RuntimeException("Failed : HTTP error code : "
	                    + conn.getResponseCode());
	        }
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		    while ((output = reader.readLine()) != null){
		            response.append(output).append('\r');
		    }
		    reader.close();
		}
		return response.toString();
	}
	
	public static ResponseObject getGenericResponse(String error, String message, Boolean success) {
		
		ResponseObject response = new ResponseObject();
		response.setError(error);
		response.setMessage(message);
		response.setSuccess(success);
		return response;
		
	}
}
