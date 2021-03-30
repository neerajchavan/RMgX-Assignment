package com.assignment.rmgx.dto;

import java.util.Date;

import com.assignment.rmgx.model.Asset;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AssetDTO {

	private Long id;
	private String category;
	private String name;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date purchaseDate;
	
	private String condition;
	private String status;
	
	private Long assignedTo;
	
	
	public Long getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(Long assignedTo) {
		this.assignedTo = assignedTo;
	}

	public AssetDTO() {

	}
	
	public AssetDTO(Asset asset) {
		
		this.setId(asset.getId());
		this.setName(asset.getName());
		this.setCategory(asset.getCategory().getName());
		this.setPurchaseDate(asset.getPurchaseDate());
		this.setCondition(asset.getCondition());
		this.setStatus(asset.getStatus());
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}