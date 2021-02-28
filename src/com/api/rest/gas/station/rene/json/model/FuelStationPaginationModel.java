package com.api.rest.gas.station.rene.json.model;

public class FuelStationPaginationModel {
	private Integer pageSize;
	private Integer page;
	private Integer total;
	
	public FuelStationPaginationModel() {}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	
}
