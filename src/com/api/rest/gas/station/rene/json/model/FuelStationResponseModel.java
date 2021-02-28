package com.api.rest.gas.station.rene.json.model;

import java.util.List;

public class FuelStationResponseModel {
	
	private FuelStationPaginationModel pagination;
	private List<FuelStationModel> results;
	
	public FuelStationResponseModel() {}
	
	public FuelStationPaginationModel getPagination() {
		return pagination;
	}

	public void setPagination(FuelStationPaginationModel pagination) {
		this.pagination = pagination;
	}

	public List<FuelStationModel> getResults() {
		return results;
	}

	public void setResults(List<FuelStationModel> results) {
		this.results = results;
	}
	
}
