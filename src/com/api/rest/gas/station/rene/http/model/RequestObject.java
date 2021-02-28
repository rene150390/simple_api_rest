package com.api.rest.gas.station.rene.http.model;

public class RequestObject {
	
	private String email;

    private String name;

    private String lastName;

    private String cardNumber;

    private Integer expirationDateYear;

    private Integer expirationDateMonth;

    private Integer gasType;

    private Double amount;
    
    private String gasStation;
    
    private String sellerName;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getExpirationDateYear() {
        return expirationDateYear;
    }

    public void setExpirationDateYear(Integer expirationDateYear) {
        this.expirationDateYear = expirationDateYear;
    }

    public Integer getExpirationDateMonth() {
        return expirationDateMonth;
    }

    public void setExpirationDateMonth(Integer expirationDateMonth) {
        this.expirationDateMonth = expirationDateMonth;
    }

    public Integer getGasType() {
        return gasType;
    }

    public void setGasType(Integer gasType) {
        this.gasType = gasType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getGasStation() {
        return gasStation;
    }

    public void setGasStation(String gasStation) {
        this.gasStation = gasStation;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

}
