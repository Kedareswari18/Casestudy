package com.example.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document (collection="CropDetails")
public class Crop {
	@Id
	 private int cropId;    
	 private String cropType;
	 private String cropName;
	 private String cropPrice;
	 private String cropQuantity;
	 private String uploaded_by;
	 private location location;
	 
	 
	 @Override
	public String toString() {
	    return "Crop [cropId=" + cropId + ", cropType=" + cropType + ", cropName=" + cropName + ", cropPrice=" + cropPrice
	            + ", cropQuantity=" + cropQuantity + ", uploaded_by=" + uploaded_by + ", location=" + location + "]";
	}
	 
	 
	//Construcor is created with field
	public Crop(int cropId, String cropName, String cropPrice, String cropType, String cropQuantity,
	        com.example.model.location location, String uploaded_by) {
	    super();
	    this.cropId = cropId;
	    this.cropName = cropName;
	    this.cropPrice = cropPrice;
	    this.cropType = cropType;
	    this.cropQuantity = cropQuantity;
	    this.location = location;
	    this.uploaded_by = uploaded_by;
	}
	 
	 
	//Constructor is created from superclass
	public Crop() {
	    super();
	}
	 

	//getters and setters are created
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
	public String getCropPrice() {
	    return cropPrice;
	}
	public void setCropPrice(String cropPrice) {
	    this.cropPrice = cropPrice;
	}
	public String getCropType() {
	    return cropType;
	}
	public void setCropType(String cropType) {
	    this.cropType = cropType;
	}
	public String getCropQuantity() {
	    return cropQuantity;
	}
	public void setCropQuantity(String cropQuantity) {
	    this.cropQuantity = cropQuantity;
	}
	public location getLocation() {
	    return location;
	}
	public void setLocation(location location) {
	    this.location = location;
	}
	public String getUploaded_by() {
	    return uploaded_by;
	}
	public void setUploaded_by(String uploaded_by) {
	    this.uploaded_by = uploaded_by;
	}
	 
	 



	
	
	
	
	

}
