package com.example;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.customexception.EmptyInputException;
import com.example.model.Crop;
import com.example.model.location;
import com.example.repository.CropRepository;
import com.example.service.CropService;


@RunWith(SpringRunner.class)
@SpringBootTest
class CropDetailsApplicationTests {

	@Autowired
	private CropService cropService;
	
	@MockBean
	private CropRepository cropRepository;
	
	//get All Crop Details
	@Test
	public void getAllCropTest() {
	when(cropRepository.findAll()).thenReturn((List<Crop>) Stream.of
	(new Crop(1,"Mango","Fruits","6kg","700", new location("Arcot Road","Ramapuram","Chennai","Tamil Nadu","630048"),"Kedareswari"),
	new Crop(2,"Radish","Vegetable","5kg","600", new location("Pandurangapuram","Anakapalli","Vizag","Andhra Pradesh","530003"),"Kedareswari")
	).collect(Collectors.toList()));

	assertEquals(2,cropService.getAllCrop().size());
	}

	//add Crop Details
	@Test
	public void addCrop() throws EmptyInputException{
	Crop cropDetails =new Crop(1,"Mango","Fruits","6kg","700", 
			new location("Arcot Road","Ramapuram","Chennai","Tamil Nadu","630048"),"Kedareswari");
	when(cropRepository.save(cropDetails)).thenReturn(cropDetails);
	assertEquals(cropDetails,cropService.save(cropDetails));

	}

}
