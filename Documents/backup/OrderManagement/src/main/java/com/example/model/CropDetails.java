package com.example.model;

public class CropDetails {
	
	private int cropId;
	private String cropName;



	//Constructor without field
	public CropDetails() {
		super();
	}



	//Constructor with field
	public CropDetails(int cropId, String cropName) {
		super();
		this.cropId = cropId;
		this.cropName = cropName;
	}


	//getters and setters
	public int getCropId() {
		return cropId;
	}



	public void setCropId(int cropId) {
		this.cropId = cropId;
	}



	public String getCropName() {
		return cropName;
	}



	public void setCropName(String cropName) {
		this.cropName = cropName;
	}


	
	
	}


