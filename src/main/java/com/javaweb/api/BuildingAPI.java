package com.javaweb.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.customException.FieldRequiredException;
import com.javaweb.model.BuildingDTO;
import com.javaweb.model.ErrorResponseDTO;
import com.javaweb.service.BuildingService;

import java.awt.Taskbar.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PrimitiveIterator.OfDouble;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

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
	
	@GetMapping(value = "/api/building/")
	public List<BuildingDTO> getBuilding (
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "districtId", required = false) Long districtId,
			@RequestParam(value = "typeCode", required = false) List<String> typeCode
			){
		List<BuildingDTO> result = buildingService.findAll(name, districtId, typeCode);
		return result;
	}
	
	public void valiDate(BuildingDTO buildingDTO) throws FieldRequiredException{
		if (buildingDTO.getName() == null || buildingDTO.getName().isEmpty()) {
			throw new FieldRequiredException("name is null");
		} else if (buildingDTO.getNumberOfBasement() == null) {
			throw new FieldRequiredException("number of base ment is null");
		}
	}
	
	@DeleteMapping(value = "/api/building/{id}/{name}/")
	public void deleteBuilding(
			@PathVariable Integer id, 
			@PathVariable String name,
			@RequestParam(value = "ward", required = false) String ward) {
		buildingService.DeleteById(id);
		System.out.println("Da xoa toa nha co id la " + id + " cua " + name + " roi nhe !");
	}
}
