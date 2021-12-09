package com.example.model;



public class location {
	
	private String Street;
	private String Village;
	private String City;
	private String State;
	private String PinCode;
	
	
	
	public location() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "location [Street=" + Street + ", Village=" + Village + ", City=" + City + ", State=" + State
				+ ", PinCode=" + PinCode + "]";
	}
	public location(String Street, String Village, String City, String State, String PinCode) {
		super();
		this.Street = Street;
		this.Village = Village;
		this.City = City;
		this.State = State;
		this.PinCode = PinCode;
	}
	

	public String getStreet() {
		return Street;
	}
	public void setStreet(String Street) {
		this.Street = Street;
	}
	public String getVillage() {
		return Village;
	}
	public void setVillage(String Village) {
		this.Village = Village;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String City) {
		this.City = City;
	}
	public String getState() {
		return State;
	}
	public void setState(String State) {
		this.State = State;
	}
	public String getPinCode() {
		return PinCode;
	}
	public void setPinCode(String PinCode) {
		this.PinCode = PinCode;
	}
	
	

}
