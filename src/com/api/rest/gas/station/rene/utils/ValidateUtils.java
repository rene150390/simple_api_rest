package com.api.rest.gas.station.rene.utils;

import com.api.rest.gas.station.rene.http.model.RequestObject;

public class ValidateUtils {
	
	public static String validateRequestEmptyOrInvalidFields(RequestObject request) {
		
		String message = "ok";
		
		if(request != null) {
			String name = request.getName() == null ? "" : request.getName();
			String email = request.getEmail() == null ? "" :  request.getEmail();
			String lastName = request.getLastName() == null ? "" : request.getLastName();
			String cardNumber = request.getCardNumber() == null ? "" : request.getCardNumber();
			String gasStation = request.getGasStation() == null ? "" : request.getGasStation();
			String sellerName = request.getSellerName() == null ? "" : request.getSellerName();
			
			Integer expirationDateYear = request.getExpirationDateYear() == null ? 0 : request.getExpirationDateYear();
			Integer expirationDateMonth = request.getExpirationDateMonth() == null ? 0 : request.getExpirationDateMonth();
			Integer gasType = (request.getGasType() == null || request.getGasType() < 1  || request.getGasType() > 2 ) ? 0 : request.getGasType();
			
			Double amount = (request.getAmount() == null) ? 0.0 : request.getAmount();
			
			if(name.equals("")) {
				message = "El campo \"name\" no est� presente o est� vac�o";
			} else if(email.equals("")) {
				message = "El campo \"email\" no est� presente o est� vac�o";
			} else if(lastName.equals("")) {
				message = "El campo \"lastName\" no est� presente o est� vac�o";
			} else if(cardNumber.equals("")) {
				message = "El campo \"cardNumber\" no est� presente o est� vac�o";
			} else if(gasStation.equals("")) {
				message = "El campo \"gasStation\" no est� presente o est� vac�o";
			} else if(sellerName.equals("")) {
				message = "El campo \"sellerName\" no est� presente o est� vac�o";
			} else if(gasType == 0) {
				message = "El campo \"gasType\" no est� presente, est� vac�o o es inv�lido";
			} else if(expirationDateYear == 0) {
				message = "El campo \"expirationDateYear\" no est� presente, est� vac�o o es inv�lido";
			} else if(expirationDateMonth == 0) {
				message = "El campo \"expirationDateMonth\" no est� presente, est� vac�o o es inv�lido";
			} else if(amount == 0.0) {
				message = "El campo \"amount\" no est� presente, est� vac�o o es inv�lido";
			}
		} else {
			message = "El request est� vac�o";
		}
		return message;
	}
	
	public static String validateRequestAmountField(RequestObject request) {
		String message = "ok";
		if(request != null) {
			Double amount = request.getAmount() == null ? 0.0 : request.getAmount();
			
			if(amount <= 1.0) {
				message = "El valor del campo \"amount\" debe ser mayor a 1";
			}
		} else {
			message = "El request est� vac�o";
		}
		return message;
	}

}
