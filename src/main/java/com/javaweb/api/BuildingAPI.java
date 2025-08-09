package com.javaweb.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.customException.FieldRequiredException;
import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.entity.EntitySearchCriteria;
import com.javaweb.service.BuildingService;

@RestController
public class BuildingAPI {
	@Autowired
	private BuildingService buildingService;
	
	//execute and give to front-end
//	@PostMapping(value = "/api/building/")
//	public List<BuildingDTO> getBuilding (@RequestParam(value ="name") String name){
//		List<BuildingDTO> result = buildingService.findAll(name);
//		return result;
//	}
	
//	@GetMapping(value = "/api/building/")
//	public List<BuildingDTO> getBuilding (
//			@RequestParam(value = "name", required = false) String name,
//			@RequestParam(value = "districtId", required = false) Long districtId,
//			@RequestParam(value = "typeCode", required = false) List<String> typeCode
//			){
//		List<BuildingDTO> result = buildingService.findAll(name, districtId, typeCode);
//		return result;
//	}
//	
//	@GetMapping(value = "api/buildings/")
//	public List<BuildingDTO> getBuildingByArea(@RequestParam(value = "area") Long Area){
//		List<BuildingDTO> result = buildingService.findBuildingByArea(Area);
//		return result;
//	}
	
	@GetMapping(value = "/api/buildings/search/")
	public List<BuildingDTO> findBuildings(@ModelAttribute EntitySearchCriteria entitySearchCriteria) {
		List<BuildingDTO> result = new ArrayList<>();
		result = buildingService.findBuildings(entitySearchCriteria);
		return result;
	}
	
	
	public void valiDate(BuildingDTO buildingDTO) throws FieldRequiredException{
		if (buildingDTO.getName() == null || buildingDTO.getName().isEmpty()) {
			throw new FieldRequiredException("name is null");
		} else if (buildingDTO.getNumberOfBasement() == null) {
			throw new FieldRequiredException("number of base ment is null");
		}
	}
	
}
