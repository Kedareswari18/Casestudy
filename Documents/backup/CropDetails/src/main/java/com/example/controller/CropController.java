package com.example.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customexception.CropDetailsNotFoundException;
import com.example.model.Crop;

import com.example.service.CropService;


@RestController
@RequestMapping("/api/crop")
public class CropController {
	
	
	@Autowired
	CropService cropService;
	//save the cropdetails
	
		@PostMapping("/savecrop")
		public Crop save(@RequestBody Crop crop) {
		Crop e = cropService.save(crop);
		return e;

		}

		//find allcropdetails
		@GetMapping("/allcrop")
		public List<Crop> getAll(){
		return cropService.getAllCrop();
		}

		//find the cropdetails by id
		@GetMapping("/allcrop/{CropId}")
		public Optional<Crop> getCropById(@PathVariable  int CropId){
		return cropService.getCropById(CropId);
		}

		//delete the cropdetails by id
		@DeleteMapping("/delcrop/{CropId}")
		public String deleteCrop(@PathVariable int CropId) {
			cropService.deleteCrop(CropId);
		return "Delete cropdetails with id: "+CropId;
		}

		//update the cropdetails by id
		@PutMapping("/update/{CropId}")
		public String updateCrop(@RequestBody Crop crop,@PathVariable int CropId) {
			cropService.getCropById(CropId);
			cropService.save(crop);
		return "Update cropdetails with id: "+CropId;

		}
		
		//find the cropdetails by name
		@GetMapping("/findAllCrops/{cropName}")
		public Optional<Crop> getCropByName(@PathVariable String cropName){
			Optional<Crop> findByCropName=cropService.getCropByName(cropName);
			if(findByCropName.isEmpty())
			{
				throw new CropDetailsNotFoundException("610","The Required crop does not exist in DB");
			}
			else {
			return findByCropName;
			}
		}

		//find the cropdetails by type
				@GetMapping("/findcroptype/{cropType}")
				public Optional<Crop> getCropByType(@PathVariable String cropType){
					Optional<Crop> findByCropType=cropService.getCropByType(cropType);
					if(findByCropType.isEmpty())
					{
						throw new CropDetailsNotFoundException("611","The required crop type does not exist in DB");
					}
					else {
					return findByCropType;
					}
				}
}
