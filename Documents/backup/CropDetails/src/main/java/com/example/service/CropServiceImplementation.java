package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customexception.CropDetailsNotFoundException;
import com.example.customexception.EmptyInputException;
import com.example.model.Crop;
import com.example.repository.CropRepository;
@Service
public class CropServiceImplementation implements CropService {
	@Autowired
	private CropRepository cropRepository;
	
	//save the cropdetails
	@Override
	public Crop save( Crop crop) {
		if(crop.getCropName().isBlank() || crop.getCropName().length()==0)
		{
			throw new EmptyInputException("601","Input Field Is Blank");
		}
	Crop e = cropRepository.save(crop);
	return e;

	}

	//find all cropdetails
	@Override
	public List<Crop> getAllCrop(){
		List<Crop> crops= cropRepository.findAll();
		if(crops.isEmpty())
		{
			throw new EmptyInputException("700","Crop List Does Not Exist");
		}
		else
		{
			return crops;
		}
	}

	//find the cropdetails by id
	@Override
	public Optional<Crop> getCropById(int CropId){
		Optional<Crop> findById=cropRepository.findById(CropId);
		if(findById.isEmpty())
		{
			throw new CropDetailsNotFoundException("602","Input Field Is Empty");
		}
		else {
		return findById;
		}
	}

	//delete the cropdetails by id
	@Override
	public String deleteCrop( int CropId) {
		boolean isPresent=cropRepository.existsById(CropId);
		if(isPresent)
		{
			cropRepository.deleteById(CropId);
			return "Delete cropdetails with id: "+CropId;
		}
		else
		{
			throw new CropDetailsNotFoundException("603","Data is not found DB");
		}
		
	}

	//update the cropdetails by id
	@Override
	public String updateCrop( Crop crop, int CropId) {
		boolean isPresent=cropRepository.existsById(CropId);
		if(isPresent)
		{
			cropRepository.save(crop);
			return "Update cropdetails with id: "+CropId;

			
		}
		else
		{
			throw new CropDetailsNotFoundException("604","Data not existing in DB");
		}
	}
	
	//find the cropdetails by name
	@Override
	public Optional<Crop>getCropByName(String cropName){
	return cropRepository.findByCropName( cropName);
	}
	
	//find the cropdetails by type
		@Override
		public Optional<Crop>getCropByType(String cropType){
		return cropRepository.findByCropType( cropType);
		}

}
