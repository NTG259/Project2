package com.javaweb.service;

import java.util.List;

import com.javaweb.model.BuildingDTO;
//interface only has 2 things : abstract method
public interface BuildingService {
	//abstract method
	List<BuildingDTO> findAll(String name, Long districtId, List<String> typeCode);
	void DeleteById(Integer id);
	List<BuildingDTO> findBuildingByArea(Long Area);
}
