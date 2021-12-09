package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Crop;

public interface CropService {
	public Crop save( Crop crop);
	public List<Crop> getAllCrop();
	public Optional<Crop> getCropById(int CropId);
	public String deleteCrop( int CropId);
	public String updateCrop( Crop crop, int CropId);
	public Optional<Crop>getCropByName(String cropName);
	public Optional<Crop>getCropByType(String cropType);
}
