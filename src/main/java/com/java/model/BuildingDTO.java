package com.java.model;


public class BuildingDTO {
	private String buildingName;
	private String address;
	private int numberOfBasement;
	private String managerName;
	private String managerNumberPhone;
	private int floorArea;
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(int numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerNumberPhone() {
		return managerNumberPhone;
	}
	public void setManagerNumberPhone(String managerNumberPhone) {
		this.managerNumberPhone = managerNumberPhone;
	}
	public int getFloorArea() {
		return floorArea;
	}
	public void setFloorArea(int floorArea) {
		this.floorArea = floorArea;
	}
	
}
